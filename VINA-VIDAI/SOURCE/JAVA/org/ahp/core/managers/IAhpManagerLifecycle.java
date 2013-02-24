package org.ahp.core.managers;

import org.ahp.configuration.pojo.AhpConfiguration;

public interface IAhpManagerLifecycle {
	
	public void init( AhpConfiguration pAhpConfiguration );
	public void start();
	public void stop();
	public void destroy();

}
