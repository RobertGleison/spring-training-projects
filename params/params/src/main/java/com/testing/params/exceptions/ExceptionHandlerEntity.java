package com.testing.params.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Instant;
import java.util.logging.Logger;

@ControllerAdvice
@RestController
public class ExceptionHandlerEntity {

    private static final Logger logger = Logger.getLogger(ExceptionHandlerEntity.class.getName());

    @ExceptionHandler(MismatchOperandsException.class)
    public ResponseEntity<StandardError> inputError(MismatchOperandsException e){
        StandardError error = new StandardError(Instant.now(), "406" ,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<StandardError> divisionByZero(ArithmeticException e){
        StandardError error = new StandardError(Instant.now(),"406",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }
}
