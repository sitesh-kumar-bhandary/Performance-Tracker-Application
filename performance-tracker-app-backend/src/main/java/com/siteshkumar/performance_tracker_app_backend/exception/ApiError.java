package com.siteshkumar.performance_tracker_app_backend.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class ApiError {
    
    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus statusCode;

    ApiError(String error, HttpStatus statusCode){
        this.timeStamp = LocalDateTime.now();
        this.error = error;
        this.statusCode = statusCode;
    }
}
