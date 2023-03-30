package org.gopas.springbootdemo.exceptions;

import org.springframework.web.util.UrlPathHelper;

public class ResourceNotFoundEception extends RuntimeException {


    public ResourceNotFoundEception() {
    }

    public ResourceNotFoundEception(String message) {
        super(message);
    }

    public ResourceNotFoundEception(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundEception(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundEception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
