package com.atl.springboot.exception;

public class NoSuchCustomerException extends Exception{

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
