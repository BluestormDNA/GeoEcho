/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import model.client.LoginDesk;
import model.client.Message;
import model.client.Packet;
import model.client.QueryDesk;
import model.client.Response;
import model.client.ResponseQueryDesk;

/**
 *
 * @author Pedro Cortés
 */
public class NetManager {

    private final String URL = "https://ec2-52-31-205-76.eu-west-1.compute.amazonaws.com:8443/geoechoserv";

    private String user;
    private int id;

    private URL url;

    public NetManager(){
        try {
            // Creamos un gestor de Certificados válidos
            TrustManager[] trustAllCerts = new TrustManager[]{new NetTrustManager()};

            // Añadimos el gestor de certificados válidos al contexto SSL
            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            // Obtenemos el creador de sockets SSL y lo añadimos al HttpsURLConnection
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Verificamos todos los hostnames
            HostnameVerifier allHostsValid = (String hostname, SSLSession session) -> true;

            // Los añadimos en el HttpsURLConnection
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            // Creamos el objeto URL
            url = new URL(URL);

        } catch (KeyManagementException | NoSuchAlgorithmException | MalformedURLException ex) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envía un objeto del tipo Packet via post
     *
     * @param con HttpURLConnection a utilizar en la conexión
     * @param packet Packet a enviar
     * @return int con el Response Code del envío post http
     * @throws IOException
     */
    public int sendPost(HttpsURLConnection con, Packet packet) throws IOException {
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
    private Packet getPacket(HttpsURLConnection con) throws IOException {
        Packet packet = null;

        try (ObjectInputStream in = new ObjectInputStream(con.getInputStream())) {
            packet = (Packet) in.readObject();
            System.out.println("RECEIVED ");
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
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        if (sendPost(con, loginDesk) == HttpsURLConnection.HTTP_OK) {
            Response login = (Response) getPacket(con);
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
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        if (sendPost(con, packet) == HttpsURLConnection.HTTP_OK) {
            System.out.println("SEND PACKET OK");
            handled = true;
        }
        return handled;
    }

    /**
     * Envia un mensaje con la latitud, longitud y texto definidos
     *
     * @param x longitud
     * @param y latitud
     * @param text mensaje
     */
    public void SendMessage(double x, double y, String text) {
        Message m = new Message((float) x, (float) y, text, null, user, null, new Date(), 10, true, true, false);
        m.setSessionID(id);

        try {
            sendPacket(m);
        } catch (IOException ex) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO SE HA PODIDO ENVIAR EL MENSAJE");
        }
    }

    /**
     * Genera un ResponseQueryDesk del servidor
     *
     * @param user Usuario a buscar especifico o ALL
     * @return ResponseQueryDesk con los datos del usuario pedido
     */
    public ResponseQueryDesk getFromServer(String user) {
        ResponseQueryDesk responsePacket = null;
        QueryDesk queryDesk = new QueryDesk();
        queryDesk.setSessionID(id);
        queryDesk.setUsername(user);
        
        try {
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            if (sendPacket(queryDesk)) {
                System.out.println("inside");
                responsePacket = (ResponseQueryDesk) getPacket(con);
            }
        } catch (IOException ex) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responsePacket;
    }

    /**
     * Inicializa las credenciales una vez logueado
     *
     * @param id SessionID pasado por el server
     * @param user Nombre de usuario local
     */
    public void initializeCredential(int id, String user) {
        this.id = id;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

}
