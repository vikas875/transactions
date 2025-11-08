package com.transaction.transactionengines.exceptions;

public class InvalidChannelUserException extends RuntimeException{
    public InvalidChannelUserException(String message){
        super(message);
    }
}
