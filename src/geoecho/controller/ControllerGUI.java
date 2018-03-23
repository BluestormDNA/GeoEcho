/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import com.teamdev.jxmaps.MapViewOptions;
import model.client.Logout;
import geoecho.view.GUIForm;
import geoecho.view.MapPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.client.QueryDesk;
import model.client.User;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
class ControllerGUI extends MouseAdapter implements ActionListener {

    private final GUIForm gui;
    private final NetManager net;
    private final int id;

    /**
     * Inicia el controlador de la GUI con el sessionID del login
     *
     * @param id
     */
    public ControllerGUI(int id) {
        gui = new GUIForm();
        net = new NetManager();
        this.id = id;
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
            logout.setSessionID(id);
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
        } else if(evt.getSource().equals(gui.getjPanelBPolyLine())){
            //TODO BOTON????
        }
    }

    private void handleUserPanel() {
        JLabel user = gui.getJlabelUser();
        JLabel email = gui.getjLabelmail();
        QueryDesk queryDesk = new QueryDesk();
        queryDesk.setSessionID(id);

        try {
            if (net.sendPacket(queryDesk)) {
                User userPacket = (User) net.getPacket();
                user.setText(userPacket.getUsername());
                email.setText(userPacket.getEmail());
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleStatisticsPanel() {
        //TODO Hablar con Machado a ver si puede enviarme los datos
    }

    private void handleWorldPanel() {
        
        
        
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        gui.getjPanelWorld().add(new MapPanel(options));
    }

    private void handleMarkerPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
