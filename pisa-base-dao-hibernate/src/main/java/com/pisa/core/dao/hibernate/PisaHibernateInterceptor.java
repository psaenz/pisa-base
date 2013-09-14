package com.pisa.core.dao.hibernate;

import com.pisa.core.dao.hibernate.exception.PisaHibernatelRuntimeException;
import com.pisa.core.base.model.business.PisaModelFactory;
import com.pisa.core.base.model.impl.PisaBaseModel;
import com.pisa.core.utils.patterns.factory.ProxyFactory;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This Interceptor connects the Hibernate Framework with the PisaModel definition.
 * 
 * @author PISA
 */
public class PisaHibernateInterceptor extends EmptyInterceptor{

    private static final Logger log = LoggerFactory.getLogger(PisaHibernateInterceptor.class);

    public PisaHibernateInterceptor(){
    }
    
    /**
     * This method is in charge of taking the entity and determine if it belongs to the PisaModel Framework,
     * if so, then uses {@linkplain PisaModelFactory} to create a concrete class that represents the
     * given entity and sets its id as corresponding.
     * 
     * In case the entity doesn't belong to the PisaModel Framework, then returns a null value which
     * indicates Hibernate to try to instantiate the entity name in his normal way.
     * 
     * @param entityName
     * @param entityMode
     * @param id
     * @return 
     */
    @Override
    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
        try {
            log.debug("Instantiating entity '" + entityName + "' with id '" + id + "'");
            // EntityMode = MAP or POJO
            Class clazz = Class.forName(entityName);
            if (PisaModelFactory.isPisaModelClass(clazz)){
                // Try to use the PisaModelFactory in order create the an entity instance
                log.debug("Using '" + PisaModelFactory.class + "' for instantiation.");
                PisaBaseModel baseModel = (PisaBaseModel) PisaModelFactory.createInstance(clazz);
                baseModel.setId(id);
                return baseModel;
            }
        } catch (ClassNotFoundException ex) {
            log.error("Unable to instantiate class '" + entityName + "'.", ex);
            throw new PisaHibernatelRuntimeException("Unable to instantiate class '" + entityName + "'.", ex);
        }

        // let Hibernate to do the instantiation
        log.debug("Letting Hibernate to instantiate the entity in his normal way.");
        return null;
    }

    /**
     * Returns the entity name according to the given object. Sometime this method will
     * receive PisaModel Framework object which could be proxied (see {@linkplain PisaModelFactory}),
     * so in this case we need to return the proxied object's class name which is actually the 
     * entity name.
     * 
     * @param object
     * @return 
     */
    @Override
    public String getEntityName(Object object) {
        if (PisaModelFactory.isProxyPisaModelClass(object.getClass())){
            // if it is proxied, then take the entity from his superclass
            return object.getClass().getSuperclass().getName();
        }else{
            // if it is a normal entity obj, then user his classname
            return object.getClass().getName();
        }
    }
}