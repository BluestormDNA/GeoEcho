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
public abstract class Packet implements Serializable{
    private int sessionID;

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
}
