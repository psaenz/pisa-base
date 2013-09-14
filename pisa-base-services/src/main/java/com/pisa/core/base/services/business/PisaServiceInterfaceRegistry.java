package com.pisa.core.base.services.business;

import com.pisa.core.base.model.business.PisaModelFactory;
import com.pisa.core.base.services.IHistoricalModelService;
import com.pisa.core.base.services.INoDeletableModelService;
import com.pisa.core.base.services.IOneKeyModelService;
import com.pisa.core.base.services.IStatableModelService;
import com.pisa.core.base.services.ITrackableModelService;
import com.pisa.core.base.services.IWorkflowModelService;
import com.pisa.core.base.services.impl.HistoricalModelService;
import com.pisa.core.base.services.impl.NoDeletableModelService;
import com.pisa.core.base.services.impl.OneKeyModelService;
import com.pisa.core.base.services.impl.PisaBaseService;
import com.pisa.core.base.services.impl.StatableModelService;
import com.pisa.core.base.services.impl.TrackableModelService;
import com.pisa.core.base.services.impl.WorkflowModelService;
import com.pisa.core.utils.patterns.registry.Registry;

/**
 *
 * @author PISA
 */
public class PisaServiceInterfaceRegistry extends Registry<Class, PisaBaseService> {

    private static PisaServiceInterfaceRegistry singleton = null;

    /**
     * Registry all the base service interfases, so the {@linkplain PisaServiceFactory} can 
     * determine when to handle a method or leave the method to be process by his own ServiceClass
     */
    private PisaServiceInterfaceRegistry(){
        super(true);
        this.register(IHistoricalModelService.class, new HistoricalModelService());
        this.register(INoDeletableModelService.class, new NoDeletableModelService());
        this.register(IOneKeyModelService.class, new OneKeyModelService());
        this.register(IStatableModelService.class, new StatableModelService());
        this.register(ITrackableModelService.class, new TrackableModelService());
        this.register(IWorkflowModelService.class, new WorkflowModelService());
    }

    public static PisaServiceInterfaceRegistry getInstance(){
        if (singleton == null)
            singleton = new PisaServiceInterfaceRegistry();
        return singleton;
    }
}