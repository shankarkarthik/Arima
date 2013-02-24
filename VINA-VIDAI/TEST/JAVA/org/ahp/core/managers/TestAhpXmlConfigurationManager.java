package org.ahp.core.managers;

import org.ahp.test.AhpBastTest;
import org.junit.Test;

public class TestAhpXmlConfigurationManager extends AhpBastTest {
    
    @Test
    public void testConfiguration(){
        IAhpConfigurationManager lAhpXmlConfigurationManager = new AhpXmlConfigurationManager();
        lAhpXmlConfigurationManager.configure( new String[]{ "classpath:AhpConfiguration.xml", "classpath:AhpConfiguration-DB.xml" }, null );
    }

}
