package com.SECAPCompass.stakeholderapi.configuration;

import com.SECAPCompass.stakeholderapi.dto.error.ErrorResponse;
import com.SECAPCompass.stakeholderapi.exception.DomainNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

    public static final Locale TR = new Locale("tr");
    private final MessageSource messageSource;

    public AppControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(DomainNotFoundException.class)
    public ResponseEntity<ErrorResponse> ex(DomainNotFoundException ex){
        var msg = messageSource.getMessage(ex.getMessage(),new Object[] {ex.getDomainId()},TR);
        return new ResponseEntity<>(new ErrorResponse(msg,HttpStatus.NOT_FOUND.value(),ex.getClass().getSimpleName()), HttpStatus.NOT_FOUND);
    }
}