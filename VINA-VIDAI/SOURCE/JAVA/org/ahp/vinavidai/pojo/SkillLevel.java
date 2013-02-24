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
@Table( name = "SKILL_LEVEL",
        schema = "VINAVIDAI" )
public class SkillLevel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long mSkillLevelId;
    private Long mQuizId;
    private String mSkillLevel;
    
    @Id
    @GeneratedValue
    @Column( name = "SKILL_LEVEL_ID" )
    public Long getSkillLevelId() {
        return mSkillLevelId;
    }
    public void setSkillLevelId( Long pSkillLevelId ) {
        mSkillLevelId = pSkillLevelId;
    }
    @Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }
    @Column( name = "SKILL_LEVEL" )
    public String getSkillLevel() {
        return mSkillLevel;
    }
    public void setSkillLevel( String pSkillLevel ) {
        mSkillLevel = pSkillLevel;
    }
    
    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
    
}
