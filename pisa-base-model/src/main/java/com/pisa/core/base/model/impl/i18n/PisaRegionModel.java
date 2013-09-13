package com.pisa.core.base.model.impl.i18n;

import com.pisa.core.base.model.impl.PisaCatalogModel;

/**
 * <ul>
 *  <li>An Id which is the region code.</li>
 *  <li>An I18nCode so the region can be translated to any language.</li>
 *  <li>An I18nDefault the default region name (Normally used just by reference in the table).</li>
 *  <li>An StatusCode in order to know which regions are available.</li>
 * </ul>

 * @author PISA
 */

public abstract class PisaRegionModel extends PisaCatalogModel<String, String>{
    
}