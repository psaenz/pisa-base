package com.pisa.core.base.dao.tests;

import com.pisa.core.base.dao.DaoTest;
import com.pisa.core.base.dao.Model4Tests;
import com.pisa.core.base.dao.business.PisaDaoFactory;
import com.pisa.core.base.dao.impl.PisaDaoAction;
import com.pisa.core.base.model.business.PisaModelFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 * 
 * @author PISA
 */
public class BaseDaoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BaseDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BaseDaoTest.class );
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
        DaoTest daoObj = PisaDaoFactory.createInstance(DaoTest.class);
        Model4Tests model = daoObj.findById(123);
        assertNull(model);
        
        model = PisaModelFactory.createInstance(Model4Tests.class);
        model.setId(1);
        daoObj.auditAction(null, model, PisaDaoAction.CREATE);
        daoObj.sendToHistory(null);
        // TODO: the save and the update are not implemented, instead it throws an expcetion
        //daoObj.save(model);
        //daoObj.update(model);
    }
}
