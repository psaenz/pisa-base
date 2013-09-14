package com.pisa.core.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author PISA
 */

public class HibernateUtil {

    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    
    private static final SessionFactory sessionFactory;

    static {
        try {
            /*
            HibernateProxyHelper
            Discriminator 
            determineConcreteSubclassEntityName 
            EntityNameResolver 
            - http://stackoverflow.com/questions/891360/interceptors-getentityname-is-not-used-bug-in-hibernate
            - https://access.redhat.com/knowledge/docs/en-US/JBoss_Enterprise_Web_Server/1.0/html/Hibernate_Core_Reference_Guide/persistent-classes-entity-name-resolver.html
            - https://access.redhat.com/knowledge/docs/en-US/JBoss_Enterprise_Web_Server/1.0/html/Hibernate_Core_Reference_Guide/persistent-classes-tuplizers.html
            */
            
            log.info("Creating SessionFactory object.");

            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
            AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
            PisaHibernateInterceptor hibernateInterceptor = new PisaHibernateInterceptor();
            configuration.setInterceptor(hibernateInterceptor);

            //configuration.registerTypeOverride(new org.hibernate.type.CalendarType());
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}