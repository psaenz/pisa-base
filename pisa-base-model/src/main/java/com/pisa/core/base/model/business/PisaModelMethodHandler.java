package com.pisa.core.base.model.business;

import com.pisa.core.base.model.exception.PisaModelException;
import com.pisa.core.utils.patterns.factory.IProxyMethodHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements a {@linkplain  MethodHandler} in order handle all the 
 * methods defined in the BaseModel interfaces defined on the {@code com.pisa.core.base.model.IPisaBase*}
 * package.
 * 
 * All the interfaces that needs to be handle by this class must be registered in the {@linkplain PisaModelInterfaceRegistry}.
 * 
 * When a Model instance is created by the {@linkplain PisaModelFactory} this MethodHandler
 * is associated with it.
 * 
 * @author PISA
 */

public class PisaModelMethodHandler implements IProxyMethodHandler {

    private Map<String, Object> propertiesMap = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] os) throws Throwable {
        String action = method.getName().substring(0, 3); // takes the GET or SET
        String propertyName = method.getName().substring(3); // takes the property name
        if (action.equalsIgnoreCase("GET")){
            return getPropertiesMap().get(propertyName);
        }else{
            if (action.equalsIgnoreCase("SET")){
                getPropertiesMap().put(propertyName, os[0]);
                return true;
            }
        }

        // If this happens, it means one of the interfaces on IPisaBase****Model is defining a method different than a GET or SET
        throw new PisaModelException("Operation '" + action + "' is not supported in PisaModel schema for property '" + propertyName + "'");
    }

    private Map<String, Object> getPropertiesMap(){
        if (propertiesMap == null)
            propertiesMap = new HashMap<String, Object>();
        return propertiesMap;
    }
}