package com.pisa.core.base.model.exception;

/**
 * @author PISA
 */

public class PisaModelRuntimeException extends RuntimeException{

    public PisaModelRuntimeException() {
        super();
    }

    public PisaModelRuntimeException(String message) {
        super(message);
    }

    public PisaModelRuntimeException(Throwable cause) {
        super(cause);
    }

    public PisaModelRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}