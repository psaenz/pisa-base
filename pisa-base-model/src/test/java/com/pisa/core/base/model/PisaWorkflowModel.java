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
public abstract class PisaWorkflowModel extends PisaBaseModel<Integer> implements IWorkflowModel<String, String> {
}