/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

import java.util.List;

/**
 * Classe ResponseQueryDesk que embolcalla la resposta del servidor al client Desk
 * @author Dani Machado
 */
public class ResponseQueryDesk extends ResponseQuery{

    private List<User> userList;

    /**
     * Getter userList
     * @return Retorna llistat d'usuaris
     */
    public List<User> getUserList() {
        return userList;
    }
    
    /**
     * Setter userList
     * @param userList Llista d'usuaris
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
         
}