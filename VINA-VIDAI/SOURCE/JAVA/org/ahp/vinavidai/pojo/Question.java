package org.ahp.vinavidai.pojo;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ahp.commons.util.AhpStringUtil;
import org.ahp.core.pojo.BaseEntity;
import org.ahp.vinavidai.enums.OptionType;

@Entity
@Table( name = "QUESTION",
        schema = "VINAVIDAI" )
public class Question extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long mQuestionId;
	private Long mQuizId;
	private String mQuestionDescription;
	private String mQuestionObjective;
	private int mQuestionOrder;
	private int mPoints;
	private OptionType mOptionType;
    private Category mCategory;
    private SkillLevel mSkillLevel;
	private Map<Long,Option> mOption;

	@Id
    @GeneratedValue
	@Column( name = "QUESTION_ID" )
	public Long getQuestionId() {
        return mQuestionId;
    }
    public void setQuestionId( Long pQuestionId ) {
        mQuestionId = pQuestionId;
    }
    @Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }
    @Column( name = "DESCRIPTION" )
    public String getQuestionDescription() {
        return mQuestionDescription;
    }
    public void setQuestionDescription( String pQuestionDescription ) {
        mQuestionDescription = pQuestionDescription;
    }
    @Column( name = "OBJECTIVE" )
    public String getQuestionObjective() {
        return mQuestionObjective;
    }
    public void setQuestionObjective( String pQuestionObjective ) {
        mQuestionObjective = pQuestionObjective;
    }
    @OneToOne( optional = true )
    @JoinTable( name = "QUESTION_CATEGORY",
                schema = "VINAVIDAI", 
                joinColumns = {
                    @JoinColumn( name = "QUESTION_ID",
                                 unique = true )
                },
                inverseJoinColumns = {
                    @JoinColumn( name = "CATEGORY_ID" )
                }
    )
    public Category getCategory() {
        return mCategory;
    }
    public void setCategory( Category pCategory ) {
        mCategory = pCategory;
    }
    @OneToOne( optional = true )
    @JoinTable( name = "QUESTION_SKILL_LEVEL",
                schema = "VINAVIDAI",
                joinColumns = {
                    @JoinColumn( name = "QUESTION_ID",
                                 unique = true )
                },
                inverseJoinColumns = {
                    @JoinColumn( name = "SKILL_LEVEL_ID" )
                }
    )
    public SkillLevel getSkillLevel() {
        return mSkillLevel;
    }
    public void setSkillLevel( SkillLevel pSkillLevel ) {
        mSkillLevel = pSkillLevel;
    }
    @Column( name = "OPTION_TYPE" )
    public OptionType getOptionType() {
        return mOptionType;
    }
    public void setOptionType( OptionType pOptionType ) {
        mOptionType = pOptionType;
    }

    @OneToMany( targetEntity = org.ahp.vinavidai.pojo.Option.class,
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    @JoinColumns(
        { @JoinColumn( name = "QUIZ_ID",
                       referencedColumnName = "QUIZ_ID",
                       updatable = false
                      ),
          @JoinColumn( name = "QUESTION_ID",
                       referencedColumnName = "QUESTION_ID",
                       updatable = false )
        }
    )
    @MapKey()
    public Map<Long,Option> getOption() {
        return mOption;
    }
    public void setOption( Map<Long,Option> pOption ) {
        mOption = pOption;
    }
    @Column( name = "QUESTION_ORDER" )
    public int getQuestionOrder() {
        return mQuestionOrder;
    }
    public void setQuestionOrder( int pQuestionOrder ) {
        mQuestionOrder = pQuestionOrder;
    }
    @Column( name = "QUESTION_POINTS" )
    public int getPoints() {
        return mPoints;
    }
    public void setPoints( int pPoints ) {
        mPoints = pPoints;
    }
    

    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
}
