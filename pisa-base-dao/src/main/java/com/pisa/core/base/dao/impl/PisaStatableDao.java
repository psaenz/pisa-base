package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IStatableModelDao;
import com.pisa.core.base.model.IStatableModel;

/**
 * @author PISA
 */

public class PisaStatableDao<STATE_TYPE> extends PisaBaseDao implements IStatableModelDao<STATE_TYPE>{

    @Override
    public boolean SetStatus(IStatableModel model, STATE_TYPE status) {
        //TODO: aqui hay q actualizar el estado del objecto 
        System.out.println("PisaStatableDao.SetStatus : " + status);
        return true;
    }
}