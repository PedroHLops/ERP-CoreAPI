package com.Demo.Infra.ExceptionsHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling404 {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ErrorHandling400 (MethodArgumentNotValidException ex) {
        lombok.var Error = ex.getFieldErrors();
        
        return ResponseEntity.badRequest().body(Error.stream().map(LogError::new).toList());
    
    }
    public record LogError(String Error, String Menssage) {
        public LogError(FieldError Error) {
            this(Error.getField(), Error.getDefaultMessage());
        }
    }
}