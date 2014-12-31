package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IOneKeyModelDao;
import com.pisa.core.base.model.IOneKeyModel;
import java.io.Serializable;

/**
 * @author PISA
 */

public class PisaOneKeyDao<MODEL_TYPE extends IOneKeyModel, KEY_TYPE extends Serializable> extends PisaBaseDao<MODEL_TYPE> implements IOneKeyModelDao<MODEL_TYPE, KEY_TYPE> {

    @Override
    public MODEL_TYPE findById(KEY_TYPE key) {
        System.out.println("PisaOneKeyDao.findById : " + key);
        return null;
    }
}