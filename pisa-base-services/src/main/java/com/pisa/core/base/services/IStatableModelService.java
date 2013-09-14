package com.pisa.core.base.services;

import com.pisa.core.base.model.IStatableModel;

/**
 * Dao classes that implements this interface will be in charge of persist Statable model objects.
 * 
 * Statable models objects are those that implements the {@linkplain IStatableModel} interface.
 * 
 * The Statable models supports one or many status, and can be used in cases that something for instance
 * could be ACTIVE or INACTIVE.
 * 
 * @author PISA
 */

public interface IStatableModelService<STATE_TYPE> {

    /**
     * Changes the status of the given object
     * 
     * @param model
     * @param status
     * @return 
     */
    public boolean SetStatus(IStatableModel model, STATE_TYPE status);
}