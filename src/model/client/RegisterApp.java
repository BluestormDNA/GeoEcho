/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */
package model.client;

/**
 * Classe RegisterApp per registrar usuaris al sistema a través de l'App del model de dades de comunicacions
 * @author Dani Machado
 */
public class RegisterApp extends Packet {
    private String user;
    private String pass;
    private String mail;

    /**
     * Getter del nom d'usuari
     * @return Retorna el nom d'usuari
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter del nom d'usuari
     * @param user Nom d'usuari
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter del Password
     * @return Retorna el password
     */
    public String getPass() {
        return pass;
    }

    /**
     * Setter del Password
     * @param pass Password
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Getter de l'email
     * @return Retorna l'email
     */
    public String getMail() {
        return mail;
    }

    /**
     * Setter de l'email
     * @param mail Email
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
}