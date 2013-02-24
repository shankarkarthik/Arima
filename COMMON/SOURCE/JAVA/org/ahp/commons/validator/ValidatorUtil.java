package org.ahp.commons.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ValidatorUtil {

    final static Logger LOGGER = LoggerFactory.getLogger( ValidatorUtil.class );
    
    /**
     * 
     * @param pInputString
     * @param pRegex
     * @return
     */
    public static boolean validateAllowedCharacters( String pInputString,
                                                     String pRegex ) {
        Pattern lPattern = Pattern.compile( pRegex );
        Matcher lMatcher = lPattern.matcher( pInputString );
        return lMatcher.matches();
    }
    
    public static boolean isAlphaNumeric( String pInputString ){
        return StringUtils.isAlphanumeric( pInputString );
    }

    public static boolean isAlpha( String pInputString ){
        return StringUtils.isAlpha( pInputString );
    }

    public static boolean isNumeric( String pInputString ){
        return StringUtils.isNumeric( pInputString );
    }

}
