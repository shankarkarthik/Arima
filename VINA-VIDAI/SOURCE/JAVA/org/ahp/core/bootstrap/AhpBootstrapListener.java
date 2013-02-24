package org.ahp.core.bootstrap;

import static org.ahp.core.constants.AhpConstants.AHP_CONFIGURATION;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.commons.util.AhpResourceUtil;
import org.ahp.core.managers.IAhpBootstrapManager;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 * @spring.bean
 *     id="ahpBootstrapListener"
 * 
 * @spring.property
 *     name="ahpBootstrapManager"
 *     ref="ahpBootstrapManager" 
 
 */
public class AhpBootstrapListener implements ServletContextListener {    
    
    private IAhpBootstrapManager mAhpBootstrapManager;
    /**
     * Default Constructor 
     */
    public AhpBootstrapListener() {
        super();
    }
    
    /**
     * 
     * @param pAhpBootstrapManager
     */
    public void setAhpBootstrapManager( IAhpBootstrapManager pAhpBootstrapManager ){
        this.mAhpBootstrapManager = pAhpBootstrapManager;        
    }
    
    /**
     * Bootstrap APH 
     * 
     */
    public void contextInitialized( ServletContextEvent pServletContextEvent ) {
        try {
            ServletContext lServletContext = pServletContextEvent.getServletContext();
            String lAhpConfiguration = lServletContext.getInitParameter( AHP_CONFIGURATION );
            String lRealPath = lServletContext.getRealPath( "/" );          
            StringBuilder lAhpConfigurationFileStringBuilder = new StringBuilder();
            for ( String lAhpConfigFile : lAhpConfiguration.split( "," ) ) {
                if ( !AhpResourceUtil.isClassPathResource( lAhpConfigFile ) || 
                     !AhpResourceUtil.isClassPathResource( lAhpConfigFile ) ) {
                    Path lAhpConfigurationFilePath = Paths.get( lRealPath + lAhpConfigFile );
                    lAhpConfigurationFileStringBuilder.append( lAhpConfigurationFilePath.toUri() + "," );
                } else {
                    lAhpConfigurationFileStringBuilder.append( lAhpConfigFile );
                }
            }
            System.out.println( "ConfigurationFiles - " + lAhpConfigurationFileStringBuilder.toString() );        
            this.mAhpBootstrapManager.bootstrap( lAhpConfigurationFileStringBuilder.toString().split( "," ), lRealPath );
        } catch ( AhpRuntimeException exAhpRuntime ) {
            throw exAhpRuntime;
        } catch ( Exception ex ) {
            throw new AhpRuntimeException( "AHP.001.0001", ex );
        }
    }
    

    @Override
    public void contextDestroyed( ServletContextEvent pServletContextEvent ) {
    }
}
