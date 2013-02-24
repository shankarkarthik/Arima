package org.ahp.commons.xml.xpath;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathVariableResolver;

/**
 * DOCUMENT ME!
 */  
public class AhpXPathVariableResolver implements XPathVariableResolver {

    /** DOCUMENT ME! */     
    private Map<QName,Object> mVariables = new HashMap<QName,Object>();

    /**
     * DOCUMENT ME!
     */  
    public void addVariable( String pNamespaceURI, String pLocalName, Object pValue) {
        addVariable( new QName( pNamespaceURI, pLocalName ), pValue );
    }

    /**
     * DOCUMENT ME!
     */  
    public void addVariable( QName pQName, Object pValue ) {
        this.mVariables.put( pQName, pValue);
    }

    /**
     * DOCUMENT ME!
     */  
    public Object resolveVariable( QName pQName) {
        return this.mVariables.get( pQName );
    }
}
