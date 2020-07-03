package com.spliff.Virtualmenu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.ServiceUnavailableException;
import org.hibernate.exception.ConstraintViolationException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity handleInvalidParameterException(InvalidParameterException ex) {
        LOGGER.error("InvalidParameterException: ", ex);
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler
    public ResponseEntity handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        LOGGER.error("EmptyResultDataAccessException: ", ex);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity handleAccessDeniedException(AccessDeniedException ex) {
        LOGGER.error("AccessDeniedException: ", ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity handleIllegalAccessException(IllegalAccessException ex) {
        LOGGER.error("IllegalAccessException: ", ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity handleServiceUnavailableException(ServiceUnavailableException ex) {
        LOGGER.error("ServiceUnavailableException: ", ex);
        return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException ex) {
        LOGGER.error("IOException: ", ex.getMessage());
        if (("An established connection was aborted by the software in your host machine".equals(ex.getMessage()) || "Connection reset by peer".equals(ex.getMessage())))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleBadHttpRequestException(IllegalArgumentException ex) {
        LOGGER.error("IllegalArgumentException: ", ex);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("MethodArgumentNotValidException: ", ex);
        return new ResponseEntity(ex.getBindingResult().getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        LOGGER.error("GENERIC_ERROR_HANDLER", ex);

        Throwable causedBy = ex.getCause();
        if (causedBy != null) {
            LOGGER.error("ERROR_CAUSED_BY", causedBy);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException ex) {
        LOGGER.error("ConstraintViolationException: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        LOGGER.error("DataIntegrityViolationException: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        LOGGER.error("SQLIntegrityConstraintViolationException: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
