/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.model.main;

import com.pisa.core.base.model.business.PisaModelFactory;

/**
 *
 * @author PISA
 */
public class Main {
    
    public static void main(String[] args){
        //http://www.exampledepot.com/egs/java.lang.reflect/ProxyClass.html
        //PisaBaseI18nModel i18nObj = (PisaBaseI18nModel) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{PisaBaseI18nModel.class}, new PisaBaseModel());
        ModelTest i18nObj = PisaModelFactory.createInstance(ModelTest.class);
    }
}
