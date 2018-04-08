package geoecho.view;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapMouseEvent;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.MouseEvent;
import com.teamdev.jxmaps.swing.MapView;
import javax.swing.JTextArea;
import net.NetManager;

public class MapPanelMarker extends MapView {

    public MapPanelMarker(NetManager net, JTextArea textArea) {
        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(41.38, 2.17));
                    // Setting initial zoom value
                    map.setZoom(9.0);
                    // Creating a new marker object
                    Marker marker = new Marker(map);
                    // Setting marker position
                    marker.setPosition(map.getCenter());
                    // Creating info window, that will be initially displayed on the marker
                    final InfoWindow infoWindow = new InfoWindow(map);

                    // Adding event listener that intercepts clicking on map
                    map.addEventListener("click", new MapMouseEvent() {
                        @Override
                        public void onEvent(MouseEvent mouseEvent) {
                            // Closing initially created info window
                            //infoWindow.close();

                            // Creating a new marker
                            final Marker marker = new Marker(map);

                            // Move marker to the position where user clicked
                            marker.setPosition(mouseEvent.latLng());

                            //Generate Message to server
                            generateAndSendMessageToServer(marker);

                            // Setting info window text
                            infoWindow.setContent(textArea.getText());
                            // Showing info windows under the marker
                            infoWindow.open(map, marker);
                            // Adding event listener that intercepts clicking on marker
                            
                            marker.addEventListener("click", new MapMouseEvent() {
                                @Override
                                public void onEvent(MouseEvent mouseEvent) {
                                    // Removing marker from the map
                                    marker.remove();
                                }
                            });
                        }

                        private void generateAndSendMessageToServer(Marker marker) {
                            //Falta comprobar si esta vacio el textArea
                            net.SendMessage(marker.getPosition().getLng(), marker.getPosition().getLat(), textArea.getText());
                        }
                    });
                }
            }
        });
    }

}
