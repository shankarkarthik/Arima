package org.ahp.login.validator;

import static org.ahp.commons.validator.ValidatorConstants.EMAIL_ADDRESS_ALLOWED_REGEX;

import java.util.LinkedHashSet;
import java.util.Set;

import org.ahp.commons.validator.AbstractValidator;
import org.ahp.commons.validator.ValidatorUtil;
import org.apache.struts.action.ActionErrors;
import org.apache.commons.lang3.StringUtils;

public class BaseValidator extends AbstractValidator {

    public static final String LOGIN_ERROR_KEY_PREFIX = "login";
    public static final String  RESETPASSWORD_ERROR_KEY_PREFIX="password";
    
    /**
     * 
     * @param pLoginName
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateLoginName( String pLoginName, ActionErrors pActionErrors, String pErrorKeyPrefix ) {
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( pLoginName == null || "".equals( pLoginName ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".loginname.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if ( !ValidatorUtil.validateAllowedCharacters( pLoginName, EMAIL_ADDRESS_ALLOWED_REGEX ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".loginname.notvalid" );
        }
        AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
    }

    /**
     * 
     * @param pLoginPassword
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateLoginPassword( String pLoginPassword, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( pLoginPassword == null || "".equals( pLoginPassword ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".password.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        
    }
    
/**
 * 
 * DOCUMENT ME!
 * @param pNewPassword
 * @param pConfirmPassword
 * @param pActionErrors
 * @param pErrorKeyPrefix
 */
    @SuppressWarnings( "unchecked" )
    public static void validatePasswordFields( String pNewPassword,String pConfirmPassword, ActionErrors pActionErrors, String pErrorKeyPrefix )
    {
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( StringUtils.isEmpty( pNewPassword))  
        {
            lErrorKeySet.add( pErrorKeyPrefix + ".password.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if ( StringUtils.isEmpty( pConfirmPassword))  
        {
            lErrorKeySet.add( pErrorKeyPrefix + ".password.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if(!StringUtils.isEmpty( pNewPassword)&&!StringUtils.isEmpty( pConfirmPassword))
        {
	        if(!pNewPassword.equals(pConfirmPassword))
	        {
	        	lErrorKeySet.add( pErrorKeyPrefix + ".password.mismatch" );
	            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
	            return;	
	        }
        }    
	        
       }
        
    
}
