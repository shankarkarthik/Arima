package org.ahp.core.managers;

import org.ahp.configuration.pojo.AhpDeployment;
import org.junit.Test;

public class TestAhpLoggerManager {
	
	@Test
	public void testClasspathLoggerManager(){
	    AhpDeployment lAhpClasspathDeployment = new AhpDeployment();
	    lAhpClasspathDeployment.setLogFileLocation( "classpath:/logback/logback.xml" );
	    new AhpLogBackLoggerManager().configure( lAhpClasspathDeployment );
	}
	
	@Test
    public void testFileLoggerManager(){
        AhpDeployment lAhpFileDeployment = new AhpDeployment();
        lAhpFileDeployment.setLogFileLocation( "file:///C:/WORK/vv-workspace/VINA-VIDAI/bin/LOGBACK/logback.xml" );
	    new AhpLogBackLoggerManager().configure( lAhpFileDeployment );
    }
}
