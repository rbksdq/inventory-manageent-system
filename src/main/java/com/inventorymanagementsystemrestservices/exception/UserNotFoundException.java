package com.inventorymanagementsystemrestservices.exception;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public UserNotFoundException(String message) {

        super(message);
    }
}
