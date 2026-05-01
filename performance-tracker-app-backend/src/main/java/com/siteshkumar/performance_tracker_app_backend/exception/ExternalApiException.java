package com.siteshkumar.performance_tracker_app_backend.exception;

public class ExternalApiException extends RuntimeException {
    
    public ExternalApiException(String message){
        super(message);
    }
}
