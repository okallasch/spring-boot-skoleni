package org.gopas.springbootdemo.exceptions;

public class CreatePersonException extends RuntimeException {

    public CreatePersonException() {
    }

    public CreatePersonException(String message) {
        super(message);
    }

    public CreatePersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatePersonException(Throwable cause) {
        super(cause);
    }

    public CreatePersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
