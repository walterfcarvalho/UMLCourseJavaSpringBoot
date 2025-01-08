package com.walterfcarvalho.cursoumc.cursoumc.resources.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> 
    objectNotFound(ObjectNotFoundException e, HttpServletRequest req){

        StandardError err = 
        new StandardError(
            HttpStatus.NOT_FOUND.value(),
            e.getMessage(),
            System.currentTimeMillis()
        );    
    
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("<p>error: " + err.getMsg() + " </p>");
    }
}
