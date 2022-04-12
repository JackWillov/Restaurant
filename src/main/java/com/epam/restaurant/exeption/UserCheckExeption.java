package com.epam.restaurant.exeption;

public class UserCheckExeption extends Exception {
    public UserCheckExeption() {
    }

    public UserCheckExeption(String message) {
        super(message);
    }

    public UserCheckExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCheckExeption(Throwable cause) {
        super(cause);
    }

    public UserCheckExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
