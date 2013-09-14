package com.pisa.core.dao.hibernate.tests;

import com.pisa.core.dao.hibernate.HibernateSimpleModel;
import com.pisa.core.dao.hibernate.HibernateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;

/**
 * Unit test for simple App.
 */
public class HibernateSimpleModelTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HibernateSimpleModelTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HibernateSimpleModelTest.class );
    }

    public void testSave()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Saves the obj
        HibernateSimpleModel hmt = new HibernateSimpleModel();
        hmt.setTitle("The Title");
        Integer id = (Integer) session.save(hmt);
        session.getTransaction().commit();

        // Loads the same obj and check the values
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HibernateSimpleModel hmt2 = (HibernateSimpleModel) session.load(HibernateSimpleModel.class, id);

        assertNotNull(hmt2);
        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getTitle(), hmt2.getTitle());
    }

    public void testUpdate()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Loads and obj, changes and updates its values
        HibernateSimpleModel hmt = (HibernateSimpleModel) session.load(HibernateSimpleModel.class, 1);
        assertNotNull(hmt);
        hmt.setTitle("The Title Changed");
        session.update(hmt);
        session.getTransaction().commit();

        // Loads the obj and checks for the values
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HibernateSimpleModel hmt2 = (HibernateSimpleModel) session.load(HibernateSimpleModel.class, 1);

        assertNotNull(hmt2);
        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getTitle(), hmt2.getTitle());
    }

    public void testFind()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Loads the object with id 18 with different methods
        HibernateSimpleModel hmt = (HibernateSimpleModel) session.load(HibernateSimpleModel.class, 1);
        assertNotNull(hmt);

        String hql = "from " + HibernateSimpleModel.class.getName() + " where id=1";
        HibernateSimpleModel hmt2 = (HibernateSimpleModel) session.createQuery(hql).list().get(0);
        assertNotNull(hmt2);

        hql = "from " + HibernateSimpleModel.class.getName() + " t where t.title='" + hmt.getTitle() + "'";
        HibernateSimpleModel hmt3 = (HibernateSimpleModel) session.createQuery(hql).list().get(0);
        assertNotNull(hmt3);

        // Compares the value of the 3 objects
        assertEquals(hmt.getId(), hmt2.getId());
        assertEquals(hmt.getTitle(), hmt2.getTitle());
        assertEquals(hmt2.getId(), hmt3.getId());
        assertEquals(hmt2.getTitle(), hmt3.getTitle());
    }

    @Override
    protected void tearDown() throws Exception {
        HibernateUtil.getSessionFactory().getCurrentSession().close();
    }
}