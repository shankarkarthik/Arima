package org.ahp.configuration.pojo;

import java.io.Serializable;
import java.util.Map;

import org.ahp.commons.util.AhpStringUtil;

public class AhpConfiguration implements Serializable {
    
    private AhpDeployment mAhpDeployment;
    private Map<String,AhpMessageResource> mAhpMessageResources;
    
    public AhpDeployment getAhpDeployment() {
        return mAhpDeployment;
    }
    public void setAhpDeployment( AhpDeployment pAhpDeployment ) {
        mAhpDeployment = pAhpDeployment;
    }
    public Map<String, AhpMessageResource> getAhpMessageResources() {
        return mAhpMessageResources;
    }
    public void setAhpMessageResources(
            Map<String, AhpMessageResource> pAhpMessageResources ) {
        mAhpMessageResources = pAhpMessageResources;
    }
    public String toString(){
        return AhpStringUtil.reflectionToString(  this );
    }

}
