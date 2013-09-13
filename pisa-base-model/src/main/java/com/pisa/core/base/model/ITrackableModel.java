package com.pisa.core.base.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Model classes that implements this interface will be tracked which means
 * that whenever the model represented for this class is changed, the values 
 * for CreatedOn, CreatedBy, ModifiedOn, ModifiedBy fields
 * will be updated accordingly.
 * 
 * @author PISA
 */

public interface ITrackableModel {
    
    public Date getCreatedOn();
    public Date getModifiedOn();
    public String getCreatedBy();
    public String getModifiedBy();

    public void setCreatedOn(Date calendar);
    public void setModifiedOn(Date calendar);
    public void setCreatedBy(String user);
    public void setModifiedBy(String user);
}
