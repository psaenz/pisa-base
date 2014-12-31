/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.ITrackableModel;
import com.pisa.core.base.services.ITrackableModelService;

/**
 *
 * @author PISA
 */
public class TrackableModelService extends PisaBaseService implements ITrackableModelService{

    public boolean save(ITrackableModel model, String createdBy) {
        System.out.println("TrackableModelService save");
        return true;
    }

    public boolean update(ITrackableModel model, String modifiedBy) {
        System.out.println("TrackableModelService update");
        return true;
    }
}
