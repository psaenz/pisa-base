package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.INoDeletableModelDao;
import com.pisa.core.base.model.INoDeletableModel;

/**
 * @author PISA
 */

public class PisaNoDeletableDao extends PisaBaseDao implements INoDeletableModelDao{

    @Override
    public boolean delete(INoDeletableModel model) {
        // TODO: Aqui tenemos q marcar al objecto como eliminado pero no eliminarlo realmente de la base de datos
        //       tambien tenemos q registrar quien y cuando lo esta eliminando
        //       esta clase tambien deberia de tener algunos metodos para hacer consultas
        //       que incluyan o no incluyan los objetos marcados como eliminados
        System.out.println("PisaNoDeletableDao.delete: " + model);
        return true;
    }
}