/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.IOneKeyModel;
import com.pisa.core.base.services.IOneKeyModelService;
import java.io.Serializable;

/**
 *
 * @author PISA
 */
public class OneKeyModelService <KEY_TYPE extends Serializable> extends PisaBaseService implements IOneKeyModelService<KEY_TYPE>{

    public IOneKeyModel<KEY_TYPE> findById(KEY_TYPE key) {
        System.out.println("OneKeyModelService findById");
        return null;
    }

}
