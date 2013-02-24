package org.ahp.commons.validator;

import static org.ahp.commons.validator.ValidatorConstants.EMAIL_ADDRESS_ALLOWED_REGEX;
import static org.ahp.commons.validator.ValidatorConstants.EMAIL_ADDRESS_MAX_LENGTH;
import static org.ahp.commons.validator.ValidatorConstants.EMAIL_ADDRESS_MIN_LENGTH;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public abstract class AbstractValidator {

    /**
     * Uses JDK 1.5 VarArgs
     * @param pActionErrors
     * @param pErrorKeySet The Actual Parameters can be either an Array or VarArgs of type Set<String> 
     */
    public static void populateActionErrors( ActionErrors pActionErrors, 
                                             Set<String>... pErrorKeySet ){
        for ( Set<String> lErrorKeySet : pErrorKeySet ){
            for ( String lErrorKey : lErrorKeySet ){
                pActionErrors.add( ActionMessages.GLOBAL_MESSAGE, 
                                   new ActionMessage( lErrorKey ) );
            }
        }
    }
    
    /**
     * Uses JDK 1.5 VarArgs
     * @param pActionErrors
     * @param pErrorKeySet The Actual Parameters can be either an Array or VarArgs of type Set<String> 
     */
    public static void populateActionMessages( ActionMessages pActionMessages, 
                                               Set<String>... pErrorKeySet ){
        for ( Set<String> lErrorKeySet : pErrorKeySet ){
            for ( String lErrorKey : lErrorKeySet ){
                pActionMessages.add( ActionMessages.GLOBAL_MESSAGE, 
                                     new ActionMessage( lErrorKey ) );
                
            }
        }
    }
    
    /**
     * 
     * @param pActionErrors
     * @param pErrorKey
     * @param pReplacementTokensSet
     */
    public static void populateActionErrorsWithReplacementTokens( ActionErrors pActionErrors,
                                                                  String pErrorKey, 
                                                                  Set<String> pReplacementTokensSet  ){
        for ( String lReplacementToken : pReplacementTokensSet ){
            pActionErrors.add( ActionMessages.GLOBAL_MESSAGE, 
                               new ActionMessage( pErrorKey, lReplacementToken )  );
        }
    }
    
    /**
     * 
     * @param pEmailAddress
     * @param pErrorKeyPrefix
     * @return
     */
    public static Set<String> validateEmailAddress( String pEmailAddress, String pErrorKeyPrefix ) {
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( pEmailAddress == null || "".equals( pEmailAddress ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".email.required" );
            return lErrorKeySet;
        }
        if ( ( pEmailAddress == null ) || "".equals( pEmailAddress ) ) {
            return lErrorKeySet;
        }
        if ( pEmailAddress.length() < EMAIL_ADDRESS_MIN_LENGTH ) {
           lErrorKeySet.add( pErrorKeyPrefix + ".email.min" );
           return lErrorKeySet;
        }
        if ( pEmailAddress.length() > EMAIL_ADDRESS_MAX_LENGTH ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".email.max" );
        }
        if ( !ValidatorUtil.validateAllowedCharacters( pEmailAddress, EMAIL_ADDRESS_ALLOWED_REGEX ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".email.notvalid" );
        }
        return lErrorKeySet;
    }
}
