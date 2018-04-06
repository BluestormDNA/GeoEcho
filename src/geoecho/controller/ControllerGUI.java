/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import com.teamdev.jxmaps.MapViewOptions;
import geoecho.view.GUIForm;
import geoecho.view.MapPanel;
import static helpers.Constants.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        gui.getjPanelBUser().addMouseListener(this);
        gui.getjPanelBWorld().addMouseListener(this);
        gui.getjPanelBStatistic().addMouseListener(this);
        gui.getjPanelBConfig().addMouseListener(this);
        gui.getjPanelBMarker().addMouseListener(this);
        gui.getjPanelBPolyLine().addMouseListener(this);
    }

    /**
     * Gestiona el boton del logout enviando un paquete logout que si es OK
     * reinicia el login
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(gui.getjButtonLogout())) {
            handleLogout();
        } else if (ae.getSource().equals(gui.getjButtonSearchUser())) {
            handleUserSearch();
        }

    }

    /**
     * Inicializa el panel seleccionado
     *
     * @param evt
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource().equals(gui.getjPanelBWorld())) {
            handleWorldPanel();
        } else if (evt.getSource().equals(gui.getjPanelBUser())) {
            handleUserPanel();
        } else if (evt.getSource().equals(gui.getjPanelBStatistic())) {
            handleStatisticsPanel();
        } else if (evt.getSource().equals(gui.getjPanelBConfig())) {
            //Implementado via botones borrar esto
        } else if (evt.getSource().equals(gui.getjPanelBMarker())) {
            // Ha implementar via botones
        } else if (evt.getSource().equals(gui.getjPanelBPolyLine())) {
            //TODO boton enviar con el usuario que decida el textBox
        }
    }

    private void handleUserPanel() {
        ResponseQueryDesk me = net.getFromServer(net.getUser());
        System.out.println(me);
        System.out.println(me.getUserList());
        System.out.println(me.getUserList().get(0));
        gui.getJlabelUser().setText(me.getUserList().get(0).getUsername());
        gui.getjLabelmail().setText(me.getUserList().get(0).getEmail());
    }

    private void handleStatisticsPanel() {
        ResponseQueryDesk responseQueryDesk = net.getFromServer(ALL);

        List<Message> messageList = responseQueryDesk.getMessageList();
        List<User> userList = responseQueryDesk.getUserList();

        String msgCounter = String.valueOf(messageList.size());
        String userCounter = String.valueOf(userList.size());

        gui.getjLabelTotalMessageStatistics().setText(msgCounter);
        gui.getjLabelTotalUserStatistics().setText(userCounter);
    }

    private void handleWorldPanel() {
        List messageList = net.getFromServer(ALL).getMessageList();
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        gui.getjPanelWorld().add(new MapPanel(options, messageList));
    }

    private void handleLogout() {
        try {
            Logout logout = new Logout();
            logout.setSessionID(net.getId());
            if (net.sendPacket(logout)) {
                ControllerLogin login = new ControllerLogin();
                gui.dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleUserSearch() {
        gui.getjLabelUserServerInfo().setText(CLEAR);
        gui.getjTextAreaUserMessages().setText(CLEAR);
        
        ResponseQueryDesk responseQueryDesk = net.getFromServer(gui.getjTextFieldSearchUser().getText());

        if (responseQueryDesk == null) {
            gui.getjLabelUserServerInfo().setText(USER_NOT_FOUND);
        } else {
            User user = responseQueryDesk.getUserList().get(0);
            List<Message> messageList = responseQueryDesk.getMessageList();

            gui.getjPanelUserInfo().setVisible(true);
            gui.getjLabelUserInfoName().setText(user.getUsername());
            gui.getjLabelUserInfoEmail().setText(user.getEmail());
            gui.getjLabelUserInfoType().setText(user.isAdminuser() ? ADMIN : USER_BASE);
            gui.getjLabelUserInfoTotalMessages().setText(String.valueOf(messageList.size()));
            
            for(Message m : messageList){
            gui.getjTextAreaUserMessages().append(m.getText() + NEW_LINE);
            }

        }
    }

}
