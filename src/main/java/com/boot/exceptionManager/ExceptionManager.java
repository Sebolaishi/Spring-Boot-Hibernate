package com.boot.exceptionManager;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

@ControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleInternalServerConflicts(Exception exception, WebRequest request) {
        ExceptionDetailBuilder error = ExceptionDetailBuilder.of(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Internal error occurred");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(exception, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { NotFoundException.class})
    protected ResponseEntity<Object> handleConflict(Exception exception, WebRequest request) {
        ExceptionDetailBuilder error = ExceptionDetailBuilder.of(HttpStatus.NOT_FOUND.name(), "Not Found");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(exception, error, headers, HttpStatus.NOT_FOUND, request);
    }

}
