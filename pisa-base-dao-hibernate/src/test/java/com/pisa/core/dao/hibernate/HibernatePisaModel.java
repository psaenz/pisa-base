package com.pisa.core.dao.hibernate;

import com.pisa.core.base.model.ITrackableModel;
import com.pisa.core.base.model.impl.PisaBaseModel;

/**
 * An entity based on the PisaModel Framework.
 * 
 * This kind of instances must extends the {@linkplain PisaBaseModel} class and define the interfaces to 
 * implements from the package 'com.pisa.core.base.model.impl'.
 * 
 * Notice that this class is abstract and none of the methods from the interfaces are actually implemented. The 
 * PisaBaseModel framework is in charge of process the methods defined by the interfaces but they can be overwrite
 * in the abstract class (like this one).
 * 
 * @author PISA
 */

public abstract class HibernatePisaModel extends PisaBaseModel<Integer> implements ITrackableModel{

    public HibernatePisaModel(){}
    // This property was created in order to ensure PisaHibernate Framework supports overrided properties and methods.
    private String modifiedBy;

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}