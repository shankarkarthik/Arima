package org.ahp.login;

import org.ahp.commons.businessdelegate.AhpAbstractBusinessDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public class PasswordService extends AhpAbstractBusinessDelegate {
    
    final static Logger LOGGER = LoggerFactory.getLogger( LoginService.class );
    
    final static int DEFAULT_ITERATION_COUNT = 1000;
    
    public String createPasswordSalt(){
    	return null;
    } 

    public String createPasswordDigest( String pClearTextPassword, String pPasswordSalt, int pNumberOfIterations ){
    	return null;
    }

    public String createPasswordDigest( String pClearTextPassword, String pPasswordSalt ){
    	return  createPasswordDigest( pClearTextPassword, pPasswordSalt, DEFAULT_ITERATION_COUNT );
    }

    public String createPasswordDigest( String pClearTextPassword ){
    	return createPasswordDigest( pClearTextPassword, createPasswordSalt() );
    }

}
