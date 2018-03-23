/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */
package model.client;

import java.io.Serializable;

/**
 * Super Classe abstracta de tota la resta del model de dades a empaquetar en les comunicacions
 * @author Dani Machado
 */
public abstract class Packet implements Serializable{
    private int sessionID;

    /**
     * Getter del id de sessió
     * @return Retorna el id de la sessió
     */
    public int getSessionID() {
        return sessionID;
    }

    /**
     * Setter del id de sessió
     * @param sessionID Id de la sessió
     */
    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
    
}
