package com.example.bookshop.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class nullObject extends RuntimeException{
    private HttpStatus httpstatus;
    private Object data;

    public nullObject() {
    }

    public nullObject(String message) {
        super(message);
    }
    public nullObject(String message,HttpStatus status) {
        super(message);
        this.httpstatus=status;
    }
    public nullObject(String message,HttpStatus status,Object data) {
        this(message,status);
        this.data=data;
    }
}
