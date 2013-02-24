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
@Table( name = "OPTION",
        schema = "VINAVIDAI" )
public class Option extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private Long mOptionId;
	private Long mQuizId;
	private Long mQuestionId;
	private String mOptionDescription;
	private String mOptionJustification;
	private boolean mAnswer;
	
	@Id
    @GeneratedValue
	@Column( name = "OPTION_ID" )
    public Long getOptionId() {
        return mOptionId;
    }
    public void setOptionId( Long pOptionId ) {
        mOptionId = pOptionId;
    }
	@Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }
    @Column( name = "QUESTION_ID" )
    public Long getQuestionId() {
        return mQuestionId;
    }
    public void setQuestionId( Long pQuestionId ) {
        mQuestionId = pQuestionId;
    }
    @Column( name = "OPTION_DESCRIPTION" )
    public String getOptionDescription() {
        return mOptionDescription;
    }
    public void setOptionDescription( String pOptionDescription ) {
        mOptionDescription = pOptionDescription;
    }
    @Column( name = "OPTION_JUSTIFICATION" )
    public String getOptionJustification() {
        return mOptionJustification;
    }
    public void setOptionJustification( String pOptionJustification ) {
        mOptionJustification = pOptionJustification;
    }
    @Column( name = "IS_ANSWER" )
    public boolean isAnswer() {
        return mAnswer;
    }
    public void setAnswer( boolean pAnswer ) {
        mAnswer = pAnswer;
    }

    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
}