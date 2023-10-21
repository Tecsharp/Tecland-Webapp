package com.tecsharp.tecland.web.app.services;

public class ServiceJdbcException extends RuntimeException {

    private static final long serialVersionUID = -6457272715900741209L;

	public ServiceJdbcException(String message) {
        super(message);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceJdbcException() {

    }
}
