package org.ahp.vinavidai.pojo;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.ahp.commons.util.AhpStringUtil;
import org.ahp.core.pojo.BaseEntity;
import org.ahp.vinavidai.enums.Status;

@Entity
@Table( name = "QUIZ",
        schema = "VINAVIDAI" )
public class Quiz extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long mQuizId;
	private String mName;
	private String mDescription;
	private Status mStatus;
	private Map<Long,QuizConfig> mQuizConfig;
	private Map<Long,Category> mCategory;
	private Map<Long,SkillLevel> mSkillLevel;
	private Map<Long,Question> mQuestions;

	//Transient Fields
    private Set<QuizConfig> mQuizConfigSet;
    private Set<Category> mCategorySet;
    private Set<SkillLevel> mSkillLevelSet;

	@Id
    @GeneratedValue
	@Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }    
    @Column( name = "QUIZ_NAME",
             nullable = false, 
             length = 255 )
    public String getName() {
        return mName;
    }
    public void setName( String pName ) {
        mName = pName;
    }
    @Column( name = "QUIZ_DESCRIPTION",
             nullable = false,
             length = 2000 )
    public String getDescription() {
        return mDescription;
    }
    public void setDescription( String pDescription ) {
        mDescription = pDescription;
    }
    @OneToMany( targetEntity =  org.ahp.vinavidai.pojo.QuizConfig.class,
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    @JoinColumn( name = "QUIZ_ID",
                 referencedColumnName = "QUIZ_ID",
                 updatable = false )
    @MapKey()
    public Map<Long, QuizConfig> getQuizConfig() {
        return mQuizConfig;
    }
    public void setQuizConfig( Map<Long, QuizConfig> pQuizConfig ) {
        mQuizConfig = pQuizConfig;
    }
    @OneToMany( targetEntity =  org.ahp.vinavidai.pojo.Question.class,
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    @JoinColumn( name = "QUIZ_ID",
                 referencedColumnName = "QUIZ_ID",
                 updatable = false )
    @MapKey()
    public Map<Long, Question> getQuestions() {
        return mQuestions;
    }
    public void setQuestions( Map<Long, Question> pQuestions ) {
        mQuestions = pQuestions;
    }
    @OneToMany( targetEntity =  org.ahp.vinavidai.pojo.Category.class,
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    @JoinColumn( name = "QUIZ_ID",
                 referencedColumnName = "QUIZ_ID",
                 updatable = false )
    @MapKey()
    public Map<Long,Category> getCategory() {
        return mCategory;
    }
    public void setCategory( Map<Long,Category> pCategory ) {
        mCategory = pCategory;
    }
    @OneToMany( targetEntity = org.ahp.vinavidai.pojo.SkillLevel.class,
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    @JoinColumn( name = "QUIZ_ID",
                 referencedColumnName = "QUIZ_ID",
                 updatable = false )
    @MapKey()    
    public Map<Long,SkillLevel> getSkillLevel() {
        return mSkillLevel;
    }
    public void setSkillLevel( Map<Long,SkillLevel> pSkillLevel ) {
        mSkillLevel = pSkillLevel;
    }
    @Column( name = "STATUS",
             nullable = false )
    @Enumerated( EnumType.STRING )
    public Status getStatus() {
        return mStatus;
    }
    public void setStatus( Status pStatus ) {
        mStatus = pStatus;
    }
    @Transient
    public Set<QuizConfig> getQuizConfigSet() {
        return mQuizConfigSet;
    }
    public void setQuizConfigSet( Set<QuizConfig> pQuizConfigSet ) {
        mQuizConfigSet = pQuizConfigSet;
    }
    @Transient
    public Set<Category> getCategorySet() {
        return mCategorySet;
    }
    public void setCategorySet( Set<Category> pCategorySet ) {
        mCategorySet = pCategorySet;
    }
    @Transient
    public Set<SkillLevel> getSkillLevelSet() {
        return mSkillLevelSet;
    }
    public void setSkillLevelSet( Set<SkillLevel> pSkillLevelSet ) {
        mSkillLevelSet = pSkillLevelSet;
    }
    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
}