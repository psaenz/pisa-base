package com.pisa.core.base.dao;

import com.pisa.core.base.dao.impl.PisaBaseDao;

/**
 * @author PISA
 */

public abstract class DaoTest extends PisaBaseDao<Model4Tests> implements IOneKeyModelDao<Model4Tests, Integer>, IAuditableModelDao, IHistoricalModelDao, ITrackableModelDao {
    
}
