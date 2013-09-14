package com.pisa.core.dao.hibernate.exception;

/**
 * @author PISA
 */

public class PisaHibernatelRuntimeException extends RuntimeException{

    public PisaHibernatelRuntimeException() {
        super();
    }

    public PisaHibernatelRuntimeException(String message) {
        super(message);
    }

    public PisaHibernatelRuntimeException(Throwable cause) {
        super(cause);
    }

    public PisaHibernatelRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}