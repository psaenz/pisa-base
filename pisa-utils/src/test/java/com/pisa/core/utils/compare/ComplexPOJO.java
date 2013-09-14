package com.pisa.core.utils.compare;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author PISA
 */
public class ComplexPOJO {

    private int intValue;
    private float floatValue;
    private double doubleValue;
    private String stringValue;
    private boolean booleanValue;

    private Integer intWrapperValue;
    private Float floaWrappertValue;
    private Double doubleWrapperValue;
    private Boolean booleanWrapprValue;
    
    private Date dateValue;
    private Calendar calendarValue;

    private List<String> listValues;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Integer getIntWrapperValue() {
        return intWrapperValue;
    }

    public void setIntWrapperValue(Integer intWrapperValue) {
        this.intWrapperValue = intWrapperValue;
    }

    public Float getFloaWrappertValue() {
        return floaWrappertValue;
    }

    public void setFloaWrappertValue(Float floaWrappertValue) {
        this.floaWrappertValue = floaWrappertValue;
    }

    public Double getDoubleWrapperValue() {
        return doubleWrapperValue;
    }

    public void setDoubleWrapperValue(Double doubleWrapperValue) {
        this.doubleWrapperValue = doubleWrapperValue;
    }

    public Boolean getBooleanWrapprValue() {
        return booleanWrapprValue;
    }

    public void setBooleanWrapprValue(Boolean booleanWrapprValue) {
        this.booleanWrapprValue = booleanWrapprValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Calendar getCalendarValue() {
        return calendarValue;
    }

    public void setCalendarValue(Calendar calendarValue) {
        this.calendarValue = calendarValue;
    }

    public List<String> getListValues() {
        return listValues;
    }

    public void setListValues(List<String> listValues) {
        this.listValues = listValues;
    }
}