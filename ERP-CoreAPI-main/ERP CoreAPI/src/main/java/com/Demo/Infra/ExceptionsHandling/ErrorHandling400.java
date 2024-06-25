package com.Demo.Infra.ExceptionsHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandling400 {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> ErrorHandling404 () {
        return ResponseEntity.notFound().build();
    }
}