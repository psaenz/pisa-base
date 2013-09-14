package com.pisa.core.base.dao.business;

import com.pisa.core.base.dao.impl.PisaBaseDao;
import com.pisa.core.base.model.exception.PisaModelRuntimeException;
import com.pisa.core.utils.patterns.factory.IProxyMethodFilter;
import com.pisa.core.utils.patterns.factory.ProxyFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

/**
 * @author PISA
 */

public class PisaDaoFactory {
    
    private static final Logger logger = Logger.getLogger(PisaDaoFactory.class.getName());

    /**
     * Creates an instance of the given modelClazz class.
     * 
     * Only public classes are supported. Inner class will fail.
     * 
     * @param <MODEL_CLASS>
     * @param modelClazz
     * @return 
     */
    public static <DAO_CLASS extends PisaBaseDao> DAO_CLASS createInstance(final Class<DAO_CLASS> daoClazz){
        // All the PisaModel classes must be abstract in order to ensure that this method is 
        // the only way to create an instance of the give class. This is important in order to 
        // support all the PisaBase interfaces defined in this project
        if (!Modifier.isAbstract(daoClazz.getModifiers())){
            throw new PisaModelRuntimeException("'" + daoClazz.getName() + "' class must be abstract. All Pisa Model defintion must be abstract.");
        }

        IProxyMethodFilter methodFilter = new IProxyMethodFilter() {

            @Override
            public boolean isHandled(Method method) {
                // Only the methods defined in the PisaModelInterface map will be handled by the method handler (PisaModelMethodHandler)
                Class declaringClass = method.getDeclaringClass();
                if (!PisaDaoInterfaceRegistry.getInstance().isRegistered(declaringClass)){
                    if (declaringClass.isInterface()){
                        throw new PisaModelRuntimeException("Unable to handle method '" + method.getName()  + 
                                "' declared on interface '" + declaringClass.getName()  +
                                "'. In order to fix this problem you must implement the method in the abstract class '" + daoClazz.getName() + "'" +
                                "' or registering the interface in the '" + PisaDaoInterfaceRegistry.class.getName() + "' registry.");
                    }

                    // The method does not belongs to any of the interfaces of PisaModel. It means 
                    // it is a method implemented on the abstract MODEL_CLASS class it self
                    return false;
                }

                // The method DOES belongs to one of the interfaces registered in PisaModelInterfaceRegistry
                // it means the method will be handled by the PisaModelMethodHandler class
                return true;
            }
        };

        // The new instance will be of the type MODEL_CLASS
        // Now we try to create the instance by given 'PisaModelMethodHandler' as the method handler
        DAO_CLASS newInstance = (DAO_CLASS) ProxyFactory.createInstance(daoClazz, methodFilter, new PisaDaoMethodHandler());

        // Returns the instance just dynamically created 
        return newInstance;
    }
}
