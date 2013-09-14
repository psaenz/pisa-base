package com.pisa.core.base.dao;

import com.pisa.core.base.model.IHistoricalModel;
import java.util.Calendar;

/**
 * Dao classes that implements this interface will be in charge of persist historical model objects.
 * 
 * Auditable models objects are those that implements the {@linkplain IHistoricalModel} interface.
 * 
 * Normally, the first time an Historical object is created, it is saved in a table (Initial-Table) and will be there
 * until something decide to send the record to its historical which is another table (Historical-Table).
 * 
 * The Initial-Table is used to store records that will be retrieved very often for a period of time, after that period, 
 * it is suppose that the record will be retrieved occassionally or maybe never, so it is send to the Historical-Table,
 * in this way the records that are kept on the Initial-Table are retrieved very quick.
 * 
 * @author PISA
 */

public interface IHistoricalModelDao {

    /**
     * Moves an Historical object from the Initial-Table to his Historical-Table
     * 
     * @param model
     * @return 
     */
    public boolean sendToHistory(IHistoricalModel model);

    /**
     * Retrieves an Historical object from his Historical-Table
     * @param model
     * @return 
     */
    public IHistoricalModel getFromHistory(IHistoricalModel model);
}