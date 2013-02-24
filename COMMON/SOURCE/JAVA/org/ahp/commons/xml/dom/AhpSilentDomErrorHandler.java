package org.ahp.commons.xml.dom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public class AhpSilentDomErrorHandler implements DOMErrorHandler {

	final static Logger LOGGER = LoggerFactory.getLogger( AhpSilentDomErrorHandler.class );

	@Override
	public boolean handleError( DOMError pDOMError ) {
		if ( pDOMError.getSeverity() == DOMError.SEVERITY_WARNING )
			LOGGER.warn( formatMessage ( pDOMError ) );
		if ( pDOMError.getSeverity() == DOMError.SEVERITY_ERROR || pDOMError.getSeverity() == DOMError.SEVERITY_FATAL_ERROR )
			LOGGER.error( formatMessage ( pDOMError ) );
		return true;
	}
	
	/**
	 * 
	 * @param pDOMError
	 * @return
	 */
	private String formatMessage( DOMError pDOMError ){
		StringBuilder lStringBuilder = new StringBuilder();
		lStringBuilder.append( pDOMError.getMessage() );
		if ( pDOMError.getLocation() != null ) {
			DOMLocator lDOMLocator = pDOMError.getLocation();
			lStringBuilder.append( " at line# " + lDOMLocator.getLineNumber() );
			lStringBuilder.append( " at Column# "+ lDOMLocator.getColumnNumber() );
		    lStringBuilder.append( " , " + lDOMLocator.getByteOffset() );
	        Node lRelatedNode = lDOMLocator.getRelatedNode();
	        if ( lRelatedNode != null) {
	        	lStringBuilder.append( "[" );
	        	lStringBuilder.append( lRelatedNode.getNodeName() );
	        	lStringBuilder.append( "]" );
	        }
	        String lSystemId = lDOMLocator.getUri();
	        if ( lSystemId != null ) {
	            int lIndex = lSystemId.lastIndexOf( '/' );
	            if ( lIndex != -1 )
	            	lSystemId = lSystemId.substring( lIndex + 1 );
	            lStringBuilder.append( " : " );
	            lStringBuilder.append( lSystemId );
	        }
		}
		return lStringBuilder.toString();
	}
}
