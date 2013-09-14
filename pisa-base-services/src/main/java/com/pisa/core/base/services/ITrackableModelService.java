package com.pisa.core.base.services;

import com.pisa.core.base.model.ITrackableModel;
import java.util.Calendar;

/**
 * Dao classes that implements this interface will be in charge of persist Trackable model objects.
 * 
 * Trackable models objects are those that implements the {@linkplain ITrackableModel} interface.
 * 
 * When a Trackable models is created or modified by someone, the information from the author is saved
 * as well as the date and time when the action occurred.
 * 
 * @author PISA
 */

public interface ITrackableModelService {

    /**
     * Saves the Trackable model object at the same time the information of whom
     * is creating the instance.
     * 
     * @param model
     * @param createdBy
     * @return 
     */
    public boolean save(ITrackableModel model, String createdBy);

    /**
     * Updates the Trackable model object at the same time the information of whom
     * is ,modifying the object.
     * @param model
     * @param modifiedBy
     * @return 
     */
    public boolean update(ITrackableModel model, String modifiedBy);

}