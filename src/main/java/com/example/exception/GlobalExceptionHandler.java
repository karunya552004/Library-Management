package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Book not found
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFoundException(
            BookNotFoundException ex) {

        return ex.getMessage();
    }


    // Book already exists
    @ExceptionHandler(BookAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleBookAlreadyExistsException(
            BookAlreadyExistsException ex) {

        return ex.getMessage();
    }


    // Field validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleValidationException(
            MethodArgumentNotValidException ex) {

        return "Please enter valid book details";
    }


    // General exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception ex) {

        return "Something went wrong";
    }
}