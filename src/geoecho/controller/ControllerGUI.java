/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import geoecho.view.GUIForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
class ControllerGUI implements ActionListener {

    private final GUIForm gui;
    private final NetManager net;

    public ControllerGUI() {
        gui = new GUIForm();
        net = new NetManager();
        initializeListener();
    }

    private void initializeListener() {
        gui.getjButtonLogout().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("LOGOUT CLICKADO DESDE CONTROLLER");
    }
}
