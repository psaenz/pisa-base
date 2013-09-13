package com.pisa.core.base.model.business;

import com.pisa.core.base.model.IAuditableModel;
import com.pisa.core.base.model.IHistoricalModel;
import com.pisa.core.base.model.II18nModel;
import com.pisa.core.base.model.INoDeletableModel;
import com.pisa.core.base.model.IOneKeyModel;
import com.pisa.core.base.model.IStatableModel;
import com.pisa.core.base.model.ITrackableModel;
import com.pisa.core.base.model.IWorkflowModel;
import com.pisa.core.utils.patterns.registry.Registry;

/**
 * @author PISA
 */

class PisaModelInterfaceRegistry extends Registry<Class, Class> {

    private static PisaModelInterfaceRegistry singleton = null;

    /**
     * Registry all the IPisaBaseModels so the {@linkplain PisaModelFactory} can 
     * determine when to process a method or leave the method to be process by his own ModelClass
     */
    private PisaModelInterfaceRegistry(){
        super(true);
        this.register(IAuditableModel.class, IAuditableModel.class);
        this.register(IHistoricalModel.class, IHistoricalModel.class);
        this.register(II18nModel.class, II18nModel.class);
        this.register(INoDeletableModel.class, INoDeletableModel.class);
        this.register(IOneKeyModel.class, IOneKeyModel.class);
        this.register(IStatableModel.class, IStatableModel.class);
        this.register(ITrackableModel.class, ITrackableModel.class);
        this.register(IWorkflowModel.class, IWorkflowModel.class);
    }

    public static PisaModelInterfaceRegistry getInstance(){
        if (singleton == null)
            singleton = new PisaModelInterfaceRegistry();
        return singleton;
    }
}