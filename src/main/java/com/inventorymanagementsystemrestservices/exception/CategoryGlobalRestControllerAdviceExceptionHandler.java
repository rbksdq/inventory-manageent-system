//package com.inventorymanagementsystemrestservices.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.Date;
//
//public class CategoryGlobalRestControllerAdviceExceptionHandler {
//
//    @ExceptionHandler(CategoryNameNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public CustomErrorDetails categorynameNotFound(CategoryNameNotFoundException ex){
//
//        return new CustomErrorDetails(new Date(), "from @RestControllerAdvice", ex.getMessage());
//    }
//}
