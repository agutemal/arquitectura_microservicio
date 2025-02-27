package com.example.microservicio.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleNumberFormatException(NumberFormatException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "Invalid number format");
        error.put("message", exception.getMessage());
        error.put("status", HttpStatus.BAD_REQUEST.value());
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleGeneralException(Exception exception, WebRequest request) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "Internal server error");
        error.put("message", exception.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
    
}
