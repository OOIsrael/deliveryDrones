package com.oluwadamilareisrael.deliveryDrones.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(value = valueNotFound.class)
    public ResponseEntity<Object> exception(valueNotFound exception) {
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

    public static class valueNotFound extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}


