
package com.digicert.public_api.infrastructure.exception;

public class WeatherServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public WeatherServiceException(String message) {
        super(message);
    }
    
}