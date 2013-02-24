package org.ahp.core.managers;

import org.ahp.core.bootstrap.AhpBootstrapManager;
import org.ahp.test.AhpBastTest;
import org.junit.Test;

public class TestAhpBootstrap extends AhpBastTest {
    
    
    @Test
    public void testBootstrap(){
        AhpBootstrapManager lAhpBootstrap = new AhpBootstrapManager();
        lAhpBootstrap.setAhpConfigurationManager( new AhpXmlConfigurationManager() );
        lAhpBootstrap.setAhpLoggerManager( new AhpLogBackLoggerManager() );
        lAhpBootstrap.setAhpMessageResourceManager( new AhpMessageResourceManager() );
        lAhpBootstrap.bootstrap( new String[]{ "classpath:/AhpConfiguration.xml", 
                                               "classpath:/AhpConfiguration-DB.xml" 
                                             },
                                 null );
    }

}
