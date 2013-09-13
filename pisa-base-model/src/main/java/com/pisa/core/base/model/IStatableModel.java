package com.pisa.core.base.model;

/**
 * Model classes that implements this interface will support an state.
 * 
 * State could be any type of value, and can mean for instance that the represented model 
 * is in an status of Active, or Completed, or is Pending.
 * 
 * @author PISA
 */

public interface IStatableModel<STATE_TYPE> {

    public STATE_TYPE getStatusCode();
    public void setStatusCode(STATE_TYPE status);
}