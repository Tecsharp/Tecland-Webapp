package com.tecsharp.tecland.web.app.services;

public class ServiceJdbcException extends RuntimeException {

    public ServiceJdbcException(String message) {
        super(message);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceJdbcException() {

    }
}
