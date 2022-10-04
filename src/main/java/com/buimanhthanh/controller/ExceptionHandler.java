package com.buimanhthanh.controller;

import com.buimanhthanh.exception.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception){
        ApiErrorResponse error = new ApiErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
