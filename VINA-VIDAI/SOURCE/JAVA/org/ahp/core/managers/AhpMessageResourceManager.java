package org.ahp.core.managers;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.configuration.pojo.AhpConfiguration;
import org.ahp.configuration.pojo.AhpMessageResource;
import org.ahp.configuration.pojo.enums.AhpMessageResourceLoadType;
import org.ahp.core.exceptions.AhpExceptionCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Shankar Karthik Vaithianathan
 * @spring.bean
 *     id="ahpMessageResourceManager"
 */
public class AhpMessageResourceManager implements IAhpMessageResourceManager {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpMessageResourceManager.class );
    
    private Map<String,ResourceBundle> mResourceBundles = new HashMap<String,ResourceBundle>();
    
    @Override
    public void init( AhpConfiguration pAhpConfiguration ) {
        Map<String,AhpMessageResource> lAhpMessageResources = pAhpConfiguration.getAhpMessageResources();        
        for ( Map.Entry<String, AhpMessageResource> lAhpMessageResourcesEntry : lAhpMessageResources.entrySet() ) {
            AhpMessageResource lAhpMessageResource = lAhpMessageResourcesEntry.getValue();
            if ( lAhpMessageResource.getLoadType() == AhpMessageResourceLoadType.FileSystem ) {
                LOGGER.debug( "Loading MessageResource " + lAhpMessageResourcesEntry.getKey() + " from FileSystem" );
                String lBundleName = lAhpMessageResource.getResource();
                if ( "".equals( lBundleName ) )
                    lBundleName = null;
                ResourceBundle lResourceBundle = ResourceBundle.getBundle( lBundleName );
                mResourceBundles.put( lAhpMessageResourcesEntry.getKey(), lResourceBundle );
            }
            else {
                LOGGER.debug( "Loading MessageResource " + lAhpMessageResourcesEntry.getKey() + " from FileSystem" );
            }
        }
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

    @Override
    public String getMessage( AhpExceptionCodes pExceptionCode,
                              Object[] pMessageArguments, 
                              String pResourceName ) {
        ResourceBundle lResourceBundle = null; 
        if ( pResourceName == null && mResourceBundles.size() == 1 ) {
                lResourceBundle = mResourceBundles.get( null ); 
        } else {
                throw new AhpRuntimeException( "" );
        }
        if ( lResourceBundle == null )
            lResourceBundle = mResourceBundles.get( pResourceName );
        String lMessage = lResourceBundle.getString( pExceptionCode.getValue() );
        if ( pMessageArguments != null ) {
            MessageFormat.format( lMessage, pMessageArguments ); 
        }
        return lMessage;
    }

    @Override
    public String getMessage( AhpExceptionCodes pExceptionCode, 
                              Object[] pMessageArguments ) {
        return getMessage( pExceptionCode, pMessageArguments, null );
    }

    @Override
    public String getMessage( AhpExceptionCodes pExceptionCode ) {
        return getMessage( pExceptionCode, null, null );
    }

    @Override
    public String getMessage( AhpExceptionCodes pExceptionCode, 
                              String pResourceName ) {
        return getMessage( pExceptionCode, null, pResourceName );
    }

}
