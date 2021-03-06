package com.pisa.core.base.dao;

import java.util.List;

/**
 * This Interface defines a set of methods that ALL Daos must provide.
 * 
 * @author PISA
 */

public interface IBaseDao<MODEL_TYPE> {

    boolean save(MODEL_TYPE objToSave);
    
    boolean update(MODEL_TYPE objToUpdate);

    /**
     * Searches for an object by using the properties that represents the primary key.
     * 
     * @return list of <MODEL_TYPE> objects 
     */
    MODEL_TYPE find(MODEL_TYPE objToFind);

    /**
     * Returns the entire list of objects registered in the database
     * @return list of <MODEL_TYPE> objects 
     */
    List<MODEL_TYPE> findAll();

    /**
     * Deletes the given object from the database
     * 
     * @param objToDelete, object to delete
     * @return <b>true</b> when the object was found and successfully deleted. 
     *          <b>false</b> when the object is not found or it wasn't able to delete it
     */
    boolean delete(MODEL_TYPE objToDelete);
}