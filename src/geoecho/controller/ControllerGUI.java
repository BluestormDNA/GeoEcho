/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import model.client.Logout;
import geoecho.view.GUIForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
class ControllerGUI implements ActionListener {

    private final GUIForm gui;
    private final NetManager net;
    private final int id;

    public ControllerGUI(int id) {
        gui = new GUIForm();
        net = new NetManager();
        this.id =  id;
        initializeListener();
    }

    private void initializeListener() {
        gui.getjButtonLogout().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Logout logout = new Logout();
            logout.setSessionID(id);
            if (net.handleLogout(logout)) {
                ControllerLogin login = new ControllerLogin();
                gui.dispose();
            }
        } catch (IOException ex) {
            //Logger.getLogger(ControllerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
