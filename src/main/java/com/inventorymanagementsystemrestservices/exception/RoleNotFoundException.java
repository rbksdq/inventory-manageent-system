package com.inventorymanagementsystemrestservices.exception;

public class RoleNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public RoleNotFoundException(String message) {

        super(message);
    }
}
