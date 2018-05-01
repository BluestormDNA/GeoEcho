/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

/**
 * Classe UpdateUser que conté el model per actualitzar les dades d'un usuari al sistema
 * @author Dani Machado
 */
public class UpdateUser extends Packet{
    private String username;
    private String password;
    private String email;
    private boolean adminuser;
    private boolean banned;

    /**
     * Constructor per defecte
     */
    public UpdateUser() {
    }
    
    /**
     * Constructor general
     * @param username
     * @param password
     * @param email
     * @param adminuser
     * @param banned 
     */
    public UpdateUser(String username, String password, String email, boolean adminuser, boolean banned) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.adminuser = adminuser;
        this.banned = banned;
    }

    /**
     * Constructor per banejar/desbanejar usuari
     * @param username
     * @param banned 
     */
    public UpdateUser(String username, boolean banned) {
        this.username = username;
        this.banned = banned;
    }

    /**
     *  Getter de username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter de username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter adminuser
     * @return
     */
    public boolean isAdminuser() {
        return adminuser;
    }

    /**
     * Setter admin user
     * @param adminuser
     */
    public void setAdminuser(boolean adminuser) {
        this.adminuser = adminuser;
    }

    /**
     * Getter is banned
     * @return
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Setter banned
     * @param banned
     */
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
   
}
