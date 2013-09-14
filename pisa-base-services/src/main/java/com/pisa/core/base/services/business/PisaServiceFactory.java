package com.pisa.core.base.services.business;

import com.pisa.core.base.model.exception.PisaModelRuntimeException;
import com.pisa.core.base.services.impl.PisaBaseService;
import com.pisa.core.utils.patterns.factory.IProxyMethodFilter;
import com.pisa.core.utils.patterns.factory.ProxyFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

/**
 * @author PISA
 */

public class PisaServiceFactory {
    
    private static final Logger logger = Logger.getLogger(PisaServiceFactory.class.getName());

    /**
     * Creates an instance of the given modelClazz class.
     * 
     * Only public classes are supported. Inner class will fail.
     * 
     * @param <MODEL_CLASS>
     * @param modelClazz
     * @return 
     */
    public static <SERVICE_CLASS extends PisaBaseService> SERVICE_CLASS createInstance(final Class<SERVICE_CLASS> serviceClazz){
        // All the PisaServices classes must be abstract in order to ensure that this method is 
        // the only way to create an instance of the give class. This is important in order to 
        // support all the PisaBase services interfaces defined in this project
        if (!Modifier.isAbstract(serviceClazz.getModifiers())){
            throw new PisaModelRuntimeException("'" + serviceClazz.getName() + "' class must be abstract. All Pisa Model Services defintion must be abstract.");
        }

        IProxyMethodFilter methodFilter = new IProxyMethodFilter() {

            @Override
            public boolean isHandled(Method method) {
                // Only the methods defined in the PisaModelInterface map will be handled by the method handler (PisaModelMethodHandler)
                Class declaringClass = method.getDeclaringClass();
                if (!PisaServiceInterfaceRegistry.getInstance().isRegistered(declaringClass)){
                    if (declaringClass.isInterface()){
                        throw new PisaModelRuntimeException("Unable to handle method '" + method.getName()  + 
                                "' declared on interface '" + declaringClass.getName()  +
                                "'. In order to fix this problem you must implement the method in the abstract class '" + serviceClazz.getName() + "'" +
                                "' or registering the interface in the '" + PisaServiceInterfaceRegistry.class.getName() + "' registry.");
                    }

                    // The method does not belongs to any of the interfaces of PisaModel Services. It means 
                    // it is a method implemented on the abstract service class
                    return false;
                }

                // The method DOES belongs to one of the interfaces registered in PisaServiceInterfaceRegistry
                // it means the method will be handled by the PisaModelMethodHandler class
                return true;
            }
        };

        // The new instance will be of the type MODEL_CLASS
        // Now we try to create the instance by given 'PisaModelMethodHandler' as the method handler
        SERVICE_CLASS newInstance = (SERVICE_CLASS) ProxyFactory.createInstance(serviceClazz, methodFilter, new PisaServiceMethodHandler());

        // Returns the instance just dynamically created 
        return newInstance;
    }
}
