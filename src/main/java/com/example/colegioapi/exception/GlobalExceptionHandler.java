package com.example.colegioapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception, WebRequest webRequest){
        Map<String, Object> exceptionInfo = new HashMap<>();
        exceptionInfo.put("message",exception.getMessage());
        exceptionInfo.put("cause",exception.getCause());
        exceptionInfo.put("timestamp",System.currentTimeMillis());
        return new ResponseEntity<>(exceptionInfo,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> SQLIntegrityConstraintViolation(SQLIntegrityConstraintViolationException exception, WebRequest webRequest){
        Map<String, Object> exceptionInfo = new HashMap<>();
        exceptionInfo.put("message",exception.getMessage());
        exceptionInfo.put("cause",exception.getCause());
        exceptionInfo.put("timestamp",System.currentTimeMillis());
        return new ResponseEntity<>(exceptionInfo,HttpStatus.BAD_REQUEST);
    }
}
