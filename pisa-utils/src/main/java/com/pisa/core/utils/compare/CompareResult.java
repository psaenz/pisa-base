package com.pisa.core.utils.compare;

import java.util.ArrayList;
import java.util.List;

/**
 * This object is used to report a difference when 2 objects are compared
 * @author PISA
 */
public class CompareResult {

    private boolean differencesFound = false;
    private String reason;
    private List<CompareResultDetail> details = new ArrayList<CompareResultDetail>();

    public CompareResult(){}
    public CompareResult(String reason){
        this.reason = reason;
        this.differencesFound = true;
        //CompareResultDetail detail = new CompareResultDetail();
    }
    
    public boolean getDifferencesFound() {
        return differencesFound;
    }

    public void setDifferencesFound(boolean differencesFound) {
        this.differencesFound = differencesFound;
    }

    public void addDetail(String objectComparing, String propertyComparing, Object obj1Value, Object obj2Value){
        CompareResultDetail detail = new CompareResultDetail(objectComparing, propertyComparing, obj1Value, obj2Value);
        getDetails().add(detail);
    }
    
    public List<CompareResultDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CompareResultDetail> details) {
        this.details = details;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public class CompareResultDetail{
        private String objectComparing;
        private String propertyComparing;

        private Object obj1Value;
        private Object obj2Value;

        public CompareResultDetail(){}
        public CompareResultDetail(String objectComparing, String propertyComparing, Object obj1Value, Object obj2Value){
            this.objectComparing = objectComparing;
            this.propertyComparing = propertyComparing;
            this.obj1Value = obj1Value;
            this.obj2Value = obj2Value;
        }

        public String getObjectComparing() {
            return objectComparing;
        }

        public void setObjectComparing(String objectComparing) {
            this.objectComparing = objectComparing;
        }

        public String getPropertyComparing() {
            return propertyComparing;
        }

        public void setPropertyComparing(String propertyComparing) {
            this.propertyComparing = propertyComparing;
        }

        public Object getObj1Value() {
            return obj1Value;
        }

        public void setObj1Value(Object obj1Value) {
            this.obj1Value = obj1Value;
        }

        public Object getObj2Value() {
            return obj2Value;
        }

        public void setObj2Value(Object obj2Value) {
            this.obj2Value = obj2Value;
        }
    }
}