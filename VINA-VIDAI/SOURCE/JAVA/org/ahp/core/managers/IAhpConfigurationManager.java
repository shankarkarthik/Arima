package org.ahp.core.managers;

import org.ahp.configuration.pojo.AhpConfiguration;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public interface IAhpConfigurationManager extends IAhpManagerLifecycle {
    
    /**
     * 
     * @param pResourceUri
     */
    public AhpConfiguration configure( String[] pResourceUri, String pRealPath );

}
