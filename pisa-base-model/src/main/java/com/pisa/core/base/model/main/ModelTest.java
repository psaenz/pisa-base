package com.pisa.core.base.model.main;

import com.pisa.core.base.model.II18nModel;
import com.pisa.core.base.model.IWorkflowModel;
import com.pisa.core.base.model.impl.PisaBaseModel;

/**
 *
 * @author PISA
 */
public abstract class ModelTest extends PisaBaseModel<Integer> implements II18nModel, IWorkflowModel {

    @Override
    public String toString() {
        return "From Abstract";
    }
    
    public String getI18nCode(){
        return "From the model";
    }
}
