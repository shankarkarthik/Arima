package org.ahp.core.bootstrap;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.configuration.pojo.AhpConfiguration;
import org.ahp.core.managers.IAhpBootstrapManager;
import org.ahp.core.managers.IAhpConfigurationManager;
import org.ahp.core.managers.IAhpLoggerManager;
import org.ahp.core.managers.IAhpMessageResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 * @spring.bean
 *     id="ahpBootstrapManager"
 * 
 * @spring.property
 *     name="ahpLoggerManager"
 *     ref="ahpLoggerManager" 
 * 
 * @spring.property
 *     name="ahpConfigurationManager"
 *     ref="ahpConfigurationManager" 
 * 
 * @spring.property
 *     name="ahpMessageResourceManager"
 *     ref="ahpMessageResourceManager" 
 */
public class AhpBootstrapManager implements IAhpBootstrapManager {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpBootstrapManager.class );
    
    private String[] mAhpConfigFileLocation; 
    private AhpConfiguration mAhpConfiguration;
    private IAhpConfigurationManager mAhpConfigurationManager;
    private IAhpLoggerManager mAhpLoggerManager;
    private IAhpMessageResourceManager mAhpResourceBundleManager;
        
    public void setAhpConfigurationManager( IAhpConfigurationManager pAhpConfigurationManager ){
        this.mAhpConfigurationManager = pAhpConfigurationManager;
    }

    public void setAhpLoggerManager( IAhpLoggerManager pAhpLoggerManager ){
        this.mAhpLoggerManager = pAhpLoggerManager;
    }
    
    public void setAhpMessageResourceManager( IAhpMessageResourceManager pAhpResourceBundleManager ){
        this.mAhpResourceBundleManager = pAhpResourceBundleManager;
    }
    
    /**
	 * 
	 * @param pAhpConfigFileLocation
	 */
    @Override
    public void bootstrap( String[] pAhpConfigFileResourceUri, String pRealPath ){
	    this.mAhpConfigFileLocation = pAhpConfigFileResourceUri;
        this.mAhpConfigurationManager.init( null );
	    this.mAhpConfiguration = mAhpConfigurationManager.configure( mAhpConfigFileLocation, pRealPath );
	    this.init( mAhpConfiguration );
	    this.start();
	}

	/**
     * 
     * @param pAhpConfigFileLocation
     */
    public AhpConfiguration getAhpConfiguration(){
        return null;
    }

    @Override
    public void init( AhpConfiguration pAhpConfiguration ) {
        try {
            mAhpConfigurationManager.init( pAhpConfiguration);
            mAhpLoggerManager.init( pAhpConfiguration );
            mAhpResourceBundleManager.init( pAhpConfiguration );
        } catch ( AhpRuntimeException exAhpRuntime ) {
            // printStackTrace as LOGGER may not be initialized
            exAhpRuntime.printStackTrace();
            throw exAhpRuntime;
        } catch ( Exception ex ) {
            // printStackTrace as LOGGER may not be initialized
            ex.printStackTrace();
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
}
