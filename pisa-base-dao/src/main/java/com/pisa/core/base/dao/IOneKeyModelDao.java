package com.pisa.core.base.dao;

import com.pisa.core.base.model.IOneKeyModel;
import java.io.Serializable;

/**
 * Dao classes that implements this interface will be in charge of persist one-key model objects.
 * 
 * One-Key models objects are those that implements the {@linkplain IOneKeyModel} interface.
 * 
 * This kind of objects only supports one primary key which is the most common scenario.
 * 
 * @author PISA
 */

public interface IOneKeyModelDao <MODEL_TYPE extends IOneKeyModel, KEY_TYPE extends Serializable> {

    /**
     * Returns the model identify by the given ID.
     * 
     * NULL if the object is not found.
     * 
     * @param key
     * @return 
     */
    MODEL_TYPE findById(KEY_TYPE key);
    
}