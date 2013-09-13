/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.model;

import com.pisa.core.base.model.IWorkflowModel;
import com.pisa.core.base.model.impl.PisaBaseModel;

/**
 *
 * @author PISA
 */
public abstract class PisaMixedModel extends PisaBaseModel<Integer> implements IWorkflowModel<String, String> {

    private int localVariable;

    public int getLocalVariable() {
        return localVariable;
    }

    public void setLocalVariable(int localVariable) {
        this.localVariable = localVariable;
    }

    public String getStep() {
        return "Step returned from overrided method";
    }
}