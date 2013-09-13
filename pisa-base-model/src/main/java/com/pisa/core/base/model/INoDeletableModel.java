package com.pisa.core.base.model;

import java.util.Calendar;

/**
 * Model classes that implements this interface will avoid records from being deleted,
 * instead they will be marked as deleted instead of remove the record from the database.
 * 
 * @author PISA
 */

public interface INoDeletableModel {
    
    public Boolean getIsDeleted();
    public void setIsDeleted(Boolean isDeleted);

    public String getDeletedBy();
    public void setDeletedBy(String deletedBy);

    // Date when the instance was sent to history
    public Calendar getDeletedOn();
    public void setDeletedOn(Calendar deletedOn);
}