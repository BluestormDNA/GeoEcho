package geoecho.view;

import com.teamdev.jxmaps.Animation;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;

import model.client.Message;
import java.util.List;

public class MapPanelPolyLine extends MapView {

    Map map;

    public MapPanelPolyLine() {
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                if (status == MapStatus.MAP_STATUS_OK) {
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting the map center
                    //map.setCenter(new LatLng(40, 24));
                    // Setting initial zoom value
                    map.setZoom(5.0);
                }
            }
        });

    }

    private LatLng[] generatePath(List<Message> messageList) {
        LatLng[] latlng = new LatLng[messageList.size()];
        for (int i = 0; i < messageList.size(); i++) {
            Message m = messageList.get(i);
            latlng[i] = new LatLng(m.getCoordY(), m.getCoordX());
            if (i == messageList.size() - 1) {
                map.setCenter(new LatLng(m.getCoordY(), m.getCoordX()));
                Marker marker = new Marker(map);
                marker.setAnimation(Animation.BOUNCE);
                marker.setPosition(new LatLng(m.getCoordY(), m.getCoordX()));

            }
        }
        return latlng;
    }

    public void generatePolyLine(List<Message> messageList) {
        map.setZoom(14.0);
        // Creating a path (array of coordinates) that represents a polyline
        LatLng[] path = generatePath(messageList);
        // Creating a new polyline object
        Polyline polyline = new Polyline(map);
        // Initializing the polyline with created path
        polyline.setPath(path);
        // Creating a polyline options object
        PolylineOptions options = new PolylineOptions();
        // Setting geodesic property value
        options.setGeodesic(true);
        // Setting stroke color value
        options.setStrokeColor("#0000FF");
        // Setting stroke opacity value
        options.setStrokeOpacity(1.0);
        // Setting stroke weight value
        options.setStrokeWeight(2.0);
        // Applying options to the polyline
        polyline.setOptions(options);
    }

}
