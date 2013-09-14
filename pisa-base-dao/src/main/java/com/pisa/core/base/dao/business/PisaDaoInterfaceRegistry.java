package com.pisa.core.base.dao.business;

import com.pisa.core.base.dao.IAuditableModelDao;
import com.pisa.core.base.dao.IHistoricalModelDao;
import com.pisa.core.base.dao.INoDeletableModelDao;
import com.pisa.core.base.dao.IOneKeyModelDao;
import com.pisa.core.base.dao.IStatableModelDao;
import com.pisa.core.base.dao.ITrackableModelDao;
import com.pisa.core.base.dao.IWorkflowModelDao;
import com.pisa.core.base.dao.impl.PisaAuditableDao;
import com.pisa.core.base.dao.impl.PisaBaseDao;
import com.pisa.core.base.dao.impl.PisaHistoricalDao;
import com.pisa.core.base.dao.impl.PisaNoDeletableDao;
import com.pisa.core.base.dao.impl.PisaOneKeyDao;
import com.pisa.core.base.dao.impl.PisaStatableDao;
import com.pisa.core.base.dao.impl.PisaTrackableDao;
import com.pisa.core.base.dao.impl.PisaWorkflowDao;
import com.pisa.core.base.model.business.PisaModelFactory;
import com.pisa.core.utils.patterns.registry.Registry;

/**
 * @author PISA
 */

class PisaDaoInterfaceRegistry extends Registry<Class, PisaBaseDao> {

    private static PisaDaoInterfaceRegistry singleton = null;

    /**
     * Registry all the IPisaBaseModels so the {@linkplain PisaModelFactory} can 
     * determine when to process a method or leave the method to be process by his own ModelClass
     */
    private PisaDaoInterfaceRegistry(){
        super(true);
        this.register(IAuditableModelDao.class, new PisaAuditableDao());
        this.register(IHistoricalModelDao.class, new PisaHistoricalDao());
        this.register(INoDeletableModelDao.class, new PisaNoDeletableDao());
        this.register(IOneKeyModelDao.class, new PisaOneKeyDao());
        this.register(IStatableModelDao.class, new PisaStatableDao());
        this.register(ITrackableModelDao.class, new PisaTrackableDao());
        this.register(IWorkflowModelDao.class, new PisaWorkflowDao());
    }

    public static PisaDaoInterfaceRegistry getInstance(){
        if (singleton == null)
            singleton = new PisaDaoInterfaceRegistry();
        return singleton;
    }
}