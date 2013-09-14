package com.pisa.core.base.dao;

import com.pisa.core.base.dao.impl.PisaBaseDao;

/**
 * @author PISA
 */

public abstract class DaoTest extends PisaBaseDao implements IOneKeyModelDao<Integer>, IAuditableModelDao, IHistoricalModelDao, ITrackableModelDao{
    
}
