package com.pisa.core.base.model.business;

import com.pisa.core.base.model.exception.PisaModelRuntimeException;
import com.pisa.core.base.model.impl.PisaBaseModel;
import com.pisa.core.utils.patterns.factory.IProxyMethodFilter;
import com.pisa.core.utils.patterns.factory.ProxyFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

/**
 * This class will create objects that implements interfaces registered in the {@linkplain PisaModelInterfaceRegistry}
 * 
 * @author PISA
 */

public class PisaModelFactory {
    
    //private static Logger logger = Logger.getLogger(PisaModelFactory.class.getName());

    /**
     * Creates an instance of the given modelClazz class.
     * 
     * Only public classes are supported. Inner class will fail.
     * 
     * @param <MODEL_CLASS>
     * @param modelClazz
     * @return 
     */
    public static <MODEL_CLASS extends PisaBaseModel> MODEL_CLASS createInstance(final Class<MODEL_CLASS> modelClazz){
        // All the PisaModel classes must be abstract in order to ensure that this method is 
        // the only way to create an instance of the give class. This is important in order to 
        // support all the PisaBase interfaces defined in this project
        if (!Modifier.isAbstract(modelClazz.getModifiers()))
            throw new PisaModelRuntimeException("'" + modelClazz.getName() + "' class must be abstract. All Pisa Model defintion must be abstract.");

        // Now we need to define a method filter in order to determi which methods will be handle by the
        //modelClazz implementation or will be handled by the method handler (PisaModelMethodHandler)
        IProxyMethodFilter methodFilter = new IProxyMethodFilter() {

            @Override
            public boolean isHandled(Method method) {
                // Only the methods defined in the PisaModelInterface map will be handled by the method handler (PisaModelMethodHandler)
                Class declaringClass = method.getDeclaringClass();
                if (!PisaModelInterfaceRegistry.getInstance().isRegistered(method.getDeclaringClass())){
                    if (declaringClass.isInterface()){
                        throw new PisaModelRuntimeException("Unable to handle method '" + method.getName()  + 
                                "' declared on interface '" + declaringClass.getName()  +
                                "'. In order to fix this problem you must implement the method in the abstract class '" + modelClazz.getName() + "'" +
                                "' or registering the interface in the '" + PisaModelInterfaceRegistry.class.getName() + "' registry.");
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
        MODEL_CLASS newInstance = null;

        // Now we try to create the instance by given 'PisaModelMethodHandler' as the method handler
        newInstance = (MODEL_CLASS) ProxyFactory.createInstance(modelClazz, methodFilter, new PisaModelMethodHandler());

        // Returns the instance just dynamically created 
        return newInstance;
    }

    public static boolean isPisaModelClass(Class clazz){
        return PisaBaseModel.class.isAssignableFrom(clazz);
    }

    public static boolean isProxyPisaModelClass(Class clazz){
        return isPisaModelClass(clazz) && ProxyFactory.isProxyClass(clazz);
    }
}