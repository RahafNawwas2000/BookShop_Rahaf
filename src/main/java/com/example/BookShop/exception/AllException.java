package com.example.BookShop.exception;

import org.springframework.http.HttpStatus;

public class AllException extends RuntimeException{
    private HttpStatus httpstatus;
    private Object data;

    public AllException() {
    }

    public AllException(String message) {
        super(message);
    }
    public AllException(String message,HttpStatus status) {
        super(message);
        this.httpstatus=status;
    }
    public AllException(String message,HttpStatus status,Object data) {
        this(message,status);
        this.data=data;
    }

    public HttpStatus getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(HttpStatus httpstatus) {
        this.httpstatus = httpstatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
