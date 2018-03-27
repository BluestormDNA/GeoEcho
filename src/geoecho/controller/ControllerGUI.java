/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import com.teamdev.jxmaps.MapViewOptions;
import geoecho.view.GUIForm;
import geoecho.view.MapPanel;
import static helpers.Constants.ALL;
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
        gui.getjPanelBWorld().addMouseListener(this);
    }

    /**
     * Gestiona el boton del logout enviando un paquete logout que si es OK
     * reinicia el login
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
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

    /**
     * Al clickar en la opcion mapa lo inicializa
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
            //TODO POSIBLE BOTON ?
        } else if (evt.getSource().equals(gui.getjPanelBMarker())) {
            handleMarkerPanel();
        } else if (evt.getSource().equals(gui.getjPanelBPolyLine())) {
            //TODO BOTON????
        }
    }

    private void handleUserPanel() {
        ResponseQueryDesk me = net.getFromServer(net.getUser());
        
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

    private void handleMarkerPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
