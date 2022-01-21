package com.inventorymanagementsystemrestservices.exception;

public class CategoryNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public CategoryNotFoundException(String message) {

        super(message);
    }
}
