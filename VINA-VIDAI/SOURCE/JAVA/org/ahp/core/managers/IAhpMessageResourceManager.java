package org.ahp.core.managers;

import org.ahp.core.exceptions.AhpExceptionCodes;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public interface IAhpMessageResourceManager extends IAhpManagerLifecycle {
	
	public String getMessage( AhpExceptionCodes pExceptionCode, Object[] pMessageArguments, String pResourceName );
	
	public String getMessage( AhpExceptionCodes pExceptionCode, Object[] pMessageArguments );
	
	public String getMessage( AhpExceptionCodes pExceptionCode );
	
	public String getMessage( AhpExceptionCodes pExceptionCode, String pResourceName );
	
}
