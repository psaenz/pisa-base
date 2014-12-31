/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.IStatableModel;
import com.pisa.core.base.model.IWorkflowModel;
import com.pisa.core.base.services.IWorkflowModelService;

/**
 *
 * @author PISA
 */
public class WorkflowModelService<STEP_TYPE> extends PisaBaseService implements IWorkflowModelService<STEP_TYPE> {
    
    /**
     * Updates the Workflow object in order to move it to the next step
     * @param model
     * @return 
     */
    public boolean MoveToNextStep(IWorkflowModel model){
        System.out.println("Moving to next step");
        return true;
    }
    
    /**
     * Updates the Workflow object in order to move it to the previous step
     * @param model
     * @return 
     */
    public boolean MoveToPreviousStep(IWorkflowModel model){
        System.out.println("Moving to previous step");
        return true;
    }
    
    /**
     * Updates the Workflow object in order to move it to the given step
     * @param model
     * @param step
     * @return 
     */
    public boolean MoveToStep(IWorkflowModel model, STEP_TYPE step){
        System.out.println("Moving to step " + step);
        return true;
    }
}