package com.pisa.core.utils.patterns.registry;

import com.pisa.core.utils.exception.PisaUtilsException;
import com.pisa.core.utils.exception.PisaUtilsRuntimeException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is intended to be used for those classes that handles a registry of a 
 * given Type.
 * 
 * @author PISA
 */

public class Registry<KEY_TYPE, OBJ_TYPE> {

    private boolean throwExceptionWhenNotFound = false;
    private Map<KEY_TYPE, OBJ_TYPE> registry = null;

    public Registry(boolean throwExceptionWhenNotFound){
        this.throwExceptionWhenNotFound = throwExceptionWhenNotFound;
    }
    
    public void register(KEY_TYPE key, OBJ_TYPE obj){
        getRegistry().put(key, obj);
    }

    public OBJ_TYPE getRegistry(KEY_TYPE key){
        if (throwExceptionWhenNotFound && !getRegistry().containsKey(key))
            throw new PisaUtilsRuntimeException("Unable to find object with key '" + key + "' on registry '" + this.getClass().getName()  + "'.");
        return getRegistry().get(key);
    }

    public boolean isRegistered(KEY_TYPE key){
        return getRegistry().containsKey(key);
    }

    private Map<KEY_TYPE, OBJ_TYPE> getRegistry(){
        if (registry == null)
            registry = new HashMap<KEY_TYPE, OBJ_TYPE>();
        return registry;
    }
}
