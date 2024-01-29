package com.rinha.rinha_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> UnprocessableEntityException(RuntimeException e){
        return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
//        StringBuilder errorMessage = new StringBuilder();
//        for (FieldError fieldError : fieldErrors) {
//            errorMessage.append(fieldError.getDefaultMessage()).append("; ");
//        }
        return ResponseEntity.unprocessableEntity().body(fieldErrors.get(0).getDefaultMessage());
    }
}
