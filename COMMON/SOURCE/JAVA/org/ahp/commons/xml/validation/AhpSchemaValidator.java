package org.ahp.commons.xml.validation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class AhpSchemaValidator {
	
	final static Logger LOGGER = LoggerFactory.getLogger( AhpSchemaValidator.class );
	
    public static final String W3C_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private String mSchemaLocation;
    private String mXmlFile;
    private Node mXmlDocument;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private ErrorHandler mErrorHandler;
    
    public final void setSchemaLocation( String pSchemaLocation ){
        this.mSchemaLocation = pSchemaLocation;
    }

    public final void setXmlFileLocation( String pXmlFileLocation ){
        this.mXmlFile = pXmlFileLocation;
    }

    public final void setXmlFileInputStream( InputStream pInputStream ){
        this.mInputStream = pInputStream;
    }

    public final void setXmlFileOutputStream( OutputStream pOutputStream ){
        this.mOutputStream = pOutputStream;
    }

    public final void setXmlDocument( Node pXmlDocument ){
        this.mXmlDocument = pXmlDocument;
    }

    public final void setErrorHandler( ErrorHandler pErrorHandler ){
        this.mErrorHandler = pErrorHandler;
    }
    
    public boolean validateWithW3CSchema(){
        try { 
            SchemaFactory lSchemaFactory = SchemaFactory.newInstance( W3C_SCHEMA );
            Schema lSchema = lSchemaFactory.newSchema( new File( this.mSchemaLocation ) );
            Validator lValidator = lSchema.newValidator();
            Source lSource = null;
            if ( this.mXmlFile != null ) {
                lSource = new StreamSource( new File( this.mXmlFile ) );
                LOGGER.debug( "Using XmlFile Source" );
            }
            if ( this.mInputStream != null ) {
                lSource = new StreamSource( mInputStream );
                LOGGER.debug( "Using InputStream Source" );
            }
            if ( this.mXmlDocument != null ) {
                lSource = new StreamSource( new File( this.mXmlFile ) );
                LOGGER.debug( "Using DOM Source" );
            }
            if ( this.mOutputStream != null ) {
                lSource = new StreamSource( new File( this.mXmlFile ) );
            }
            ErrorHandler lErrorHandler = new AhpDefaultErrorHandler();
            if ( this.mErrorHandler != null ) {
                lErrorHandler = this.mErrorHandler;
            }                
            lValidator.setErrorHandler( lErrorHandler );
            lValidator.validate( lSource );
            return true;
        } catch ( SAXException exSAX ) {
            LOGGER.error( "ValidationFailed", exSAX );
        } catch ( IOException exIO ) {
        	LOGGER.error( "ValidationFailed", exIO );
		}  
        return false;
    }
}
