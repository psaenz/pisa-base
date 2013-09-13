package com.pisa.core.base.model;

/**
 * Model classes that implements this interface will support internationalization, 
 * this interface will normally used by tables that represents catalogs.
 * 
 * @author PISA
 */

public interface II18nModel {

    public String getI18nCode();
    public void setI18nCode(String i18nCode);

    public String getI18nDefault();
    public void setI18nDefault(String i18nDefault);
}