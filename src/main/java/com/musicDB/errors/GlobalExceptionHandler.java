package com.musicDB.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    private static ResponseEntity<ErrorResponse> buildExceptionResponse(Exception e, HttpStatus s) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        logger.log(Level.WARNING, "GlobalExceptionHandler exception", e);
        return new ResponseEntity<>(errorResponse, s);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException e) {
        return buildExceptionResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NoResultException e) {
        return buildExceptionResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException e) {
        return buildExceptionResponse(e, HttpStatus.BAD_REQUEST);
    }

    /* Default exception handler. Catch any exception & return 400 */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return buildExceptionResponse(e, HttpStatus.BAD_REQUEST);
    }
}
