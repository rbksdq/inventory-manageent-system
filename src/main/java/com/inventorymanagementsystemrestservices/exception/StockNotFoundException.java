package com.inventorymanagementsystemrestservices.exception;

public class StockNotFoundException extends  Exception{
    private static final long serialVersionUID = 1L;

    public StockNotFoundException(String message){
        super(message);
    }

}
