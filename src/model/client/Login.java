/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */
package model.client;

/**
 * Classe abstracta login per entrar al sistema del model de dades a empaquetar en les comunicacions
 * @author Dani Machado
 */
public abstract class Login extends Packet{
    
    private String user;
    private String pass;

    /**
     * Getter del nom d'usuari
     * @return Retorna el nom d'usuari
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter del nom d'usuari
     * @param user Nom de l'usuari
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter del password
     * @return Retorn el password
     */
    public String getPass() {
        return pass;
    }

    /**
     * Setter del password
     * @param pass Password
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
        
}
