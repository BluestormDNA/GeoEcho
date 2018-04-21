/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.view;

import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.swing.MapView;
import static helpers.Constants.PUBLIC;
import java.util.List;
import model.client.Message;

/**
 *
 * @author Pedro Cortes
 */
public class MapPanel extends MapView {

    private Map map;

    /**
     * Carga un mapa del mundo con todos los mensajes de la lista pasada como
     * parametro
     *
     * @param messageList Lista de mensajes a cargar
     */
    public MapPanel(List<Message> messageList) {
        setOnMapReadyHandler((MapStatus status) -> {
            System.out.println("MAPA LISTO");
            if (status == MapStatus.MAP_STATUS_OK) {
                map = getMap();
                map.setZoom(5.0);
                
                update(messageList);
            }
        });
    }

    /**
     * Actualiza en el mapa todos los mensajes pasados como parametro
     * Formateados si son publicos o privados, usuario emisor y receptor
     * seguido del mensaje en su ubicacion según LatLng
     * @param messageList 
     */
    public void update(List<Message> messageList) {
        for (Message m : messageList) {
            LatLng pos = new LatLng(m.getCoordY(), m.getCoordX());

            map.setCenter(pos);
            Marker marker = new Marker(map);
            marker.setPosition(pos);

            final InfoWindow window = new InfoWindow(map);
            window.setContent("<b>" + m.getUserSender() + "  >  "
                    + (m.getUserReceiver() == null ? PUBLIC : m.getUserReceiver())
                    + "</b>    " + m.getDate() + "<br>" + m.getText());
            window.open(map, marker);
        }
    }
}
