package com.transaction.transactionengines.exceptions;


public class InvalidServiceException extends RuntimeException{
    public InvalidServiceException(String message) {
        super(message);
    }
}
