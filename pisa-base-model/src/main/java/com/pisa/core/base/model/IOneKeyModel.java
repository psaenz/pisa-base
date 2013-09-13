package com.pisa.core.base.model;

/**
 * This interface defined a unique primary key, most of the model definitions must have a unique
 * PK but this framework doesn't limit PKs to only one.
 * 
 * @author PISA
 */

public interface IOneKeyModel<KEY_TYPE> {
    
    KEY_TYPE getId();
    void setId(KEY_TYPE id);
}