/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.view;

import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.swing.MapView;
import java.util.List;
import model.client.Message;

/**
 *
 * @author BlueStorm
 */
public class MapPanel extends MapView {

    public MapPanel(MapViewOptions options, List<Message> messageList) {
        super(options);
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                System.out.println("MAPA LISTO");
                if (status == MapStatus.MAP_STATUS_OK) {
                    final Map map = getMap();
                    map.setZoom(5.0);

                    for (Message m : messageList) {

                        System.out.println(m.getCoordY() + " " + m.getCoordX());
                        LatLng pos = new LatLng(m.getCoordY(), m.getCoordX());

                        map.setCenter(pos);
                        Marker marker = new Marker(map);
                        marker.setPosition(pos);

                        final InfoWindow window = new InfoWindow(map);
                        window.setContent(m.getUserSender() + " > " + m.getUserReceiver()
                                + ": " + m.getText() + "\n" + m.getDate());
                        window.open(map, marker);
                        System.out.println("MAPA FINALIZADO CON EXITO");
                    }
                }
            }

        });
    }
}
