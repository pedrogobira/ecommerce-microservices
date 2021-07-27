package com.pedrogobira.shoppingcart.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionMessage> handleException(NoSuchElementException exception) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionMessage("No such element was found"));
    }
}

