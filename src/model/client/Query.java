/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

import java.awt.geom.Point2D;

/**
 * Classe abstracta Query que embolcalla les sol·licituds dels clients al servidor
 * @author Dani Machado
 */
public abstract class Query extends Packet{

    private Point2D.Float coordinates;

    /**
     * Getter coordinates
     * @return Retorna les coordenades
     */
    public Point2D.Float getCoordinates() {
        return coordinates;
    }
    
    /**
     * Setter coordinates
     * @param coordinates Coordenades del ount
     */
    public void setCoordinates(Point2D.Float coordinates) {
        this.coordinates = coordinates;
    }
}