package com.pisa.core.dao.hibernate.exception;

/**
 * @author PISA
 */

public class PisaHibernateException extends Exception{

    public PisaHibernateException() {
        super();
    }

    public PisaHibernateException(String message) {
        super(message);
    }

    public PisaHibernateException(Throwable cause) {
        super(cause);
    }

    public PisaHibernateException(String message, Throwable cause) {
        super(message, cause);
    }
}