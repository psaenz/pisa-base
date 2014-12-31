package com.pisa.core.base.dao.exception;

/**
 * @author PISA
 */

public class PisaBaseDaoException extends Exception{

    public PisaBaseDaoException() {
        super();
    }

    public PisaBaseDaoException(String message) {
        super(message);
    }

    public PisaBaseDaoException(Throwable cause) {
        super(cause);
    }

    public PisaBaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}