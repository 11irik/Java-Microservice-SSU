package com.kirill.microservice.entity;

import java.io.Serializable;

public class Status implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
