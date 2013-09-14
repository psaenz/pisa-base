package com.pisa.core.dao.hibernate.tests;

import com.pisa.core.dao.hibernate.HibernatePisaModel;
import com.pisa.core.dao.hibernate.HibernateUtil;
import com.pisa.core.base.model.business.PisaModelFactory;
import java.util.GregorianCalendar;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;

/**
 * Unit test for simple App.
 */
public class HibernatePisaModelTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HibernatePisaModelTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HibernatePisaModelTest.class );
    }

    public void testSave()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Creates an object to save it
        HibernatePisaModel hmt = PisaModelFactory.createInstance(HibernatePisaModel.class);
        hmt.setCreatedBy("Created By Me");
        hmt.setModifiedBy("Modified By Me");
        hmt.setCreatedOn(GregorianCalendar.getInstance().getTime());
        Integer id = (Integer) session.save(hmt);
        session.getTransaction().commit();

        // Now loads the object to make sure properties are being read/load
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HibernatePisaModel hmt2 = (HibernatePisaModel) session.load(HibernatePisaModel.class, id);

        assertNotNull(hmt2);
        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getCreatedBy(), hmt2.getCreatedBy());
        assertEquals(hmt.getCreatedOn(), hmt2.getCreatedOn());
        assertEquals(hmt.getModifiedBy(), hmt2.getModifiedBy());
    }

    public void testUpdate()
    {
        // Loads an object from the DB
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        HibernatePisaModel hmt = (HibernatePisaModel) session.load(HibernatePisaModel.class, 1);
        assertNotNull(hmt);

        // Sets the ModifiedBy property
        hmt.setModifiedBy("Modified By Me Again");
        session.update(hmt);
        session.getTransaction().commit();

        // Loads the object again to check if value was updated
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HibernatePisaModel hmt2 = (HibernatePisaModel) session.load(HibernatePisaModel.class, 1);

        assertNotNull(hmt2);
        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getModifiedBy(), hmt2.getModifiedBy());
    }

    public void testFind()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        HibernatePisaModel hmt = (HibernatePisaModel) session.load(HibernatePisaModel.class, 1);
        hmt.setModifiedBy("Modified By");
        session.update(hmt);
        //session.getTransaction().commit();
        assertNotNull(hmt);

        String hql = "from " + HibernatePisaModel.class.getName() + " where id=1";
        HibernatePisaModel hmt2 = (HibernatePisaModel) session.createQuery(hql).list().get(0);

        assertNotNull(hmt2);

        hql = "from " + HibernatePisaModel.class.getName() + " t where t.modifiedBy='" + hmt.getModifiedBy() + "'";
        HibernatePisaModel hmt3 = (HibernatePisaModel) session.createQuery(hql).list().get(0);
        assertNotNull(hmt3);

        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getModifiedBy(), hmt2.getModifiedBy());
        assertEquals(hmt.getCreatedBy(), hmt2.getCreatedBy());
        assertEquals(hmt.getCreatedOn(), hmt2.getCreatedOn());
        assertEquals(hmt.getModifiedBy(), hmt2.getModifiedBy());
        assertEquals(hmt2.getId(), hmt3.getId());
        assertEquals(hmt2.getModifiedBy(), hmt3.getModifiedBy());
        assertEquals(hmt2.getCreatedBy(), hmt3.getCreatedBy());
        assertEquals(hmt2.getCreatedOn(), hmt3.getCreatedOn());
    }

    @Override
    protected void tearDown() throws Exception {
        HibernateUtil.getSessionFactory().getCurrentSession().close();
    }
}