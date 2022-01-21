package com.inventorymanagementsystemrestservices.exception;

public class UserExistException extends Exception{
    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public UserExistException(String message) {

        super(message);
    }
}
