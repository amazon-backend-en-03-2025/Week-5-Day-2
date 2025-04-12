package com.ironhack.helloforest.dto;

public class Greet {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greet(String mesage) {
        this.message = mesage;
    }
}
