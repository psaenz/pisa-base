package com.pisa.core.utils.exception;

/**
 * @author PISA
 */

public class PisaUtilsException extends Exception{

    public PisaUtilsException() {
        super();
    }

    public PisaUtilsException(String message) {
        super(message);
    }

    public PisaUtilsException(Throwable cause) {
        super(cause);
    }

    public PisaUtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}