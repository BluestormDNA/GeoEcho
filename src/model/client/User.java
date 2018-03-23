/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

/**
 * Classe User que conté el model de l'usuari del sistema
 * @author Dani Machado
 */
public class User extends Packet{
    protected String username;
    protected String password;
    protected String email;
    protected boolean adminuser;
    protected boolean banned;
    
    /**
     * Constructor per defecte
     */
    public User() {
    }

    /**
     * Constructor general
     * @param username
     * @param password
     * @param email
     * @param adminuser
     * @param banned 
     */
    public User(String username, String password, String email, boolean adminuser, boolean banned) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.adminuser = adminuser;
        this.banned = banned;
    }
    
    /**
     * Getter username
     * @return 
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Setter username
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
     * Setter adminuser
     * @param adminuser 
     */
    public void setAdminuser(boolean adminuser) {
        this.adminuser = adminuser;
    }
    
    /**
     * Getter banned
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