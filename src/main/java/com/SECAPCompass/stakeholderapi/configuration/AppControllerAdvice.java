package com.SECAPCompass.stakeholderapi.configuration;

import com.SECAPCompass.stakeholderapi.dto.error.ErrorResponse;
import com.SECAPCompass.stakeholderapi.exception.DiscussionIsClosedException;
import com.SECAPCompass.stakeholderapi.exception.DomainNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.EntityNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.UsernameNotFound;
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
    public ResponseEntity<ErrorResponse> exDomainNotFound(DomainNotFoundException ex){
        var msg = messageSource.getMessage(ex.getMessage(),new Object[] {ex.getDomainId()},TR);
        return new ResponseEntity<>(new ErrorResponse(msg,HttpStatus.NOT_FOUND.value(),ex.getClass().getSimpleName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DiscussionIsClosedException.class)
    public ResponseEntity<ErrorResponse> exDiscussionIsClosed(DiscussionIsClosedException ex){
        var msg = messageSource.getMessage(ex.getMessage(),new Object[] {ex.getId()},TR);
        return new ResponseEntity<>(new ErrorResponse(msg,HttpStatus.FORBIDDEN.value(),ex.getClass().getSimpleName()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> exEntityNotFound(EntityNotFoundException ex){
        var msg = messageSource.getMessage(ex.getMessage(),new Object[] {ex.getClas()},TR);
        return new ResponseEntity<>(new ErrorResponse(msg,HttpStatus.BAD_REQUEST.value(),ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFound.class)
    public ResponseEntity<ErrorResponse> exUsernameNotFound(UsernameNotFound ex){
        var msg = messageSource.getMessage(ex.getMessage(),new Object[] {ex.getUserName()},TR);
        return new ResponseEntity<>(new ErrorResponse(msg,HttpStatus.BAD_REQUEST.value(),ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }
}