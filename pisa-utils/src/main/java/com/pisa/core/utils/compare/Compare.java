/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.utils.compare;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.beanutils.PropertyUtils;
import com.pisa.core.utils.compare.CompareResult.CompareResultDetail;
        
/**
 *
 * @author psaenz
 */
public class Compare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CompareResult result = Compare.Compare("", 1);
        System.out.println("Done: " + result.getReason());
    }

    static Class stringClass = String.class;
    static Class dateClass = Date.class;
    static Class calendarClass = Calendar.class;
    public static CompareResult Compare(Object obj1, Object obj2){
        if (obj1 == null && obj2 == null)
            return new CompareResult(); // both are null, so they are equal

        if (obj1 == null || obj2 == null) // one of the objs is null
            return new CompareResult(obj1 == null ? "Object 1 is null" : "Object 2 is null");

        if (!obj1.getClass().equals(obj2.getClass())) // the class of each objs is different
            return new CompareResult("Class types are different. Obj1 class is: '" + obj1.getClass() + "' and Obj2 class is: '" + obj2.getClass() + "'");

        if (ClassUtils.isPrimitiveOrWrapper(obj1.getClass()) || stringClass.isAssignableFrom(obj1.getClass())){
            if (!obj1.equals(obj2))
                return new CompareResult("Values are not equal. '" + obj1 + "' <> '" + obj2 + "'");
            return new CompareResult(); // they are equal
        }

        if (dateClass.isAssignableFrom(obj1.getClass())){
            if (DateUtils.isSameInstant((Date)obj1, (Date)obj2)){
                return new CompareResult(); // they are equal
            }else{
                return new CompareResult("Dates are not equal.");
            }
        }

        if (calendarClass.isAssignableFrom(obj1.getClass())){
            if(DateUtils.isSameInstant((Calendar)obj1, (Calendar)obj2)){
                return new CompareResult(); // they are equal
            }else{
                return new CompareResult("Calendars are not equal.");
            }
        }

        Object value1 = null;
        Object value2 = null;
        CompareResult result = new CompareResult();
        
        // Compare the fields
        {
            Field fields[] = obj1.getClass().getFields();
            int lastFieldChecked = -1;
            try {
                CompareResult fieldResult = new CompareResult();
                for(Field field : fields){
                    lastFieldChecked ++;
                    value1 = field.get(obj1);
                    value2 = field.get(obj2);
                    fieldResult = Compare(value1, value2);
                    if (fieldResult.getDifferencesFound()){
                        if (fieldResult.getReason() != null && result.getReason() == null)
                            result.setReason("Difference found on '" + field.getName() + "' of class '" + obj1.getClass().getName() + "'. " + fieldResult.getReason());
                        result.setDifferencesFound(true);
                        result.getDetails().addAll(fieldResult.getDetails());
                        result.addDetail(obj1.getClass().getName(), field.getName(), value1, value2);
                    }
                }
            } catch (IllegalArgumentException ex) {
                if (lastFieldChecked > -1)
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, "Error found while comparing field '" + fields[lastFieldChecked].getName() + "'", ex);
                else
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                if (lastFieldChecked > -1)
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, "Error found while comparing field '" + fields[lastFieldChecked].getName() + "'", ex);
                else
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Compare the properties
        {
            PropertyDescriptor[] propertyDescriptor = PropertyUtils.getPropertyDescriptors(obj1.getClass());
            int lastPropertyChecked = -1;
            try {
                CompareResult fieldResult = new CompareResult();
                for(PropertyDescriptor property : propertyDescriptor){
                    lastPropertyChecked ++;
                    if (property.getName().equalsIgnoreCase("class"))
                        continue; // the GetClass property is skipt
                    value1 = property.getReadMethod().invoke(obj1, null);
                    value2 = property.getReadMethod().invoke(obj2, null);
                    fieldResult = Compare(value1, value2);
                    if (fieldResult.getDifferencesFound()){
                        if (fieldResult.getReason() != null && result.getReason() == null)
                            result.setReason("Difference found on '" + property.getName() + "' of class '" + obj1.getClass().getName() + "'. " + fieldResult.getReason());
                        result.setDifferencesFound(true);
                        result.getDetails().addAll(fieldResult.getDetails());
                        result.addDetail(obj1.getClass().getName(), property.getName(), value1, value2);
                    }
                }
            } catch (IllegalArgumentException ex) {
                if (lastPropertyChecked > -1)
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, "Error found while comparing property '" + propertyDescriptor[lastPropertyChecked].getName() + "'", ex);
                else
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                if (lastPropertyChecked > -1)
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, "Error found while comparing property '" + propertyDescriptor[lastPropertyChecked].getName() + "'", ex);
                else
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                if (lastPropertyChecked > -1)
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, "Error found while comparing property '" + propertyDescriptor[lastPropertyChecked].getName() + "'", ex);
                else
                    Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }

        return result;
    }
}