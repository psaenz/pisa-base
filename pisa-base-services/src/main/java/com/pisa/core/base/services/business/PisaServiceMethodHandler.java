package com.pisa.core.base.services.business;

import com.pisa.core.base.services.impl.PisaBaseService;
import com.pisa.core.utils.patterns.factory.IProxyMethodHandler;
import java.lang.reflect.Method;

/**
 * This class implements a {@linkplain IProxyMethodHandler} in order to handle all the 
 * methods defined in the base services interfaces defined on the {@code com.pisa.core.base.services.*}
 * package.
 * 
 * All the interfaces (of the type service) that need to be handle by this class must be registered in the {@linkplain PisaServiceInterfaceRegistry}.
 * 
 * When a Service instance is created by the {@linkplain PisaServiceFactory} this MethodHandler
 * is associated with it.
 * 
 * @author PISA
 */

public class PisaServiceMethodHandler implements IProxyMethodHandler {

    public Object invoke(Object o, Method method, Method method1, Object[] os) throws Throwable {
        PisaBaseService service = PisaServiceInterfaceRegistry.getInstance().getRegistry(method.getDeclaringClass());
        return method.invoke(service, os);
    }
}