package com.inventorymanagementsystemrestservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

public class CategoryCustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //method argument not valid exception
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request ){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From MethodArgumentNotValidException", ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }

    //HTTpRequestMethodNotSupported
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "From MethodArgumentNotValidException --- Method not allowed ", ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //rolenameNotFoundEexception
    @ExceptionHandler(RoleNameNotFoundException.class)
    public final ResponseEntity<Object> handleCategoryNameNotFoundException(CategoryNameNotFoundException ex, WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
    }

    //ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public final  ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

    }
}
