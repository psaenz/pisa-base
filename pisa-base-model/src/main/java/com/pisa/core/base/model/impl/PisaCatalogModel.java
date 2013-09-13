package com.pisa.core.base.model.impl;

import com.pisa.core.base.model.II18nModel;
import com.pisa.core.base.model.IStatableModel;

/**
 * This class defines the basic structure for a Catalog table.
 * 
 * Catalog models that extends this class will have:
 * <ul>
 *  <li>An unique id for each instance or registry.</li>
 *  <li>An i18nCode in order to support internationalization which means the catalogs can be translate to any language.</li>
 *  <li>An statusCode in order to support catalogs with an status value, this status can indicate if the instance is active or inactive for instance.</li>
 * </ul>
 *
 * @author PISA
 */

public abstract class PisaCatalogModel<KEY_TYPE, STATE_TYPE> extends PisaBaseModel<KEY_TYPE> implements II18nModel, IStatableModel<STATE_TYPE> {

}