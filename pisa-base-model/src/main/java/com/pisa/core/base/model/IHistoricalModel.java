package com.pisa.core.base.model;

import java.util.Calendar;

/**
 * Model classes that implements this interface will allow records to be
 * moved to an historical table.
 * 
 * @author PISA
 */

public interface IHistoricalModel {

    public Boolean getIsInHistory();
    public void setIsInHistory(Boolean isInHistory);

    // Date when the instance was sent to history
    public Calendar getOnHistorySince();
    public void setOnHistorySince(Calendar historyDate);
}