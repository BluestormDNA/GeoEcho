/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.model;

import java.io.Serializable;

/**
 *
 * @author Pedro Cortés
 */
public class LoginResponse implements Packet, Serializable {

    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

}
