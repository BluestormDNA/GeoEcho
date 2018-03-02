/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoecho.model;

import java.io.Serializable;

/**
 *
 * @author BlueStorm
 */
public class Logout implements Packet, Serializable {
    
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
