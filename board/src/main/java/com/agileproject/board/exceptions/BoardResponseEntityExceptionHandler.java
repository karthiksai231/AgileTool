package com.agileproject.board.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class BoardResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdentifierException(InvalidProjectIdentifierException ex, WebRequest request) {
        ProjectIdentifierExceptionResponse projectIdentifierExceptionResponse = new ProjectIdentifierExceptionResponse(ex.getMessage());
        return new ResponseEntity(projectIdentifierExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
