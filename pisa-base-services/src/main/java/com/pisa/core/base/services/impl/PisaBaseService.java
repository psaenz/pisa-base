/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.services.impl;

import com.pisa.core.base.services.IBaseModelService;
import java.util.List;

/**
 *
 * @author PISA
 */
public class PisaBaseService<MODEL_TYPE> implements IBaseModelService<MODEL_TYPE>{

    public boolean save(MODEL_TYPE objToSave) {
        System.out.println("PisaBaseService.save");
        return true;
    }

    public boolean update(MODEL_TYPE objToUpdate) {
        System.out.println("PisaBaseService.update");
        return true;
    }

    public MODEL_TYPE find(MODEL_TYPE objToFind) {
        System.out.println("PisaBaseService.find");
        return null;
    }

    public List<MODEL_TYPE> findAll() {
        System.out.println("PisaBaseService.findall");
        return null;
    }

    public boolean delete(MODEL_TYPE objToDelete) {
        System.out.println("PisaBaseService.delete");
        return true;
    }
    
}
