package com.pisa.core.base.model.impl;

import com.pisa.core.base.model.IOneKeyModel;

/**
 * All the models must extend this class in order to provide a ROOT common class and ensure
 * all the classes has an unique ID which improves indexing process on database when querying.
 * 
 * @author PISA
 */

public abstract class PisaBaseModel<KEY_TYPE> implements IOneKeyModel<KEY_TYPE> {
}