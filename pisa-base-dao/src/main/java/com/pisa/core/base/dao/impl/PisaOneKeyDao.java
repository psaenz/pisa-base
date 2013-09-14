package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IOneKeyModelDao;
import com.pisa.core.base.model.IOneKeyModel;

/**
 * @author PISA
 */

public class PisaOneKeyDao<KEY_TYPE> extends PisaBaseDao implements IOneKeyModelDao<KEY_TYPE> {

    @Override
    public IOneKeyModel<KEY_TYPE> findById(KEY_TYPE key) {
        System.out.println("PisaOneKeyDao.findById : " + key);
        return null;
    }
}