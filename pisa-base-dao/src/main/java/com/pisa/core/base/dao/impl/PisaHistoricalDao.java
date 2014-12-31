package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IHistoricalModelDao;
import com.pisa.core.base.model.IHistoricalModel;

/**
 * @author PISA
 */

public class PisaHistoricalDao extends PisaBaseDao implements IHistoricalModelDao{

    @Override
    public boolean sendToHistory(IHistoricalModel model) {
        // TODO: Aqui tengo q llenar algunas propiedades antes de enviarlo a historico
        //       asi como la fecha cuando fue enviado a historico
        //       el usuario q lo esta enviando a historico
        //       tambien tenemos q eliminar el objeto original
        System.out.println("PisaHistoricalDao.sendToHistory: " + model);
        return true;
    }

    @Override
    public IHistoricalModel getFromHistory(IHistoricalModel model) {
        System.out.println("PisaHistoricalDao.sendToHistory");
        return null;
    }
}