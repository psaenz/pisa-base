package com.pisa.core.base.dao.exception;

/**
 * @author PISA
 */

public class PisaBaseDaoRuntimeException extends RuntimeException{

    public PisaBaseDaoRuntimeException() {
        super();
    }

    public PisaBaseDaoRuntimeException(String message) {
        super(message);
    }

    public PisaBaseDaoRuntimeException(Throwable cause) {
        super(cause);
    }

    public PisaBaseDaoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}