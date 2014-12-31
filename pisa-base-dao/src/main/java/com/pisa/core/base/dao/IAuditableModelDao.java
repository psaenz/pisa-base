package com.pisa.core.base.dao;

import com.pisa.core.base.dao.impl.PisaDaoAction;
import com.pisa.core.base.model.IAuditableModel;

/**
 * Dao classes that implements this interface will be in charge of persist auditable model objects.
 * 
 * Auditable models objects are those that implements the {@linkplain IAuditableModel} interface.
 * 
 * @author PISA
 */

public interface IAuditableModelDao {

    /**
     * This method will save the information of the fields that will be changed as well as its previous
     * and new value.
     * 
     * @param oldModel
     * @param newModel
     * @param action
     * @return 
     */
    public boolean auditAction(IAuditableModel oldModel, IAuditableModel newModel, PisaDaoAction action);

}
