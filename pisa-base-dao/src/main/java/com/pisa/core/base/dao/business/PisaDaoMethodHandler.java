package com.pisa.core.base.dao.business;

import com.pisa.core.base.dao.impl.PisaBaseDao;
import com.pisa.core.base.model.business.PisaModelFactory;
import com.pisa.core.base.model.exception.PisaModelException;
import com.pisa.core.utils.patterns.factory.IProxyMethodHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javassist.util.proxy.MethodHandler;

/**
 * This class implements a {@linkplain  IProxyMethodHandler} in order handle all the 
 * methods defined in the BaseModel interfaces defined on the {@code com.pisa.core.base.model.IPisaBase*}
 * package.
 * 
 * All the interfaces that needs to be handle by this class must be registered in the {@linkplain PisaModelInterfaceRegistry}.
 * 
 * When a Model instance is created by the {@linkplain PisaModelFactory} this MethodHandler
 * is associated with it.
 * 
 * @author PISA
 */

public class PisaDaoMethodHandler implements IProxyMethodHandler {

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] os) throws Throwable {
        System.out.println("Handling method " + method.getName());
        PisaBaseDao dao = PisaDaoInterfaceRegistry.getInstance().getRegistry(method.getDeclaringClass());
        return method.invoke(dao, os);
    }
}