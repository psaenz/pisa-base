/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pisa.core.base.model.test;

import com.pisa.core.base.model.PisaHistoricalModel;
import com.pisa.core.base.model.PisaI18nModel;
import com.pisa.core.base.model.PisaMixedModel;
import com.pisa.core.base.model.PisaNoDeletableModel;
import com.pisa.core.base.model.PisaSelfReferenceModel;
import com.pisa.core.base.model.PisaStatableModel;
import com.pisa.core.base.model.PisaTrackableModel;
import com.pisa.core.base.model.PisaWorkflowModel;
import com.pisa.core.base.model.business.PisaModelFactory;
import java.util.Calendar;
import junit.framework.TestCase;

/**
 *
 * @author PISA
 */
public class PisaModelTest extends TestCase {
    
    public PisaModelTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testModels() {
        // Make sure the set and get methods from the proxy works for several types (string, boolean, calendar)
        PisaHistoricalModel historicalModel = null;
        historicalModel = PisaModelFactory.createInstance(PisaHistoricalModel.class);
        assertNotNull(historicalModel);
        
        historicalModel.setId("The Id");
        assertEquals("The Id", historicalModel.getId());

        historicalModel.setIsInHistory(true);
        assertTrue(historicalModel.getIsInHistory());

        Calendar c = Calendar.getInstance();
        historicalModel.setOnHistorySince(c);
        assertEquals(c, historicalModel.getOnHistorySince());


        // Now make sure the rests of interfaces can be dynamically created by the Factory 
        PisaI18nModel i18nModel = PisaModelFactory.createInstance(PisaI18nModel.class);
        assertNotNull(i18nModel);
        
        PisaNoDeletableModel noDeletableModel = PisaModelFactory.createInstance(PisaNoDeletableModel.class);
        assertNotNull(noDeletableModel);
        
        PisaSelfReferenceModel selfReferenceModel = PisaModelFactory.createInstance(PisaSelfReferenceModel.class);
        assertNotNull(selfReferenceModel);
        
        PisaStatableModel statableModel = PisaModelFactory.createInstance(PisaStatableModel.class);
        assertNotNull(statableModel);
        
        PisaTrackableModel trackableModel = PisaModelFactory.createInstance(PisaTrackableModel.class);
        assertNotNull(trackableModel);
        
        PisaWorkflowModel workflowModel = PisaModelFactory.createInstance(PisaWorkflowModel.class);
        assertNotNull(workflowModel);

        PisaMixedModel mixedModel = PisaModelFactory.createInstance(PisaMixedModel.class);
        assertNotNull(mixedModel);

        // Now try a mixed class, which implementes some interfaces, define some local properties 
        // and override some default behaviour from the interfaces so the Proxy wont have to process the method.

        // Make sure local variables defined in the class are accessible
        mixedModel.setLocalVariable(123);
        assertEquals(123, mixedModel.getLocalVariable());
        
        // In this case, the SET is processed by the Proxy but the get was overrided by the class
        mixedModel.setStep("ABC"); 
        assertEquals("Step returned from overrided method", mixedModel.getStep());
    }
}
