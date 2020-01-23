package com.agileproject.board.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestValidationService {

    public ResponseEntity<?> requestValidation(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> resultErrorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                resultErrorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(resultErrorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
