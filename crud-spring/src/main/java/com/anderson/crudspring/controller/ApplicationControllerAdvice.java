package com.anderson.crudspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anderson.crudspring.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    /*
     * Controla as exeções da API - Mensagem de error
    */

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFoundException ex) {

        return ex.getMessage();
    }
}
