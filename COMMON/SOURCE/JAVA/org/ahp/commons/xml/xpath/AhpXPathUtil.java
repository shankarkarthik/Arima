package org.ahp.commons.xml.xpath;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOCUMENT ME!
 */
public final class AhpXPathUtil {

	private XPathFactory mXPathFactory;
	private XPath mXPath;
	private NamespaceContext mNamespaceContext;
	private XPathVariableResolver mXPathVariableResolver;
	private XPathFunctionResolver mXPathFunctionResolver;
	
	/**
	 * DOCUMENT ME!
	 */
	public AhpXPathUtil(){
		mXPathFactory = XPathFactory.newInstance();
		this.mXPath = createXPath();
	}
	
	/**
     * DOCUMENT ME!
     */
	public XPath createXPath(){
		XPath lXPath = this.mXPathFactory.newXPath();
		if ( this.mNamespaceContext == null ){
			this.mNamespaceContext = new AhpNamespaceContext( null );
		}
		if ( this.mXPathVariableResolver != null ){
			lXPath.setXPathVariableResolver( this.mXPathVariableResolver );
		}
		if ( this.mXPathFunctionResolver != null ){
			lXPath.setXPathFunctionResolver( this.mXPathFunctionResolver );
		}
		lXPath.setNamespaceContext( this.mNamespaceContext );
		return lXPath;
	}

	public void setNamespaceContext( NamespaceContext pNamespaceContext ){
		this.mNamespaceContext = pNamespaceContext;
	}
	
	public void setXPathVariableResolver( XPathVariableResolver pXPathVariableResolver ){
		this.mXPathVariableResolver = pXPathVariableResolver;
	}
	
	public void setXPathFunctionResolver( XPathFunctionResolver pXPathFunctionResolver ){
		this.mXPathFunctionResolver = pXPathFunctionResolver;
	} 
	
    /**
     * DOCUMENT ME!
     *   
     */    
    public String getAsString( Node pDocument, String pExpression ) {
	   String lStringValue;
	   try {
		   lStringValue = ( String ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.STRING );
	   } catch ( XPathExpressionException exXPathExpression ) {
		   throw new AhpRuntimeException( "" );
	   }
       return lStringValue;
    }

    /**
     * DOCUMENT ME!
     */    
    public Boolean getAsBoolean( Node pDocument, String pExpression ) {
    	Boolean lBooleanValue;
    	try {
    		lBooleanValue = ( Boolean ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.BOOLEAN );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lBooleanValue; 
    }
   
    /**
     * DOCUMENT ME!
     */    
    public Node getAsNode( Node pDocument, String pExpression ) {
    	Node lEvaluatedNode;
    	try {
    		lEvaluatedNode = ( Node ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.NODE );
    	} catch ( XPathExpressionException exXPathExpression ) {
		   throw new AhpRuntimeException( "" );
	    }
    	return lEvaluatedNode;
    }

    /**
     * DOCUMENT ME!
     */
    public NodeList getAsNodeList( Node pDocument, String pExpression ) {
    	NodeList lEvaluatedNodeList;
    	try {
    		lEvaluatedNodeList = ( NodeList ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.NODESET );
    	} catch ( XPathExpressionException exXPathExpression ) {
		   throw new AhpRuntimeException( "" );
	    }
    	return lEvaluatedNodeList;
    }

    /**
     * DOCUMENT ME!
     */
    public Integer getAsInteger( Node pDocument, String pExpression ) {
    	Integer lIntegerValue;
    	try {
    		Double lDoubleValue = ( Double ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.NUMBER );
    		lIntegerValue = new Integer( lDoubleValue.intValue() );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lIntegerValue; 
    }

    /**
     * DOCUMENT ME!
     */    
    public Long getAsLong( Node pDocument, String pExpression ) {
    	Long lLongValue;
    	try {
    		Double lDoubleValue = ( Double ) this.mXPath.evaluate( pExpression, pDocument, XPathConstants.NUMBER );
    		lLongValue = new Long( lDoubleValue.longValue() );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lLongValue;
    }

    /**
     * DOCUMENT ME!
     */    
    public XPathExpression compileXPathExpression( String pExpression ) {
    	XPathExpression lXPathExpression;
    	try {
    		lXPathExpression = this.mXPath.compile( pExpression );
		} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
		return lXPathExpression;
    }
    
    /**
     * DOCUMENT ME!
     */    
    public String getAsString( Node pDocument, XPathExpression pXPathExpression ) {
 	   	String lStringValue;
 	   	try {
 	   		lStringValue = ( String ) pXPathExpression.evaluate( pDocument, XPathConstants.STRING );
 	   	} catch ( XPathExpressionException exXPathExpression ) {
 	   		throw new AhpRuntimeException( "" );
 	   	}
 	   	return lStringValue;

    }

    /**
     * DOCUMENT ME!
     */    
    public Boolean getAsBoolean( Node pDocument, XPathExpression pXPathExpression ) {
    	Boolean lBooleanValue;
    	try {
    		lBooleanValue = ( Boolean ) pXPathExpression.evaluate( pDocument, XPathConstants.BOOLEAN );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lBooleanValue; 

    }

    /**
     * DOCUMENT ME!
     */    
    public Node getAsNode( Node pDocument, XPathExpression pXPathExpression ) {
    	Node lEvaluatedNode;
    	try {
    		lEvaluatedNode = ( Node ) pXPathExpression.evaluate( pDocument, XPathConstants.NODE );
    	} catch ( XPathExpressionException exXPathExpression ) {
		   throw new AhpRuntimeException( "" );
	    }
    	return lEvaluatedNode;
    }

   	/**
   	 * DOCUMENT ME!
   	 */
   	public NodeList getAsNodeList( Node pDocument, XPathExpression pXPathExpression ) {
    	NodeList lEvaluatedNodeList;
    	try {
    		lEvaluatedNodeList = ( NodeList ) pXPathExpression.evaluate( pDocument, XPathConstants.NODESET );
    	} catch ( XPathExpressionException exXPathExpression ) {
		   throw new AhpRuntimeException( "" );
	    }
    	return lEvaluatedNodeList;
   	}

   	/**
   	 * DOCUMENT ME!
   	 */
   	public Integer getAsInteger( Node pDocument, XPathExpression pXPathExpression ) {
    	Integer lIntegerValue;
    	try {
    		Double lDoubleValue = ( Double ) pXPathExpression.evaluate( pDocument, XPathConstants.NUMBER );
    		lIntegerValue = new Integer( lDoubleValue.intValue() );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lIntegerValue; 
   	}

   	/**
   	 * DOCUMENT ME!
   	 */    
   	public Long getAsLong( Node pDocument, XPathExpression pXPathExpression ) {
    	Long lLongValue;
    	try {
    		Double lDoubleValue = ( Double ) pXPathExpression.evaluate( pDocument, XPathConstants.NUMBER );
    		lLongValue = new Long( lDoubleValue.longValue() );
    	} catch ( XPathExpressionException exXPathExpression ) {
 		   throw new AhpRuntimeException( "" );
 	    }
    	return lLongValue; 
   	}
  
}