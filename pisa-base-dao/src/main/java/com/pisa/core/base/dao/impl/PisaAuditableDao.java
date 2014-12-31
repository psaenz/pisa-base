package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IAuditableModelDao;
import com.pisa.core.base.model.IAuditableModel;
import com.pisa.core.utils.compare.Compare;
import com.pisa.core.utils.compare.CompareResult;
import com.pisa.core.utils.compare.CompareResult.CompareResultDetail;

/**
 *
 * @author PISA
 */

public class PisaAuditableDao extends PisaBaseDao implements IAuditableModelDao{

    @Override
    public boolean auditAction(IAuditableModel oldModel, IAuditableModel newModel, PisaDaoAction action) throws IllegalArgumentException {
        if (action == null)
            throw new java.lang.IllegalArgumentException(PisaDaoAction.class.getName() + " argument cannot be null.");

        if (action == PisaDaoAction.UPDATE){
            CompareResult result = Compare.Compare(oldModel, newModel);
            if (result.getDifferencesFound()){
               for(CompareResultDetail detail : result.getDetails()){
                   detail.getPropertyComparing();
                   detail.getObj1Value();
                   detail.getObj2Value();
               }
            }
        }

        return true;
    }
}