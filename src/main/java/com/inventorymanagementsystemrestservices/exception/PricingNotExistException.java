package com.inventorymanagementsystemrestservices.exception;

public class PricingNotExistException extends Exception{

    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public PricingNotExistException(String message) {

        super(message);
    }
}
