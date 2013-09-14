package com.pisa.core.utils.exception;

/**
 * @author PISA
 */

public class PisaUtilsRuntimeException extends RuntimeException{

    public PisaUtilsRuntimeException() {
        super();
    }

    public PisaUtilsRuntimeException(String message) {
        super(message);
    }

    public PisaUtilsRuntimeException(Throwable cause) {
        super(cause);
    }

    public PisaUtilsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}