/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.view;

import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
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
                    GeocoderRequest request = new GeocoderRequest(map);

                    for (Message m : messageList) {
                        request.setAddress(m.getCoordinates().x + " " + m.getCoordinates().y);
                        getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
                            @Override
                            public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
                                if (status == GeocoderStatus.OK) {
                                    map.setCenter(result[0].getGeometry().getLocation());
                                    Marker marker = new Marker(map);
                                    marker.setPosition(result[0].getGeometry().getLocation());

                                    final InfoWindow window = new InfoWindow(map);
                                    window.setContent(m.getText());
                                    window.open(map, marker);
                                    System.out.println("MAPA FINALIZADO CON EXITO");
                                }
                            }
                        });
                    }

                }
            }
        });
    }
}
