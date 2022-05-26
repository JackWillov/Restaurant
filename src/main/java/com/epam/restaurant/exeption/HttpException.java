package com.epam.restaurant.exeption;

import javax.servlet.ServletException;

public class HttpException extends ServletException {

    private int code;

    public HttpException(int code, String message) {
        super(message);
        this.code = code;
    }
}
