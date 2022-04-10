package com.vikash.springvalidation.web.controller;

import com.vikash.springvalidation.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleValidationException(ConstraintViolationException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getConstraintViolations().forEach(
                constraintViolation -> {
                    errors.put(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage());
                });
        return errors;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleUserNotFoundException(UserNotFoundException ex){
        Map<String,String> error=new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("timeStamp", LocalDateTime.now().toString());
        return error;
    }

}
