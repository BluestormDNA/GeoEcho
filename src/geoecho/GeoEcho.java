/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho;

import geoecho.controller.ControllerLogin;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author BlueStorm
 */
public class GeoEcho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        defineWindowsLook();
        start();
    }

    private static void defineWindowsLook() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }
    }

    private static void start() {
        SwingUtilities.invokeLater(() -> {
            ControllerLogin controller = new ControllerLogin();
        });
    }

}
