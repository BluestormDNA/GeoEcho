/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

/**
 * Classe QueryDesk que embolcalla les sol·licituds dels client Desk al servidor
 * @author Dani Machado
 */
public class QueryDesk extends Query{
    /**
     * Constant de ALL per sol·licitar tots els usuaris
     */
    public static final String ALL = "all";
    
    private String username;

    /**
     * Getter User
     * @return Nom de l'usuari
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Setter User
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}