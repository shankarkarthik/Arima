package org.ahp.core.managers;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public interface IAhpBootstrapManager extends IAhpManagerLifecycle {
  
    public void bootstrap(  String[] pAhpConfigFileResourceUri, String pRealPath );
}
