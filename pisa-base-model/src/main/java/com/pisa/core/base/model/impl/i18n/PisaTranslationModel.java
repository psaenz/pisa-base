package com.pisa.core.base.model.impl.i18n;

import com.pisa.core.base.model.II18nModel;

/**
 * This class is intended to be used to represent a table with translations used 
 * within the application.
 * 
 * This class contains a i18nCode inherited from {@linkplain IPisaBaseI18nModel} which
 * represents the KEY for the translation.
 * 
 * This class also contains a {@linkplain PisaLanguageModel} in order to determine the language
 * for the given translation.
 * 
 * @author PISA
 */

public abstract class PisaTranslationModel implements II18nModel {

    private PisaLanguageModel language;
    private String translation;

    public PisaLanguageModel getLanguage() {
        return language;
    }

    public void setLanguage(PisaLanguageModel language) {
        this.language = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}