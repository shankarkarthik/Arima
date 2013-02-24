package org.ahp.test;

import org.junit.Before;
import org.junit.Ignore;

import ch.qos.logback.classic.BasicConfigurator;

@Ignore
public class AhpBastTest {

	@Before
	public void bootLogget(){
		BasicConfigurator.configureDefaultContext();
	}
}
