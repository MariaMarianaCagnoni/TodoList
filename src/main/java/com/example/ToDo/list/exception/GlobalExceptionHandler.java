package com.example.ToDo.list.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handler(NoSuchElementException notFoundException) {
        logger.error("Unexceptional server error,see the logs ", notFoundException);
        return new ResponseEntity<>("Resource Id not found", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handlerUnexpected(Throwable unexception) {
        logger.error("Unexceptional server error,see the logs ", unexception);
        return new ResponseEntity<>("Unexceptional server error", HttpStatus.NO_CONTENT);
    }
}
