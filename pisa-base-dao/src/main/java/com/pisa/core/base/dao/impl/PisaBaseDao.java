package com.pisa.core.base.dao.impl;

import com.pisa.core.base.dao.IBaseDao;
import com.pisa.core.base.dao.business.PisaDaoContext;
import java.util.List;

/**
 *
 * @author PISA
 */
public class PisaBaseDao<MODEL_TYPE> implements IBaseDao<MODEL_TYPE> {
    
    protected static final ThreadLocal<PisaDaoContext> pisaDaoContext = new ThreadLocal<PisaDaoContext>(){

        @Override
        protected PisaDaoContext initialValue() {
            return new PisaDaoContext();
        }

    };

    public void SetContext(PisaDaoContext context){
        pisaDaoContext.set(context);
    }

    public PisaDaoContext.PisaDaoPublicContext GetContext(){
        return pisaDaoContext.get().GetPublicContext();
    }

    public void SetContext(String user, String transactionId){
        pisaDaoContext.get().setUser(user);
        pisaDaoContext.get().setTransactionId(transactionId);
    }

    @Override
    public boolean save(MODEL_TYPE objToSave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(MODEL_TYPE objToUpdate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MODEL_TYPE find(MODEL_TYPE objToFind) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<MODEL_TYPE> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(MODEL_TYPE objToDelete) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}