package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.ITrackableModelDao;
import com.pisa.core.base.model.ITrackableModel;

/**
 * @author PISA
 */

public class PisaTrackableDao extends PisaBaseDao implements ITrackableModelDao {

    public boolean save(ITrackableModel model, String createdBy) {
        System.out.println("PisaTrackableDao.saved : " + createdBy);
        return true;
    }

    public boolean update(ITrackableModel model, String modifiedBy) {
        System.out.println("PisaTrackableDao.modified : " + modifiedBy);
        return true;
    }
}