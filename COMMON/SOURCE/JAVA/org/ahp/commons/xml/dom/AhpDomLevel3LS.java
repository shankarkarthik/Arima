package org.ahp.commons.xml.dom;

import java.io.InputStream;
import java.io.StringWriter;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.commons.util.AhpResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;

public final class AhpDomLevel3LS {

	static final Logger LOGGER = LoggerFactory.getLogger( AhpDomLevel3LS.class );
	
	static final String ERROR_HANDLER = "error-handler";
	static final String FORMAT_PRETTY_PRINT = "format-pretty-print";
	static final String LS_IMPLEMENTATION = "LS";
	static final String LS_OUTPUT_ENCODING = "UTF-8";
	
	static {
		//System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMXSImplementationSourceImpl");
	}
	
	/**
	 * 
	 * @param pXmlPath
	 * @return
	 */
	public static Node loadNodeFromUri( String pXmlResourceUri ){
		try {
			if ( AhpResourceUtil.isClassPathResource( pXmlResourceUri ) ){
				pXmlResourceUri = AhpResourceUtil.getClassPathResourceAsFileResource( pXmlResourceUri );
			}
			DOMImplementationRegistry lDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS lDOMImplementationLS = ( DOMImplementationLS ) lDOMImplementationRegistry.getDOMImplementation( LS_IMPLEMENTATION );
			LSParser lLSParser = lDOMImplementationLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null );
			lLSParser.getDomConfig().setParameter( ERROR_HANDLER, new AhpSilentDomErrorHandler() );
			Document lDocument = lLSParser.parseURI( pXmlResourceUri );
			return ( Node ) lDocument;
		} catch ( ClassCastException exClassCast ) {
			throw new AhpRuntimeException( "", exClassCast );
		} catch ( ClassNotFoundException exClassNotFound ) {
			throw new AhpRuntimeException( "", exClassNotFound );
		} catch ( InstantiationException exInstantiation ) {
			throw new AhpRuntimeException( "", exInstantiation );
		} catch ( IllegalAccessException exIllegalAccess ) {
			throw new AhpRuntimeException( "", exIllegalAccess );
		} 
	}

	/**
	 * 
	 * @param pXmlPath
	 * @return
	 */
	public static Node loadNodeFromStream( InputStream pXmlInputStream ){
		try {
			DOMImplementationRegistry lDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS lDOMImplementationLS = ( DOMImplementationLS ) lDOMImplementationRegistry.getDOMImplementation( LS_IMPLEMENTATION );
			LSParser lLSParser = lDOMImplementationLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null );
			lLSParser.getDomConfig().setParameter( ERROR_HANDLER, new AhpSilentDomErrorHandler() );
			LSInput lLSInput = lDOMImplementationLS.createLSInput();
			lLSInput.setByteStream( pXmlInputStream );
			Document lDocument = lLSParser.parse( lLSInput );
			return ( Node ) lDocument;
		} catch ( ClassCastException exClassCast ) {
			throw new AhpRuntimeException( "", exClassCast );
		} catch ( ClassNotFoundException exClassNotFound ) {
			throw new AhpRuntimeException( "", exClassNotFound );
		} catch ( InstantiationException exInstantiation ) {
			throw new AhpRuntimeException( "", exInstantiation );
		} catch ( IllegalAccessException exIllegalAccess ) {
			throw new AhpRuntimeException( "", exIllegalAccess );
		} 
	}

	/**
	 * 
	 * @param pXmlPath
	 * @return
	 */
	public static Node loadNodeFromString( String pXmlString ){
		try {
			DOMImplementationRegistry lDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS lDOMImplementationLS = ( DOMImplementationLS ) lDOMImplementationRegistry.getDOMImplementation( LS_IMPLEMENTATION );
			LSParser lLSParser = lDOMImplementationLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null );
			lLSParser.getDomConfig().setParameter( ERROR_HANDLER, new AhpSilentDomErrorHandler() );
			LSInput lLSInput = lDOMImplementationLS.createLSInput();
			lLSInput.setStringData( pXmlString );
			Document lDocument = lLSParser.parse( lLSInput );
			return ( Node ) lDocument;
		} catch ( ClassCastException exClassCast ) {
			throw new AhpRuntimeException( "", exClassCast );
		} catch ( ClassNotFoundException exClassNotFound ) {
			throw new AhpRuntimeException( "", exClassNotFound );
		} catch ( InstantiationException exInstantiation ) {
			throw new AhpRuntimeException( "", exInstantiation );
		} catch ( IllegalAccessException exIllegalAccess ) {
			throw new AhpRuntimeException( "", exIllegalAccess );
		} 
	}

	
	/**
	 * 
	 * @param pNode
	 * @return
	 */
	public static String saveNodeToString( Node pNode ) {
		try {
			DOMImplementationRegistry lDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS lDOMImplementationLS = ( DOMImplementationLS ) lDOMImplementationRegistry.getDOMImplementation( LS_IMPLEMENTATION );
			LSSerializer lLSSerializer = lDOMImplementationLS.createLSSerializer();
			if ( lLSSerializer.getDomConfig().canSetParameter( FORMAT_PRETTY_PRINT, Boolean.TRUE ) ) {
				lLSSerializer.getDomConfig().setParameter( FORMAT_PRETTY_PRINT, Boolean.TRUE );
			}        
			LSOutput lLSOutput = lDOMImplementationLS.createLSOutput();
			lLSOutput.setEncoding( LS_OUTPUT_ENCODING );
			StringWriter lStringWriter = new StringWriter();
			lLSOutput.setCharacterStream(lStringWriter);
			lLSSerializer.write( pNode, lLSOutput );
			return lStringWriter.toString();
		} catch ( ClassCastException exClassCast ) {
			throw new AhpRuntimeException( "", exClassCast );
		} catch ( ClassNotFoundException exClassNotFound ) {
			throw new AhpRuntimeException( "", exClassNotFound );
		} catch ( InstantiationException exInstantiation ) {
			throw new AhpRuntimeException( "", exInstantiation );
		} catch ( IllegalAccessException exIllegalAccess ) {
			throw new AhpRuntimeException( "", exIllegalAccess );
		} 
	}
    
	/**
	 * 
	 * @param pNode
	 * @param pSystemId
	 */
	public static void saveNodeToFile( Node pNode, String pSystemId ) {
		try {
		   DOMImplementationRegistry lDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
           DOMImplementationLS lDOMImplementationLS = ( DOMImplementationLS ) lDOMImplementationRegistry.getDOMImplementation( LS_IMPLEMENTATION );
           LSSerializer lLSSerializer = lDOMImplementationLS.createLSSerializer();
           if ( lLSSerializer.getDomConfig().canSetParameter( FORMAT_PRETTY_PRINT, Boolean.TRUE ) ) {
        	   lLSSerializer.getDomConfig().setParameter( FORMAT_PRETTY_PRINT, Boolean.TRUE );
		   }
           LSOutput lLSOutput = lDOMImplementationLS.createLSOutput();
           lLSOutput.setSystemId( pSystemId );
           lLSSerializer.write( pNode, lLSOutput );           
        } catch ( ClassCastException exClassCast ) {
			throw new AhpRuntimeException( "", exClassCast );
		} catch ( ClassNotFoundException exClassNotFound ) {
			throw new AhpRuntimeException( "", exClassNotFound );
		} catch ( InstantiationException exInstantiation ) {
			throw new AhpRuntimeException( "", exInstantiation );
		} catch ( IllegalAccessException exIllegalAccess ) {
			throw new AhpRuntimeException( "", exIllegalAccess );
		}   
   }
}