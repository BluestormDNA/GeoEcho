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

    /**
     * Envía un objeto del tipo Packet via post
     *
     * @param con HttpURLConnection a utilizar en la conexión
     * @param packet Packet a enviar
     * @return int con el Response Code del envío post http
     * @throws IOException
     */
    public int sendPost(HttpURLConnection con, Packet packet) throws IOException {
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        try (ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream())) {
            out.writeObject(packet);
        }

        return con.getResponseCode();
    }

    /**
     * Devuelve un paquete del servidor
     *
     * @param con HttpURLConnection a utilizar en la conexión
     * @return Packet procedente del servidor
     * @throws IOException
     */
    private Packet getResponse(HttpURLConnection con) throws IOException {
        Packet packet = null;

        try (ObjectInputStream in = new ObjectInputStream(con.getInputStream())) {
            packet = (Packet) in.readObject();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return packet;
    }

    /**
     * Gestiona el login del cliente al servidor
     *
     * @param loginDesk Paquete loginDesk
     * @return int con el sessionID del cliente
     * @throws IOException
     */
    public int handleLogin(LoginDesk loginDesk) throws IOException {
        int id = 0;
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        if (sendPost(con, loginDesk) == OK) {
            Response login = (Response) getResponse(con);
            id = login.getSessionID();
        }
        return id;
    }

    /**
     * Gestiona el logout del cliente en el servidor
     *
     * @param packet Packet class
     * @return true si el paquete ha sido procesado por el servidor
     * @throws IOException
     */
    public boolean sendPacket(Packet packet) throws IOException {
        boolean handled = false;
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        if (sendPost(con, packet) == OK) {
            handled = true;
        }
        return handled;
    }

    public Packet getPacket() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return getResponse(con);
    }

}
