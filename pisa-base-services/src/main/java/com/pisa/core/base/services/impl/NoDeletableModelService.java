/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.INoDeletableModel;
import com.pisa.core.base.services.INoDeletableModelService;

/**
 *
 * @author PISA
 */
public class NoDeletableModelService extends PisaBaseService implements INoDeletableModelService {

    public boolean delete(INoDeletableModel model) {
        System.out.println("No deletable object");
        return true;
    }
   
    
}
