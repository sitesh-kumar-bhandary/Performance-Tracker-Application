package com.siteshkumar.performance_tracker_app_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ExternalApiException.class)
    public ResponseEntity<ApiError> handleExternalApiException(ExternalApiException ex){
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_GATEWAY);
    }
}
