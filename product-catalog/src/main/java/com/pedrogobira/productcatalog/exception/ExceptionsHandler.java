package com.pedrogobira.productcatalog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionMessage> handleException(IllegalArgumentException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionMessage("Invalid argument or argument value"));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionMessage> handleException(NoSuchElementException exception) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionMessage("No such element was found"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handleException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionMessage("Required argument is missing or invalid"));
    }
}

