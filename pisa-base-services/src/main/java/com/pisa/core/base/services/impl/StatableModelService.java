/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.IStatableModel;
import com.pisa.core.base.services.IStatableModelService;

/**
 *
 * @author PISA
 */
public class StatableModelService <STATE_TYPE> extends PisaBaseService implements IStatableModelService<STATE_TYPE>{

    public boolean SetStatus(IStatableModel model, STATE_TYPE status) {
        System.out.println("SetStatus to " + status);
        return true;
    }
}
