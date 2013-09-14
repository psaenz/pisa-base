package com.pisa.core.base.services;

import com.pisa.core.base.model.IOneKeyModel;

/**
 * Dao classes that implements this interface will be in charge of persist one-key model objects.
 * 
 * One-Key models objects are those that implements the {@linkplain IOneKeyModel} interface.
 * 
 * This kind of objects only supports one primary key which is the most common scenario.
 * 
 * @author PISA
 */

public interface IOneKeyModelService<KEY_TYPE> {

    /**
     * Returns the model identify by the given ID.
     * 
     * NULL if the object is not found.
     * 
     * @param key
     * @return 
     */
    IOneKeyModel<KEY_TYPE> findById(KEY_TYPE key);

}