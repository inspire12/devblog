package com.cnu.devblog.controller;

import com.cnu.devblog.exception.PostInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PostExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = PostInvalidException.class)
    public <T> ResponseEntity<T> exception() {
        return ResponseEntity.badRequest().build();
    }
}
