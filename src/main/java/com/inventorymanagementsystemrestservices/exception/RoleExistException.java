package com.inventorymanagementsystemrestservices.exception;

public class RoleExistException extends Exception {
    private static final long serialVersionUID = 1L;
    public RoleExistException(String message) {
        super(message);
    }
}
