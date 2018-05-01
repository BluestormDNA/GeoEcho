/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import geoecho.view.GUIForm;
import geoecho.view.MapPanel;
import geoecho.view.MapPanelMarker;
import geoecho.view.MapPanelPolyLine;
import static helpers.Constants.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.client.*;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
class ControllerGUI extends MouseAdapter implements ActionListener {

    private final GUIForm gui;
    private final NetManager net;

    /**
     * Inicia el controlador de la GUI con el sessionID del login
     *
     * @param id
     */
    public ControllerGUI(NetManager net) {
        gui = new GUIForm();
        this.net = net;
        initializeListener();
    }

    /**
     * Inicializa los listeners de la GUI
     */
    private void initializeListener() {
        gui.getjButtonLogout().addActionListener(this);
        gui.getjButtonSearchUser().addActionListener(this);
        gui.getjButtonPolySearch().addActionListener(this);
        gui.getjToggleButtonBanUser().addActionListener(this);
        gui.getjPanelBUser().addMouseListener(this);
        gui.getjPanelBWorld().addMouseListener(this);
        gui.getjPanelBStatistic().addMouseListener(this);
        gui.getjPanelBPolyLine().addMouseListener(this);
        gui.getjPanelBMarker().addMouseListener(this);
    }

    /**
     * Gestiona el boton del logout enviando un paquete logout que si es OK
     * reinicia el login
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Thread thread = new Thread(() -> {
            if (ae.getSource().equals(gui.getjButtonLogout())) {
                handleLogout();
            } else if (ae.getSource().equals(gui.getjButtonSearchUser())) {
                handleUserSearch();
            } else if (ae.getSource().equals(gui.getjButtonPolySearch())) {
                handlePolyLine();
            } else if (ae.getSource().equals(gui.getjToggleButtonBanUser())) {
                handleBan();
            }
        });
        thread.start();
    }

    /**
     * Inicializa el panel seleccionado
     *
     * @param evt
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        Thread thread = new Thread(() -> {
            if (evt.getSource().equals(gui.getjPanelBWorld())) {
                handleWorldPanel();
            } else if (evt.getSource().equals(gui.getjPanelBUser())) {
                handleUserPanel();
            } else if (evt.getSource().equals(gui.getjPanelBStatistic())) {
                handleStatisticsPanel();
            } else if (evt.getSource().equals(gui.getjPanelBPolyLine())) {
                initializePolyMap();
            } else if (evt.getSource().equals((gui.getjPanelBMarker()))) {
                initializeMarkerMap();
            }
        });
        thread.start();
    }

    /**
     * Pide los datos al servidor del usuario actual y actualiza el panel de
     * usuario con los datos a mostrar
     */
    private void handleUserPanel() {
        ResponseQueryDesk me = net.getFromServer(net.getUser());

        gui.getJlabelUser().setText(me.getUserList().get(0).getUsername());
        gui.getjLabelmail().setText(me.getUserList().get(0).getEmail());
    }

    /**
     * Pide los datos al servidor de todos los usuarios y cuenta las listas
     * actualizando los datos del panel
     */
    private void handleStatisticsPanel() {
        ResponseQueryDesk responseQueryDesk = net.getFromServer(ALL);

        List<Message> messageList = responseQueryDesk.getMessageList();
        List<User> userList = responseQueryDesk.getUserList();

        //24H
        int msgCounterLast24H = 0;
        int userCounterLast24H;

        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DATE, -1);

        Set set = new HashSet();
        for (Message m : messageList) {
            if (m.getDate().after(cal.getTime())) {
                msgCounterLast24H++;
                set.add(m.getUserSender());
            }
        }
        userCounterLast24H = set.size();

