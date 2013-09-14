package com.pisa.core.utils.patterns.factory;

import com.pisa.core.utils.exception.PisaUtilsRuntimeException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;

/**
 * The ProxyFactory helps the way proxies are created.
 * 
 * @author PISA
 */

public class ProxyFactory {
    
    private static Logger logger = Logger.getLogger(ProxyFactory.class.getName());

    /**
     * Creates a proxy for a new instance of the type {@code clazzToInstantiate].
     * 
     * @param <MODEL_CLASS>
     * @param clazzToInstantiate : The class to be proxied.
     * @param methodFilter: A {@linkplain MethodFilter} definition in order to determine which methods will be handled by the methodHandler or by the clazzToInstantiate.
     * @param methodHandler: A {@linkplain MethodHandler} that will process all the methods for which the MethodFilter returns true.
     * @return 
     */
    public static <MODEL_CLASS> MODEL_CLASS createInstance(Class<MODEL_CLASS> clazzToInstantiate, final IProxyMethodFilter proxyMethodFilter, final IProxyMethodHandler proxyMethodHandler){
        // ProxyFactory helps us to create instances dynamically
        javassist.util.proxy.ProxyFactory factory = new javassist.util.proxy.ProxyFactory();

        // The new instance will have the given clazzToInstantiate as super class
        factory.setSuperclass(clazzToInstantiate);
        
        MethodFilter methodFilter = new MethodFilter() {
            @Override
            public boolean isHandled(Method method) {
                return proxyMethodFilter.isHandled(method);
            }
        };

        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object o, Method method, Method method1, Object[] os) throws Throwable {
                return proxyMethodHandler.invoke(o, method, method1, os);
            }
        }; 
       
        // Now we need to define a method filter in order to determine which methods will be handle by the
        // clazzToInstantiate implementation or will be handled by the MethodHandler
        factory.setFilter(methodFilter);

        // The new instance will be of the type MODEL_CLASS
        MODEL_CLASS newInstance = null;
        try {
            // Now we try to create the instance by given the 'PisaModelMethodHandler' as the method handler
            newInstance = (MODEL_CLASS) factory.create(new Class<?>[0], new Object[0],  methodHandler);
        } catch (NoSuchMethodException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new PisaUtilsRuntimeException("Unable to create instance for '" + clazzToInstantiate.getName() + "'", ex);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new PisaUtilsRuntimeException("Unable to create instance for '" + clazzToInstantiate.getName() + "'", ex);
        } catch (InstantiationException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new PisaUtilsRuntimeException("Unable to create instance for '" + clazzToInstantiate.getName() + "'", ex);
        } catch (IllegalAccessException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new PisaUtilsRuntimeException("Unable to create instance for '" + clazzToInstantiate.getName() + "'", ex);
        } catch (InvocationTargetException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new PisaUtilsRuntimeException("Unable to create instance for '" + clazzToInstantiate.getName() + "'", ex);
        }

        // Returns the proxy instance just dynamically created 
        return newInstance;
    }

    public static boolean isProxyClass(Class clazz){
        return javassist.util.proxy.ProxyFactory.isProxyClass(clazz);
    }
}