/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.view;

import com.teamdev.jxmaps.MapViewOptions;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.client.Message;

/**
 *
 * @author BlueStorm
 */
public class UITEST extends JFrame {

    public static void main(String[] args) {
        UITEST ui = new UITEST();
        ui.setSize(640, 480);
        ui.start();
    }

    private void start() {

        Message msg1 = new Message();
        //msg1.setCoorX(new Point2D.Float(23, 23){});
        msg1.setText("Prueba 1");
        msg1.setCoordX(22.5555f);
        msg1.setCoordY(22.55555f);

        Message msg2 = new Message();
        msg2.setCoordX(23.223f);
        msg2.setCoordY(23.23f);
        msg2.setText("Prueba 2");

        List messageList = new ArrayList<>();
        messageList.add(msg1);
        messageList.add(msg2);

        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        this.add(new MapPanel(options, messageList));
        this.setVisible(true);
    }
}
