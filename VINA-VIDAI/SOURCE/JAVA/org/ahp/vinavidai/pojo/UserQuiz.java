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
@Table( name = "USER_QUIZ",
        schema = "VINAVIDAI" )
public class UserQuiz extends BaseEntity implements Serializable {

    /** */
    private static final long serialVersionUID = 1L;

    private Long mUserQuizId;
    private long mUserId;
    private long mQuizId;

    @Id
    @GeneratedValue
    @Column( name = "USER_QUIZ_ID" )
    public Long getUserQuizId() {
        return mUserQuizId;
    }
    public void setUserQuizId( Long pUserQuizId ) {
        mUserQuizId = pUserQuizId;
    }        
    @Column( name = "USER_ID" )
    public long getUserId() {
        return mUserId;
    }
    public void setUserId( long pUserId ) {
        mUserId = pUserId;
    }
    @Column( name = "QUIZ_ID" )
    public long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( long pQuizId ) {
        mQuizId = pQuizId;
    }

    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
}