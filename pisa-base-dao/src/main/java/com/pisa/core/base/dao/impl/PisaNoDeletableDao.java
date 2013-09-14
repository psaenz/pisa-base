package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.INoDeletableModelDao;
import com.pisa.core.base.model.INoDeletableModel;

/**
 * @author PISA
 */

public class PisaNoDeletableDao extends PisaBaseDao implements INoDeletableModelDao{

    @Override
    public boolean delete(INoDeletableModel model) {
        System.out.println("PisaNoDeletableDao.delete: " + model);
        return true;
    }
}