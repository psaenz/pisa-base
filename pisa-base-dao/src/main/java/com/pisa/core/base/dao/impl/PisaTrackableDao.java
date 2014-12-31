package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.ITrackableModelDao;
import com.pisa.core.base.model.IOneKeyModel;
import com.pisa.core.base.model.ITrackableModel;
import java.io.Serializable;

/**
 * @author PISA
 */

public class PisaTrackableDao extends PisaBaseDao implements ITrackableModelDao {

    public boolean save(ITrackableModel model) {
        //TODO: todavia no estoy seguro de recibir el createdBy por parametro
        //      mas bien estoy pensando en un contexto que se comparte dentro de una misma transaccion
        System.out.println("PisaTrackableDao.saved : " + this.GetContext().getUser());
        this.SetContext("psaenz", "123");
        return true;
    }

    public boolean update(ITrackableModel model) {
        System.out.println("PisaTrackableDao.modified : " + this.GetContext().getUser());
        return true;
    }

    public IOneKeyModel findById(Serializable key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}