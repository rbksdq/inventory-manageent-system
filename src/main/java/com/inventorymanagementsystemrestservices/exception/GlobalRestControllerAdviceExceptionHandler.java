package com.inventorymanagementsystemrestservices.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

//@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {
    @ExceptionHandler(RoleNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails rolenameNotFound(RoleNameNotFoundException ex){

        return new CustomErrorDetails(new Date(), "from @RestControllerAdvice", ex.getMessage());
    }
}
