/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.model.IHistoricalModel;
import com.pisa.core.base.services.IHistoricalModelService;

/**
 *
 * @author PISA
 */
public class HistoricalModelService extends PisaBaseService implements IHistoricalModelService {

    public IHistoricalModel getFromHistory(IHistoricalModel model) {
        System.out.println("Getting object from history");
        return null;
    }

    public boolean sendToHistory(IHistoricalModel model) {
        System.out.println("Sending object '" + model + "' to history");
        return true;
    }
}