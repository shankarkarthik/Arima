package org.ahp.vinavidai.enums;

import java.util.LinkedHashSet;
import java.util.Set;

public final class EnumWrapper {
    
    /**
     * 
     * @return
     */
    public static Set<String> enumerateListStyle(){
        Set<String> lListStyleEnumSet = new LinkedHashSet<String>();
        for ( ListStyle lListStyle : ListStyle.values() ) {
            lListStyleEnumSet.add( lListStyle.toString() );
        }
        return lListStyleEnumSet;
    } 

    /**
     * 
     * @return
     */
    public static Set<String> enumerateOptionType(){
        Set<String> lOptionTypeEnumSet = new LinkedHashSet<String>();
        for ( OptionType lOptionType : OptionType.values() ) {
            lOptionTypeEnumSet.add( lOptionType.toString() );
        }
        return lOptionTypeEnumSet;
    } 


    /**
     * 
     * @return
     */
    public static Set<String> enumerateDisplayStyle(){
        Set<String> lDisplayStyleEnumSet = new LinkedHashSet<String>();
        for ( DisplayStyle lDisplayStyle : DisplayStyle.values() ) {
            lDisplayStyleEnumSet.add( lDisplayStyle.toString() );
        }
        return lDisplayStyleEnumSet;
    } 

}
