package org.ahp.core.managers;

import java.io.InputStream;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.ahp.commons.util.AhpResourceUtil;
import org.ahp.configuration.pojo.AhpConfiguration;
import org.ahp.configuration.pojo.AhpDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 * @spring.bean
 *     id="ahpLoggerManager"
 */
public final class AhpLogBackLoggerManager implements IAhpLoggerManager {
	
	final static Logger LOGGER = LoggerFactory.getLogger( AhpLogBackLoggerManager.class);
	
    @Override
    public void destroy() {
    }

    @Override
    public void init( AhpConfiguration pAhpConfiguration ) {
        this.configure( pAhpConfiguration.getAhpDeployment() );
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
    
    /**
     * 
     * @param pResourceUri
     */
    @Override
    public void configure( AhpDeployment pAhpDeployment ){
        // assume SLF4J is bound to logback in the current environment
        String lResourceUri = pAhpDeployment.getLogFileLocation();
        InputStream lInputStream = null;
        if ( AhpResourceUtil.isClassPathResource( lResourceUri ) ){
            lInputStream = AhpResourceUtil.getClassPathResource( lResourceUri );
        } else if ( AhpResourceUtil.isFileResource( lResourceUri ) ){
            lInputStream = AhpResourceUtil.getFileResource( lResourceUri );
        } else if ( AhpResourceUtil.isWebInfResource( lResourceUri ) ){
            lResourceUri = AhpResourceUtil.getWebInfResourceAsFileResourceUri( lResourceUri, pAhpDeployment.getRealPath() );
            lInputStream = AhpResourceUtil.getFileResource( lResourceUri );
        } else {
            throw new AhpRuntimeException( "AHP" );
        }
        LoggerContext lLoggerContext = ( LoggerContext ) LoggerFactory.getILoggerFactory();     
        try {
          JoranConfigurator lJoranConfigurator = new JoranConfigurator();
          lJoranConfigurator.setContext( lLoggerContext );
          // the context was probably already configured by default configuration rules
          lLoggerContext.reset(); 
          lJoranConfigurator.doConfigure( lInputStream );
        } catch ( JoranException exJoran ) {
            new AhpRuntimeException( "Logger Initialization Failed", exJoran );
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings( lLoggerContext );
        LOGGER.info( "Logback Initialized." );
    }

}
