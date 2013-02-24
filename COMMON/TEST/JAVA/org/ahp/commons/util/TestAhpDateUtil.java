package org.ahp.commons.util;

import java.util.Date;

import junit.framework.TestCase;

import org.ahp.test.AhpBastTest;
import org.junit.Test;

public class TestAhpDateUtil extends AhpBastTest {

    @Test
    public void testCheckForDateExpiry(){
    	AhpDateUtil ahpDateUtil = new AhpDateUtil();
    	Date lDate = new Date(System.currentTimeMillis());
    	
        TestCase.assertEquals( true, AhpDateUtil.checkForDateExpiry( ahpDateUtil.addDays( lDate, 10 ) ) );
        
    }
   
}
