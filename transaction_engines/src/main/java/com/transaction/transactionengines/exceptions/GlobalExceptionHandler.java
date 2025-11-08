package com.transaction.transactionengines.exceptions;


import com.transaction.transactionengines.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmount(InvalidAmountException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidServiceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidService(InvalidServiceException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidSubscriberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSubscriber(InvalidSubscriberException ex, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(ex.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidChannelUserException.class)
    public ResponseEntity<ErrorResponse> handleInvalidChannelUser(InvalidChannelUserException ex, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(ex.getMessage(),request.getRequestURI());
        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorResponse> handleInvalidProduct(InvalidProductException ex, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