        //Update Labels
        gui.getjLabelTotalMessageStatistics().setText(String.valueOf(messageList.size()));
        gui.getjLabelTotalUserStatistics().setText(String.valueOf(userList.size()));
        gui.getjLabelTotalMessageStatistics24H().setText(String.valueOf(msgCounterLast24H));
        gui.getjLabelTotalUserStatistics24H().setText(String.valueOf(userCounterLast24H));
    }

    /**
     * Pide al servidor una lista de mensajes de todos los usuarios y genera un
     * mapa con estos.
     */
    private void handleWorldPanel() {
        List messageList = net.getFromServer(ALL).getMessageList();
        if (gui.getjPanelWorld().getComponents().length == 0) {
            MapPanel map = new MapPanel(messageList);
            gui.getjPanelWorld().add(map);
            gui.getjPanelWorld().validate();
        } else {
            MapPanel map = (MapPanel) gui.getjPanelWorld().getComponent(0);
            map.update(messageList);
        }
    }

    /**
     * Desloguea al usuario y vuelve a ejecutar el form login
     */
    private void handleLogout() {
            Logout logout = new Logout();
            //logout.setSessionID(net.getId());
            if (net.sendPacket(logout)) {
                ControllerLogin login = new ControllerLogin();
                gui.dispose();
            }
    }

    /**
     * Actualiza la UI de la busqueda de usuario: Limpiando las labels, texto y
     * fotografías si las hubiera, pidiendo los datos al servidor y actualizando
     * el panel
     */
    private void handleUserSearch() {
        //Limpia la UI
        gui.getjLabelUserServerInfo().setText(CLEAR);
        gui.getjTextAreaUserMessages().setText(CLEAR);
        for (JLabel l : gui.getjLabelPics()) {
            l.setIcon(null);
        }
        // Pide al servidor los datos
        ResponseQueryDesk responseQueryDesk = net.getFromServer(gui.getjTextFieldSearchUser().getText());
        // Comprueba los datos del servidor, si no son validos avisa
        if (responseQueryDesk == null) {
            gui.getjLabelUserServerInfo().setText(USER_NOT_FOUND);
            gui.getjToggleButtonBanUser().setEnabled(false);
        } else {
            //Actualiza la vista del panel con los datos
            User user = responseQueryDesk.getUserList().get(0);
            List<Message> messageList = responseQueryDesk.getMessageList();
            Collections.reverse(messageList);

            gui.getjPanelUserInfo().setVisible(true);
            gui.getjToggleButtonBanUser().setEnabled(true);
            gui.getjToggleButtonBanUser().setSelected(user.isBanned());
            gui.getjLabelUserInfoName().setText(user.getUsername());
            gui.getjLabelUserInfoEmail().setText(user.getEmail());
            gui.getjLabelUserInfoType().setText(user.isAdminuser() ? ADMIN : USER_BASE);
            gui.getjLabelUserInfoTotalMessages().setText(String.valueOf(messageList.size()));

            for (Message m : messageList) {
                gui.getjTextAreaUserMessages().append(m.getText() + NEW_LINE);
                if (m.getPhotoBase64() != null) {
                    {
                        for (JLabel l : gui.getjLabelPics()) {
                            if (l.getIcon() == null) {
                                l.setIcon(generateImage(m));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Pide los datos al servidor y genera un mapa con el trazado de los
     * mensajes del usuario
     */
    private void handlePolyLine() {
        gui.getjLabelPolyInfoServer().setText(CLEAR);

        ResponseQueryDesk responseQueryDesk = net.getFromServer(gui.getjTextFieldPoly().getText());

        if (responseQueryDesk == null) {
            gui.getjLabelPolyInfoServer().setText(USER_NOT_FOUND);
        } else {
            List<Message> messageList = responseQueryDesk.getMessageList();
            MapPanelPolyLine map = (MapPanelPolyLine) gui.getjPanelPolyLineMap().getComponent(0);
            map.generatePolyLine(messageList);
        }

    }

    /**
     * Genera un Icono para un JLabel partiendo del codigo Base64 de un Mensaje
     * reescalando la imagen resultante
     *
     * @param m Objeto mensaje del que sacar la imagen Base64
     * @return Icono para JLabel
     */
    private Icon generateImage(Message m) {
        BufferedImage image = null;
        try {
            byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(m.getPhotoBase64());
            image = ImageIO.read(new ByteArrayInputStream(btDataFile));

        } catch (IOException ex) {
            Logger.getLogger(ControllerGUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return new ImageIcon(image.getScaledInstance(188, 104, 0));
    }

    /**
     * Inicializa el Mapa a usar en el trazado de rutas
     */
    private void initializePolyMap() {
        if (gui.getjPanelPolyLineMap().getComponents().length == 0) {
            gui.getjPanelPolyLineMap().add(new MapPanelPolyLine());
            gui.getjPanelPolyLineMap().validate();
        }
    }

    /**
     * Inicializa el Mapa a usar en el emisor de mensajes
     */
    private void initializeMarkerMap() {
        if (gui.getjPanelMapSender().getComponents().length == 0) {
            gui.getjPanelMapSender().add(new MapPanelMarker(net, gui));
            gui.getjPanelMapSender().validate();
        }
    }

    private void handleBan() {
        String user = gui.getjTextFieldSearchUser().getText();
        if (gui.getjToggleButtonBanUser().isSelected()) {
            net.sendPacket(new UpdateUser(user, true));
            System.out.println("BANNED");
        } else {
            net.sendPacket(new UpdateUser(user, false));
            System.out.println("UN BANNED");
        }
    }

}
