package org.ahp.configuration.pojo;

import java.io.Serializable;

import org.ahp.commons.util.AhpStringUtil;

public class AhpLocale implements Serializable {
    
    private String mLanguage;
    private String mCountry;
    private String mVariant;
    
    public String getLanguage() {
        return mLanguage;
    }
    public void setLanguage( String pLanguage ) {
        mLanguage = pLanguage;
    }
    public String getCountry() {
        return mCountry;
    }
    public void setCountry( String pCountry ) {
        mCountry = pCountry;
    }
    public String getVariant() {
        return mVariant;
    }
    public void setVariant( String pVariant ) {
        mVariant = pVariant;
    }
    
    public String toString(){
        return AhpStringUtil.reflectionToString(  this );
    }

}
