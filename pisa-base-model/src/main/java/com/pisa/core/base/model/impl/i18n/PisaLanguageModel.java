package com.pisa.core.base.model.impl.i18n;

import com.pisa.core.base.model.impl.PisaCatalogModel;

/**
 * A Language model instance will have:
 * <ul>
 *  <li>An Id which is the language code.</li>
 *  <li>An I18nCode so the language can be translated to any other language.</li>
 *  <li>An I18nDefault the default language name (Normally used just by reference in the table).</li>
 *  <li>An StatusCode in order to know which languages are available.</li>
 * </ul>

 * @author PISA
 */

public abstract class PisaLanguageModel extends PisaCatalogModel<String, String> {

}