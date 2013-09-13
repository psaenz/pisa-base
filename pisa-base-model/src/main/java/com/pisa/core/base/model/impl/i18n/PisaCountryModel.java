package com.pisa.core.base.model.impl.i18n;

import com.pisa.core.base.model.impl.PisaCatalogModel;

/**
 * A Country model instance will have:
 * <ul>
 *  <li>An Id which is the country code.</li>
 *  <li>An I18nCode so the country name can be translated to any language.</li>
 *  <li>An I18nDefault the default country name (Normally used just by reference in the table).</li>
 *  <li>An StatusCode in order to know which countries are available.</li>
 * </ul>
 * 
 * @author PISA
 */

public abstract class PisaCountryModel extends PisaCatalogModel<String, String>{

    private PisaRegionModel region = null;

    public PisaRegionModel getRegion() {
        return region;
    }

    public void setRegion(PisaRegionModel region) {
        this.region = region;
    }
}