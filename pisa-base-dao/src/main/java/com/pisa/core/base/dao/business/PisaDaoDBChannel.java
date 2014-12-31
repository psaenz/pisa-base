package com.pisa.core.base.dao.business;

/**
 *
 * @author PISA
 */
public interface PisaDaoDBChannel {
    
    public boolean Save(Object obj);
    public boolean Update(Object obj);
    public boolean Find(Object obj);
    
}
