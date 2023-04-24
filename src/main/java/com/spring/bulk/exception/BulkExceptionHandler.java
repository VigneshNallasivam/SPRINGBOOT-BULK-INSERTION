package com.spring.bulk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
import com.spring.bulk.utility.Response;

@ControllerAdvice
public class BulkExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotvalidException(MethodArgumentNotValidException e)
    {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        List<String> errMsg = errors
                .stream()
                .map(ObjectError-> ObjectError.getDefaultMessage())
                .collect(Collectors.toList());
        Response response = new Response("Occurence of Exception in Usage of REST",errMsg.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BulkException.class)
    public ResponseEntity<Response> handleEmployeeException(BulkException e)
    {
        Response response = new Response("Occurence of Exception in Usage of REST",e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_GATEWAY);
    }

}
