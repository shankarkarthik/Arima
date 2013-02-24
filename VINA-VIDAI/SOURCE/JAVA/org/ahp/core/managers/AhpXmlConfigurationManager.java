package org.ahp.core.managers;

import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPathExpression;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.commons.util.AhpResourceUtil;
import org.ahp.commons.xml.dom.AhpDomLevel3LS;
import org.ahp.commons.xml.xpath.AhpXPathUtil;
import org.ahp.configuration.pojo.AhpConfiguration;
import org.ahp.configuration.pojo.AhpDeployment;
import org.ahp.configuration.pojo.AhpLocale;
import org.ahp.configuration.pojo.AhpMessageResource;
import org.ahp.configuration.pojo.enums.AhpDeploymentEnvironment;
import org.ahp.configuration.pojo.enums.AhpMessageResourceLoadType;
import org.ahp.configuration.pojo.enums.AhpMessageResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 * @spring.bean
 *     id="ahpConfigurationManager"
 */
final class AhpXmlConfigurationManager implements IAhpConfigurationManager {
	
	/** DOCUMENT ME! */
	final static Logger LOGGER = LoggerFactory.getLogger( AhpXmlConfigurationManager.class );
		
    @Override
    public void init( AhpConfiguration pAhpConfiguration ) {
    }   

    @Override
    public void start() {
    }
    
    @Override
    public void stop() {
    }

    @Override
    public void destroy() {        
    }

    /**
     * DOCUMENT ME!
     */
    @Override
    public AhpConfiguration configure( String[] pResourceUriArray, String pRealPath ){
        AhpConfiguration lAhpConfiguration = new AhpConfiguration();
        try {
            AhpXPathUtil lAhpXPathUtil = new AhpXPathUtil();
            Map<String,XPathExpression> lCompiledExpressions = this.compileExpressions( lAhpXPathUtil );
            for ( String lResourceUri : pResourceUriArray ){
                if ( !AhpResourceUtil.isFileResource( lResourceUri ) ) {
                    lResourceUri = AhpResourceUtil.getWebInfResourceAsFileResourceUri( lResourceUri, pRealPath );
                }
                Node lAhpConfigurationNode = AhpDomLevel3LS.loadNodeFromUri( lResourceUri );                
                Node lAhpDeploymentNode = lAhpXPathUtil.getAsNode( lAhpConfigurationNode, lCompiledExpressions.get( "AhpDeployment" ) );
                AhpDeployment lAhpDeployment = this.parseAhpDeployment( lAhpDeploymentNode, lAhpXPathUtil, lCompiledExpressions );
                if ( lAhpDeployment != null )
                    lAhpConfiguration.setAhpDeployment( lAhpDeployment );
                Node lAhpMessageResourcesNode = lAhpXPathUtil.getAsNode( lAhpConfigurationNode, lCompiledExpressions.get( "AhpMessageResources" ) );
                if ( lAhpConfiguration.getAhpMessageResources() == null ) {
                    lAhpConfiguration.setAhpMessageResources( this.parseAhpMessageResource( lAhpMessageResourcesNode, lAhpXPathUtil, lCompiledExpressions ) );    
                } else {
                    lAhpConfiguration.getAhpMessageResources().putAll( this.parseAhpMessageResource( lAhpMessageResourcesNode, lAhpXPathUtil, lCompiledExpressions ) );
                }
                lAhpConfiguration.getAhpDeployment().setRealPath( pRealPath );
            }
        } catch ( AhpRuntimeException exXPathExpression ) {
            exXPathExpression.printStackTrace();
        }
        LOGGER.debug( "AhpConfiguration :: {}", lAhpConfiguration );
        return lAhpConfiguration;
    }

    /**
     * 
     * @param pAhpXPathUtil
     * @return
     */
    private Map<String,XPathExpression> compileExpressions( AhpXPathUtil pAhpXPathUtil ){
        Map<String,XPathExpression> lCompiledExpressions = new HashMap<String,XPathExpression>();
        lCompiledExpressions.put( "AhpMessageResources", pAhpXPathUtil.compileXPathExpression( "/AhpConfiguration/AhpMessageResources" ) );
        lCompiledExpressions.put( "AhpDeployment", pAhpXPathUtil.compileXPathExpression( "/AhpConfiguration/AhpDeployment" ) );
        lCompiledExpressions.put( "AhpDeployment.DeploymentEnvironment", pAhpXPathUtil.compileXPathExpression( "DeploymentEnvironment" ) );
        lCompiledExpressions.put( "AhpDeployment.LogFileLocation", pAhpXPathUtil.compileXPathExpression( "LogFileLocation" ) );
        lCompiledExpressions.put( "AhpMessageResource", pAhpXPathUtil.compileXPathExpression( "AhpMessageResource" ) );
        lCompiledExpressions.put( "AhpMessageResource.@name", pAhpXPathUtil.compileXPathExpression( "@name" ) );
        lCompiledExpressions.put( "AhpMessageResource.@loadType", pAhpXPathUtil.compileXPathExpression( "@loadType" ) );
        lCompiledExpressions.put( "AhpMessageResource.@resourceType", pAhpXPathUtil.compileXPathExpression( "@resourceType" ) );
        lCompiledExpressions.put( "AhpMessageResource.@resource", pAhpXPathUtil.compileXPathExpression( "@resource" ) );
        lCompiledExpressions.put( "AhpLocale", pAhpXPathUtil.compileXPathExpression( "AhpLocale" ) );
        lCompiledExpressions.put( "AhpLocale.@country", pAhpXPathUtil.compileXPathExpression( "@country" ) );
        lCompiledExpressions.put( "AhpLocale.@language", pAhpXPathUtil.compileXPathExpression( "@language" ) );
        lCompiledExpressions.put( "AhpLocale.@variant", pAhpXPathUtil.compileXPathExpression( "@variant" ) );
        return lCompiledExpressions;
    }
    
