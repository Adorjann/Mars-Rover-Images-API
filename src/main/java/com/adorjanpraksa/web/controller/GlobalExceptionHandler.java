package com.adorjanpraksa.web.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    private Map<String, String> BindExceptionErrorMessage(BindException exception) {

        return exception.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        DefaultMessageSourceResolvable::getDefaultMessage
                ));

    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(BindExceptionErrorMessage(exception), HttpStatus.BAD_REQUEST, "Data validation failed"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleRuntimeException(Exception exception) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong"));
    }


    public record ErrorResponse<T>(T data, HttpStatus status, String message) {
    }
}
