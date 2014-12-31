package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IWorkflowModelDao;
import com.pisa.core.base.model.IWorkflowModel;

/**
 * @author PISA
 */

public class PisaWorkflowDao<STEP_TYPE> extends PisaBaseDao implements IWorkflowModelDao<STEP_TYPE> {

    @Override
    public boolean MoveToNextStep(IWorkflowModel model) {
        System.out.println("PisaWorkflowDao.MoveToNextStep : " + model);
         
        /*
        leer http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
        https://community.jboss.org/wiki/GenericDataAccessObjects
        https://community.jboss.org/wiki/SessionsAndTransactions
        https://community.jboss.org/wiki/OpenSessionInView
        */ 
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