    /**
     * 
     * @param pAhpDeploymentNode
     * @param pAhpXPathUtil
     * @param pCompiledExpressions
     * @return
     */
    private AhpDeployment parseAhpDeployment( Node pAhpDeploymentNode, AhpXPathUtil pAhpXPathUtil, Map<String,XPathExpression> pCompiledExpressions ){
        AhpDeployment lAhpDeployment = new AhpDeployment();
        if ( pAhpDeploymentNode == null ) {
            return null;
        }
        String lDeploymentEnvironment = pAhpXPathUtil.getAsString( pAhpDeploymentNode, pCompiledExpressions.get( "AhpDeployment.DeploymentEnvironment" ) );
        String lLogFileLocation = pAhpXPathUtil.getAsString( pAhpDeploymentNode, pCompiledExpressions.get( "AhpDeployment.LogFileLocation" ) );
        lAhpDeployment.setDeploymentEnvironment( AhpDeploymentEnvironment.valueOf( lDeploymentEnvironment ) );
        lAhpDeployment.setLogFileLocation( lLogFileLocation );
        return lAhpDeployment;
    }
    
    /**
     * 
     * @param pAhpMessageResourcesNode
     * @param pAhpXPathUtil
     * @return
     */
    private Map<String,AhpMessageResource> parseAhpMessageResource( Node pAhpMessageResourcesNode, AhpXPathUtil pAhpXPathUtil, Map<String,XPathExpression> pCompiledExpressions ){
        Map<String,AhpMessageResource> lAhpMessageResources = new HashMap<String,AhpMessageResource>();
        if ( pAhpMessageResourcesNode == null ) {
            return lAhpMessageResources;
        }
        NodeList lMessageResources = pAhpXPathUtil.getAsNodeList( pAhpMessageResourcesNode, pCompiledExpressions.get( "AhpMessageResource" ) );
        for ( int i = 0; i < lMessageResources.getLength(); i++ ) {
            Node lMessageResource = ( Node ) lMessageResources.item( i );
            //LOGGER.debug( AhpDomLevel3LS.saveNodeToString( lMessageResource ) );
            AhpMessageResource lAhpMessageResource = new AhpMessageResource();
            String lMessageResourceName = pAhpXPathUtil.getAsString( lMessageResource, pCompiledExpressions.get( "AhpMessageResource.@name" ) );
            String lMessageResourceLoadType = pAhpXPathUtil.getAsString( lMessageResource, pCompiledExpressions.get( "AhpMessageResource.@loadType" ) );
            String lMessageResourceResourceType = pAhpXPathUtil.getAsString( lMessageResource, pCompiledExpressions.get( "AhpMessageResource.@resourceType" ) );
            String lMessageResourceResource = pAhpXPathUtil.getAsString( lMessageResource, pCompiledExpressions.get( "AhpMessageResource.@resource" ) );

            Node lAhpLocaleNode = pAhpXPathUtil.getAsNode( lMessageResource, pCompiledExpressions.get( "AhpLocale" ) );
            String lAhpLocaleCountry = pAhpXPathUtil.getAsString( lAhpLocaleNode, pCompiledExpressions.get( "AhpLocale.@country" ) );
            String lAhpLocaleLanguage = pAhpXPathUtil.getAsString( lAhpLocaleNode, pCompiledExpressions.get( "AhpLocale.@language" ) );
            String lAhpLocaleVariant = pAhpXPathUtil.getAsString( lAhpLocaleNode, pCompiledExpressions.get( "AhpLocale.@variant" ) );

            lAhpMessageResource.setName(  lMessageResourceName );
            lAhpMessageResource.setLoadType( AhpMessageResourceLoadType.valueOf( lMessageResourceLoadType ) );
            lAhpMessageResource.setResourceType( AhpMessageResourceType.valueOf( lMessageResourceResourceType ) );
            lAhpMessageResource.setResource( lMessageResourceResource );
            
            AhpLocale lAhpLocale = new AhpLocale();
            lAhpLocale.setCountry( lAhpLocaleCountry );
            lAhpLocale.setLanguage( lAhpLocaleLanguage );
            lAhpLocale.setVariant( lAhpLocaleVariant );
            lAhpMessageResource.setAhpLocale( lAhpLocale );
            lAhpMessageResources.put( lAhpMessageResource.getName(), lAhpMessageResource );
        }
        return lAhpMessageResources;
    }
}
