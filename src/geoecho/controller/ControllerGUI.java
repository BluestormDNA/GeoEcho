/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import geoecho.view.GUIForm;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
class ControllerGUI {

    private final GUIForm gui;
    private final NetManager net;

    public ControllerGUI() {
        gui = new GUIForm();
        net = new NetManager();
    }
}
