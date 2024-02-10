package com.tickets.application.service;

public class Service {
        
    private final String status;
    private final Integer code;

    public Service(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }
    
    public Integer getCode() {
        return code;
    }

}