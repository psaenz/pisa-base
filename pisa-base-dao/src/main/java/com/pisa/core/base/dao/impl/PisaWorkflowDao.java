package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IWorkflowModelDao;
import com.pisa.core.base.model.IWorkflowModel;

/**
 * @author PISA
 */

public class PisaWorkflowDao<STEP_TYPE, STATUS_TYPE> extends PisaStatableDao<STATUS_TYPE> implements IWorkflowModelDao<STEP_TYPE, STATUS_TYPE> {

    @Override
    public boolean MoveToNextStep(IWorkflowModel model) {
        System.out.println("PisaWorkflowDao.MoveToNextStep : " + model);
        return true;
    }

    @Override
    public boolean MoveToPreviousStep(IWorkflowModel model) {
        System.out.println("PisaWorkflowDao.MoveTopreviousStep : " + model);
        return true;
    }

    @Override
    public boolean MoveToStep(IWorkflowModel model, STEP_TYPE step) {
        System.out.println("PisaWorkflowDao.MoveToStep : " + step);
        return true;
    }
}