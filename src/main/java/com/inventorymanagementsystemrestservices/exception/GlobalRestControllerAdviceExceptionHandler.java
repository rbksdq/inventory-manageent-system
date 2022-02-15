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

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails usernameNotFound(UserNameNotFoundException ex){

        return new CustomErrorDetails(new Date(), "from @RestControllerAdvice", ex.getMessage());
    }

    @ExceptionHandler(CategoryNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails categorynameNotFound(CategoryNameNotFoundException ex){

        return new CustomErrorDetails(new Date(), "from @RestControllerAdvice", ex.getMessage());
    }

    @ExceptionHandler(ProductNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails productnameNotFound(ProductNameNotFoundException ex){

        return new CustomErrorDetails(new Date(), "from @RestControllerAdvice", ex.getMessage());
    }
}
