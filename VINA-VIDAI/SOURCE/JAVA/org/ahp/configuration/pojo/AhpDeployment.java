package org.ahp.configuration.pojo;

import java.io.Serializable;

import org.ahp.commons.util.AhpStringUtil;
import org.ahp.configuration.pojo.enums.AhpDeploymentEnvironment;

public class AhpDeployment implements Serializable {
    
    private AhpDeploymentEnvironment mDeploymentEnvironment;
    private String mLogFileLocation;
    private String mRealPath;
    
    public AhpDeploymentEnvironment getDeploymentEnvironment() {
        return mDeploymentEnvironment;
    }
    public void setDeploymentEnvironment(
            AhpDeploymentEnvironment pDeploymentEnvironment ) {
        mDeploymentEnvironment = pDeploymentEnvironment;
    }
    public String getLogFileLocation() {
        return mLogFileLocation;
    }
    public void setLogFileLocation( String pLogFileLocation ) {
        mLogFileLocation = pLogFileLocation;
    }
    public String getRealPath() {
        return mRealPath;
    }
    public void setRealPath( String pRealPath ) {
        mRealPath = pRealPath;
    }
    public String toString(){
        return AhpStringUtil.reflectionToString(  this );
    }

}
