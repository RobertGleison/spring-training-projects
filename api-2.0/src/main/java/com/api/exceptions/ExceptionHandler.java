package com.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalTime;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handleResourceNotFoundException(ResourceNotFoundException exception){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        DefaultErrorMessage response = new DefaultErrorMessage(exception.getMessage(), error, LocalTime.now(),status.value());
        return ResponseEntity.status(status).body(response);
    }
}
