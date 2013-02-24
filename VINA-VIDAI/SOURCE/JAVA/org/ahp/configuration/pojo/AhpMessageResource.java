package org.ahp.configuration.pojo;

import java.io.Serializable;

import org.ahp.commons.util.AhpStringUtil;
import org.ahp.configuration.pojo.enums.AhpMessageResourceLoadType;
import org.ahp.configuration.pojo.enums.AhpMessageResourceType;

public class AhpMessageResource implements Serializable {
    
    private AhpLocale mAhpLocale;
    private String mName;
    private AhpMessageResourceLoadType mLoadType;
    private AhpMessageResourceType mResourceType;
    private String mResource;
    
    public AhpLocale getAhpLocale() {
        return mAhpLocale;
    }
    public void setAhpLocale( AhpLocale pAhpLocale ) {
        mAhpLocale = pAhpLocale;
    }
    public String getName() {
        return mName;
    }
    public void setName( String pName ) {
        mName = pName;
    }
    public AhpMessageResourceLoadType getLoadType() {
        return mLoadType;
    }
    public void setLoadType( AhpMessageResourceLoadType pLoadType ) {
        mLoadType = pLoadType;
    }
    public AhpMessageResourceType getResourceType() {
        return mResourceType;
    }
    public void setResourceType( AhpMessageResourceType pResourceType ) {
        mResourceType = pResourceType;
    }
    public String getResource() {
        return mResource;
    }
    public void setResource( String pResource ) {
        mResource = pResource;
    }

    public String toString(){
        return AhpStringUtil.reflectionToString(  this );
    }
}
