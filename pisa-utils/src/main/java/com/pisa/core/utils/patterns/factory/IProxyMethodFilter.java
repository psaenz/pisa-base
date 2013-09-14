package com.pisa.core.utils.patterns.factory;

import java.lang.reflect.Method;

/**
 *
 * @author PISA
 */
public interface IProxyMethodFilter {
    
    public boolean isHandled(Method method);
}
