package org.ahp.commons.util;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AhpStringUtil {
	
    final static Logger LOGGER = LoggerFactory.getLogger( AhpStringUtil.class );
    
    /**
     * 
     * @param pObject
     * @return
     */
	public static String reflectionToString( Object pObject ){
		return ToStringBuilder.reflectionToString( pObject, ToStringStyle.MULTI_LINE_STYLE );
	} 

	/**
     * 
     * @param pListToConvert
     * @param pDelimiter
     * @return
     */
    public static String listToString( List<String> pListToConvert ){
        return listToString( pListToConvert, ",");
    }
    
	/**
	 * 
	 * @param pListToConvert
	 * @param pDelimiter
	 * @return
	 */
	public static String listToString( List<String> pListToConvert, String pDelimiter ){
        StringBuilder lStringBuilder = new StringBuilder();        
        if( pListToConvert != null){
            for( int i = 0; i < pListToConvert.size(); i++ ){
                if( i == pListToConvert.size() - 1 )
                    lStringBuilder.append( pListToConvert.get( i ) );
                else
                    lStringBuilder.append( pListToConvert.get( i ) ).append( pDelimiter ); 
            }
        }
        return lStringBuilder.toString();
    }
    
	public static String listToQuotedString( List<String> pListToConvert ){
	    return listToQuotedString( pListToConvert, "," );
	}
	
	/**
	 * 
	 * @param pListToConvert
	 * @param pDelimiter
	 * @return
	 */
    public static String listToQuotedString( List<String> pListToConvert, String pDelimiter ){
        StringBuilder lStringBuilder = new StringBuilder();        
        if( pListToConvert != null ){
            for( int i = 0; i < pListToConvert.size(); i++ ){
                if( i == pListToConvert.size()-1 )
                    lStringBuilder.append( "'" + pListToConvert.get( i ) + "'" );
                else
                    lStringBuilder.append( "'" + pListToConvert.get( i ) + "'" ).append( pDelimiter ); 
            }
        }
        return lStringBuilder.toString();
    }
}
