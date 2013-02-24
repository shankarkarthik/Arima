package org.ahp.commons.exceptions;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public class AhpRuntimeException extends RuntimeException {
	
	public AhpRuntimeException( String pMessage ){
		super( pMessage );
	}

	public AhpRuntimeException( String pMessage, Throwable pThrowable ) {
		super( pMessage, pThrowable );
	}
	
}
