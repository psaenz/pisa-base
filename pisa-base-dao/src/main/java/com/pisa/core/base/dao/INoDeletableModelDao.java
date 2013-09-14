package com.pisa.core.base.dao;

import com.pisa.core.base.model.INoDeletableModel;

/**
 * Dao classes that implements this interface will be in charge of persist no-deletable model objects.
 * 
 * No-Deletable models objects are those that implements the {@linkplain INoDeletableModel} interface.
 * 
 * This kind of objects are never deleted but marked as deleted
 * 
 * @author PISA
 */

public interface INoDeletableModelDao {
    
    /**
     * This method is in charge of mark the object as deleted, but will never be actually deleted
     * @param model
     * @return 
     */
    public boolean delete(INoDeletableModel model);

}