package com.ovnisoft.data.entity;

/**
 * Created by javier_rebollo on 14/11/16.
 */

public class Message implements BaseEntity {

    private int id;
    private String message;
    private int time;

    public Message(int id, String message, int time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
