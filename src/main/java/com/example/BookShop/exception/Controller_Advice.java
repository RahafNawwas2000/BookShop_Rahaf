package com.example.BookShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class Controller_Advice {

    @ExceptionHandler(AllException.class)
    public ResponseEntity<ErrorMessage> ExceptionHandler(AllException e)
    {
        HttpStatus httpstatus=e.getHttpstatus();
        Object data=e.getData();
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(stringWriter);
//        e.printStackTrace(printWriter);
    //    String stackTrace = stringWriter.toString();
        String stackTrace="Trace";
    return new ResponseEntity<ErrorMessage>(new ErrorMessage(httpstatus,e.getMessage(),stackTrace,data),httpstatus);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> AnyUnImplementedException(Exception e)
    {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"General Exception"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
