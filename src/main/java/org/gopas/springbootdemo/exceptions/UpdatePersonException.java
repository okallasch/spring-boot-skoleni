package org.gopas.springbootdemo.exceptions;

public class UpdatePersonException extends RuntimeException {

    public UpdatePersonException() {
    }

    public UpdatePersonException(String message) {
        super(message);
    }

    public UpdatePersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdatePersonException(Throwable cause) {
        super(cause);
    }

    public UpdatePersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
