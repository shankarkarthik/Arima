package org.ahp.vinavidai.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.ahp.commons.util.AhpStringUtil;
import org.ahp.core.pojo.BaseEntity;

@Entity
@Table( name = "QUIZ_CONFIG",
        schema = "VINAVIDAI" )
public class QuizConfig extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long mQuizConfigId;
	private Long mQuizId;
	private String mConfigName;
	private String mConfigValue;
	private String mDescription;
    
	@Id
    @GeneratedValue
	@Column( name = "QUIZ_CONFIG_ID" )
	public Long getQuizConfigId() {
        return mQuizConfigId;
    }
    public void setQuizConfigId( Long pQuizConfigId ) {
        mQuizConfigId = pQuizConfigId;
    }
    @Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }
    @Column( name = "CONFIG_NAME" )
    public String getConfigName() {
        return mConfigName;
    }
    public void setConfigName( String pConfigName ) {
        mConfigName = pConfigName;
    }
    @Column( name = "CONFIG_VALUE" )
    public String getConfigValue() {
        return mConfigValue;
    }
    public void setConfigValue( String pConfigValue ) {
        mConfigValue = pConfigValue;
    }
    @Column( name = "CONFIG_DESCRIPTION" )
    public String getDescription() {
        return mDescription;
    }
    public void setDescription( String pDesciption ) {
        mDescription = pDesciption;
    }
        
    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
	
}
