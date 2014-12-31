/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.dao;

import com.pisa.core.base.model.IAuditableModel;
import com.pisa.core.base.model.IOneKeyModel;
import com.pisa.core.base.model.impl.PisaBaseModel;

/**
 *
 * @author PISA
 */
public abstract class Model4Tests extends PisaBaseModel<Integer> implements IOneKeyModel<Integer>, IAuditableModel {
    
}
