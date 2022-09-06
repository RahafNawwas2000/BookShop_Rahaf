package com.example.bookshop.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class stockEqualZero extends RuntimeException{
    private HttpStatus httpstatus;
    private Object data;

    public stockEqualZero() {
    }

    public stockEqualZero(String message) {
        super(message);
    }
    public stockEqualZero(String message,HttpStatus status) {
        super(message);
        this.httpstatus=status;
    }
    public stockEqualZero(String message,HttpStatus status,Object data) {
        this(message,status);
        this.data=data;
    }
}
