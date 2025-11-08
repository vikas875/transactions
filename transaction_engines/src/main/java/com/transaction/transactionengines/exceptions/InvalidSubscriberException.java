package com.transaction.transactionengines.exceptions;

public class InvalidSubscriberException extends RuntimeException{
    public InvalidSubscriberException(String message) {
        super(message);
    }
}
