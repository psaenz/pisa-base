package com.pisa.core.base.model.exception;

/**
 * @author PISA
 */

public class PisaModelException extends Exception{

    public PisaModelException() {
        super();
    }

    public PisaModelException(String message) {
        super(message);
    }

    public PisaModelException(Throwable cause) {
        super(cause);
    }

    public PisaModelException(String message, Throwable cause) {
        super(message, cause);
    }
}