package com.devsu.test.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

@ControllerAdvice
public class ClienteRestExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ClienteErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);
        ClienteErrorResponse error = new ClienteErrorResponse(rootCause.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ClienteErrorResponse> handleException(Exception exception) {
        ClienteErrorResponse error = new ClienteErrorResponse(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
