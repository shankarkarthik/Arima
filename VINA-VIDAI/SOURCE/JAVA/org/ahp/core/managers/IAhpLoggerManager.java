package org.ahp.core.managers;

import org.ahp.configuration.pojo.AhpDeployment;


/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public interface IAhpLoggerManager extends IAhpManagerLifecycle {
	
	/**
	 * 
	 * @param pResourceUri
	 */
	public void configure( AhpDeployment pAhpDeployment );
}
