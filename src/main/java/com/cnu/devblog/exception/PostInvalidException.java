package com.cnu.devblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostInvalidException extends RuntimeException {
    
    public PostInvalidException() {
    }
    
    public PostInvalidException(String message) {
        super(message);
    }
}
