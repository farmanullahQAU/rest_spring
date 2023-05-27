package com.students.rest_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class UserExceptionHandler {
@ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){

        UserException userException=new UserException(notFoundException.getMessage(),notFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(userException,HttpStatus.NOT_FOUND);




    }
}
