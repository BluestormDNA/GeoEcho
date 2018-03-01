/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.controller;

import geoecho.model.LoginDesk;
import geoecho.view.LoginForm;
import static helpers.Constants.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import net.NetManager;

/**
 *
 * @author Pedro Cortés
 */
public class ControllerLogin implements ActionListener {

    private final LoginForm login;
    private final NetManager net;

    public ControllerLogin() {
        login = new LoginForm();
        login.getjButtonLogin().addActionListener(this);
        net = new NetManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        LoginDesk loginDesk = new LoginDesk();
        loginDesk.setUser(login.getjTextField1().getText());
        loginDesk.setUser(String.valueOf(login.getjPasswordField1().getPassword()));
        
        handle(CLEAR);
        Thread thread = new Thread(() -> {
            try {
                handle(CONNECTING);
                if (net.handleLogin(loginDesk)) {
                    handle(CONNECTED);
                } else {
                    handle(FAILED);
                }
            } catch (IOException e) {
                handle(IOE);
            }
        });
        thread.start();

    }

    public void handle(String msg) {
        JLabel msgLabel = login.getjLabelMsg();
        switch (msg) {
            case CLEAR:
                msgLabel.setText(CLEAR);
                break;
            case CONNECTING:
                msgLabel.setText(CONNECTING);
                break;
            case CONNECTED:
                msgLabel.setText(CONNECTED);
                ControllerGUI controllerGUI = new ControllerGUI();
                login.dispose();
                break;
            case FAILED:
                msgLabel.setText(FAILED);
                break;
            case IOE:
                msgLabel.setText(IOE);
                ControllerGUI temp = new ControllerGUI(); //TEMP
                login.dispose(); //TEMP
                break;
            default:
        }
    }

}
