/*
 * App GeoEcho (Projecte final M13-DAM al IOC)
 * Copyright (c) 2018 - Papaya Team
 */

package model.client;

import java.util.List;

/**
 * Classe abstracta ResponseQuery que embolcalla la resposta del servidor als clients
 * @author Dani Machado
 */
public abstract class ResponseQuery extends Response{
    
    private List<Message> messageList;
    
    /**
     * Getter de messageList
     * @return Retorna la llista de missatges
     */
    public List<Message> getMessageList() {
        return messageList;
    }

    /**
     * Setter de messageList
     * @param messageList Llista de missatges
     */
    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
    
}