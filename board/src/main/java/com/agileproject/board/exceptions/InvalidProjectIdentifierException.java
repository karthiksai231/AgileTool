package com.agileproject.board.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidProjectIdentifierException extends RuntimeException {
    public InvalidProjectIdentifierException(String message) {
        super(message);
    }
}
