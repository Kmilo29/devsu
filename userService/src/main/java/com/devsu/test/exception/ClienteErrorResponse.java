package com.devsu.test.exception;

public class ClienteErrorResponse {

    private String message;

    public ClienteErrorResponse() {}

    public ClienteErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
