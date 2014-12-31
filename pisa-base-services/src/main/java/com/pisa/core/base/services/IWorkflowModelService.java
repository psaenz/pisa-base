package com.pisa.core.base.services;

import com.pisa.core.base.model.IWorkflowModel;

/**
 * Service classes that implements this interface will be in charge of persist Workflow model objects.
 * 
 * Workflow models objects are those that implements the {@linkplain IWorkflowModel} interface.
 * 
 * A Workflow model object has steps that identifies the current state of the workflow. 
 * The Service needs to provide all the necessary methods to move between those steps.
 * 
 * @author PISA
 */

public interface IWorkflowModelService<STEP_TYPE> {

    /**
     * Updates the Workflow object in order to move it to the next step
     * @param model
     * @return 
     */
    public boolean MoveToNextStep(IWorkflowModel model);
    
    /**
     * Updates the Workflow object in order to move it to the previous step
     * @param model
     * @return 
     */
    public boolean MoveToPreviousStep(IWorkflowModel model);
    
    /**
     * Updates the Workflow object in order to move it to the given step
     * @param model
     * @param step
     * @return 
     */
    public boolean MoveToStep(IWorkflowModel model, STEP_TYPE step);
}