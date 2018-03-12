/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.client;

/**
 * 
 * @author Dani Machado
 */
public class Response extends Packet{
    public static final int LOGIN_FAILED = 0;
    public static final int LOGIN_OK = 1;
    public static final int REGISTER_FAILED = 2;
    public static final int REGISTER_NAME_FAILED = 3;
    public static final int REGISTER_EMAIL_FAILED = 4;
    public static final int REGISTER_OK = 5;
    public static final int LOGOUT_FAILED = 6;
    public static final int LOGOUT_OK = 7;
    
    private int statusQuery;

    public int getStatusQuery() {
        return statusQuery;
    }

    public void setStatusQuery(int statusQuery) {
        this.statusQuery = statusQuery;
    }
}
