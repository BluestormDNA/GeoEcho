/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import geoecho.model.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Cortés
 */
public class NetManager {

    private final String URL = "http://localhost:8080/geoechoserv/servdesk";
    private final int OK = 200;

    public int sendPost(HttpURLConnection con, Packet packet) throws IOException {
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        try (ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream())) {
            out.writeObject(packet);
        }

        return con.getResponseCode();
    }

    private Packet getResponse(HttpURLConnection con) throws IOException {
        Packet packet = null;
        con.setDoInput(true);

        try (ObjectInputStream in = new ObjectInputStream(con.getInputStream())) {
            packet = (Packet) in.readObject();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return packet;
    }

    public String handleLogin(LoginDesk loginDesk) throws IOException {
        String id = null;
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        if (sendPost(con, loginDesk) == OK) {
            Response login = (Response) getResponse(con);
            id = login.getSessionID();
        }
        return id;
    }

    public boolean handleLogout(Logout logout) throws IOException {
        boolean deauth = false;
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        if (sendPost(con, logout) == OK) {
            deauth = true;
        }
        return deauth;
    }

}
