package com.pisa.core.utils.compare.tests;

import com.pisa.core.utils.compare.ComplexPOJO;
import com.pisa.core.utils.compare.Compare;
import com.pisa.core.utils.compare.CompareResult;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CompareTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CompareTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CompareTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPositeComparison()
    {
        // null values
        CompareResult result = Compare.Compare(null, null);
        assertFalse(result.getDifferencesFound());

        // ints
        result = Compare.Compare(1, 1);
        assertFalse(result.getDifferencesFound());

        // float
        result = Compare.Compare(1.2, 1.2);
        assertFalse(result.getDifferencesFound());

        // double
        result = Compare.Compare(123.456789, 123.456789);
        assertFalse(result.getDifferencesFound());

        // strings
        result = Compare.Compare("abc", "abc");
        assertFalse(result.getDifferencesFound());

        // boolean
        result = Compare.Compare(false, false);
        assertFalse(result.getDifferencesFound());

        // test with primitive wrappers
        result = Compare.Compare(new Integer(123), new Integer(123));
        assertFalse(result.getDifferencesFound());

        result = Compare.Compare(new Long(987654l), new Long(987654l));
        assertFalse(result.getDifferencesFound());

        result = Compare.Compare(new Double(123.456789), new Double(123.456789));
        assertFalse(result.getDifferencesFound());

        result = Compare.Compare(new String("abc"), new String("abc"));
        assertFalse(result.getDifferencesFound());

        result = Compare.Compare(new Boolean(true), new Boolean(true));
        assertFalse(result.getDifferencesFound());

        // Date
        result = Compare.Compare(new Date(2012, 10, 20, 14, 43, 20), new Date(2012, 10, 20, 14, 43, 20));
        assertFalse(result.getDifferencesFound());

        // Calendar
        result = Compare.Compare(new GregorianCalendar(2012, 10, 20, 14, 43, 20), new GregorianCalendar(2012, 10, 20, 14, 43, 20));
        assertFalse(result.getDifferencesFound());
    }
    
    public void testFalseComparison(){
        // null values
        CompareResult result = Compare.Compare(null, "A");
        assertTrue(result.getDifferencesFound());
        assertEquals("Object 1 is null", result.getReason());

        // ints
        result = Compare.Compare(1, 2);
        assertTrue(result.getDifferencesFound());

        // float
        result = Compare.Compare(1.2, 1.3);
        assertTrue(result.getDifferencesFound());

        // double
        result = Compare.Compare(123.456789, 123.456780);
        assertTrue(result.getDifferencesFound());

        // strings
        result = Compare.Compare("abc", "abcd");
        assertTrue(result.getDifferencesFound());

        // boolean
        result = Compare.Compare(false, true);
        assertTrue(result.getDifferencesFound());

        // test with primitive wrappers
        result = Compare.Compare(new Integer(123), new Integer(124));
        assertTrue(result.getDifferencesFound());

        result = Compare.Compare(new Long(987654l), new Long(9876542));
        assertTrue(result.getDifferencesFound());

        result = Compare.Compare(new Double(123.456789), new Double(123.456780));
        assertTrue(result.getDifferencesFound());

        result = Compare.Compare(new String("abc"), new String("abd"));
        assertTrue(result.getDifferencesFound());

        result = Compare.Compare(new Boolean(true), new Boolean(false));
        assertTrue(result.getDifferencesFound());

        // Date
        result = Compare.Compare(new Date(2012, 10, 20, 14, 43, 20), new Date(2012, 10, 20, 14, 43, 21));
        assertTrue(result.getDifferencesFound());

        // Calendar
        result = Compare.Compare(new GregorianCalendar(2012, 10, 20, 14, 43, 20), new GregorianCalendar(2012, 10, 20, 14, 43, 21));
        assertTrue(result.getDifferencesFound());
    }

    
    public void testPositeComparisonWithComplexObject(){
        ComplexPOJO pojo = new ComplexPOJO();
        pojo.setBooleanValue(true);
        pojo.setBooleanWrapprValue(Boolean.TRUE);
        pojo.setCalendarValue(new GregorianCalendar(2012, 10, 30, 18, 45, 20));
        pojo.setDateValue(new Date(2012, 10, 30, 14, 45, 20));
        pojo.setDoubleValue(987.654321);
        pojo.setDoubleWrapperValue(new Double(987.654321));
        pojo.setFloatValue(1.4f);
        pojo.setFloaWrappertValue(new Float((1.4)));
        pojo.setIntValue(987);
        pojo.setIntWrapperValue(new Integer(987));
        //pojo.setListValues(null);
        pojo.setStringValue("XYZ");

        ComplexPOJO pojo2 = new ComplexPOJO();
        pojo2.setBooleanValue(true);
        pojo2.setBooleanWrapprValue(Boolean.TRUE);
        pojo2.setCalendarValue(new GregorianCalendar(2012, 10, 30, 18, 45, 20));
        pojo2.setDateValue(new Date(2012, 10, 30, 14, 45, 20));
        pojo2.setDoubleValue(987.654321);
        pojo2.setDoubleWrapperValue(new Double(987.654321));
        pojo2.setFloatValue(1.4f);
        pojo2.setFloaWrappertValue(new Float((1.2)));
        pojo2.setIntValue(987);
        pojo2.setIntWrapperValue(new Integer(987));
        //pojo.setListValues(null);
        pojo2.setStringValue("XYZ");

        CompareResult result = Compare.Compare(pojo, pojo2);
        assertTrue(result.getDifferencesFound());
        assertEquals("Difference found on 'floaWrappertValue' of class 'com.pisa.core.utils.compare.ComplexPOJO'. Values are not equal. '1.4' <> '1.2'", result.getReason());
        assertNotNull(result.getDetails());
        assertEquals(1, result.getDetails().size());
        assertEquals(new Float(1.4), result.getDetails().get(0).getObj1Value());
        assertEquals(new Float(1.2), result.getDetails().get(0).getObj2Value());
        assertEquals("com.pisa.core.utils.compare.ComplexPOJO", result.getDetails().get(0).getObjectComparing());
        assertEquals("floaWrappertValue", result.getDetails().get(0).getPropertyComparing());
    }
}