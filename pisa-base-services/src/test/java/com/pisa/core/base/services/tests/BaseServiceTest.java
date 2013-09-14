package com.pisa.core.base.services.tests;

import com.pisa.core.base.model.business.PisaModelFactory;
import com.pisa.core.base.services.BasicModel;
import com.pisa.core.base.services.BasicService;
import com.pisa.core.base.services.business.PisaServiceFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 * 
 * @author PISA
 */
public class BaseServiceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BaseServiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BaseServiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        //TO READ
        //EmptyInterceptor 
        //http://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/EmptyInterceptor.html
        //http://docs.jboss.org/hibernate/orm/3.3/reference/en/html/events.html
        //https://forum.hibernate.org/viewtopic.php?t=940809
        //http://www.mkyong.com/hibernate/hibernate-interceptor-example-audit-log/
        BasicService basicService = PisaServiceFactory.createInstance(BasicService.class);
        //BasicModel basicModel = PisaModelFactory.createInstance(BasicModel.class);
        //PisaModelFactory.createInstance(null);
        
        //basicModel.setId("Basic Model Id");
        
                
        basicService.sendToHistory(null);
        
        /**
         * - The interfaces define the functions for each type of service.
         * - The implementation implements each method defined on the interfaces per each service.
         * - The service registry maps which class implements which interface, so as the IHistoricalModelService
         * interface is implemented by the HistoricalModelService class
         * - The MethodHandler takes the method and determine which service implementation to call according to the registry
         * - Any user service must be abstract and will have the interfaces to implement
         * - Since the user services are abstract, we need to use the Service Factory to create instances of each service
         * - The factory will return a proxy of the service, so the methods defined in the interfaces will be handled by the methodHandle
         */
        
        
    }
}
