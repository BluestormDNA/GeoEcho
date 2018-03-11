/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import model.client.Packet;
import model.client.Response;
import model.client.Logout;
import model.client.LoginDesk;
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

    private final String URL = "http://ec2-52-31-205-76.eu-west-1.compute.amazonaws.com/geoechoserv";
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
        
        try (ObjectInputStream in = new ObjectInputStream(con.getInputStream())) {
            packet = (Packet) in.readObject();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return packet;
    }

    public int handleLogin(LoginDesk loginDesk) throws IOException {
        int id = 0;
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        if (sendPost(con, loginDesk) == OK) {
            Response login = (Response) getResponse(con);
            System.out.println("OK 200 del Servidor");
            System.out.println(login);
            System.out.println("ID del paquete");
            System.out.println(login.getSessionID());
            id = login.getSessionID();
            System.out.println("ID local de la funcion");
            System.out.println(id);
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
