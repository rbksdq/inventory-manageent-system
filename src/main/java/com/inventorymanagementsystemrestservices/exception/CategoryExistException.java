package com.inventorymanagementsystemrestservices.exception;

public class CategoryExistException extends Exception{

    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public CategoryExistException(String message) {

        super(message);
    }
}
