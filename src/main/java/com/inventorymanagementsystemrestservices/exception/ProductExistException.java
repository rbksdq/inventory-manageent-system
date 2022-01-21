package com.inventorymanagementsystemrestservices.exception;

import com.inventorymanagementsystemrestservices.entity.Product;

public class ProductExistException extends  Exception{

    private static final long serialVersionUID = 1L;


    public ProductExistException (String message){
        super(message);
    }

}
