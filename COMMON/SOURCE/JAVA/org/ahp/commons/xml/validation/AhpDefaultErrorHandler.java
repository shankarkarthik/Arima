package org.ahp.commons.xml.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class AhpDefaultErrorHandler implements ErrorHandler {

	final static Logger LOGGER = LoggerFactory.getLogger( AhpDefaultErrorHandler.class );
	
    public void warning( SAXParseException pSAXParseException ) {
        LOGGER.error( "", pSAXParseException );
    }

    public void error( SAXParseException pSAXParseException) {
        LOGGER.error( "", pSAXParseException );
    }

    public void fatalError( SAXParseException pSAXParseException ) 
        throws SAXException {
        throw pSAXParseException;
    }

}