package com.pisa.core.utils.patterns.factory;

import java.lang.reflect.Method;

/**
 *
 * @author PISA
 */
public interface IProxyMethodHandler {
 
    public Object invoke(Object o, Method method, Method method1, Object[] os) throws Throwable;

}
