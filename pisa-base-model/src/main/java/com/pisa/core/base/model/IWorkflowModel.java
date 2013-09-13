package com.pisa.core.base.model;

/**
 * Model classes that implements this interface will support workflow process.
 * 
 * A record associated with a workflow will need at the an indicator for the current status and the current step
 * within the workflow process.
 * 
 * @author PISA
 */

public interface IWorkflowModel<STEP_TYPE, STATUS_TYPE> extends IStatableModel<STATUS_TYPE> {

    public STEP_TYPE getStep();
    public void setStep(STEP_TYPE step);

    // this property must not be saved into the database
    public int getNumberOfSteps();
    public void setNumberOfSteps(int steps);
}