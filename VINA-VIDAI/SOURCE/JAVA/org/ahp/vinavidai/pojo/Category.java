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
@Table( name = "CATEGORY",
        schema = "VINAVIDAI" )
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long mCategoryId;
    private Long mQuizId;
    private String mCategory;
    
    @Id
    @GeneratedValue
    @Column( name = "CATEGORY_ID" )
    public Long getCategoryId() {
        return mCategoryId;
    }
    public void setCategoryId( Long pCategoryId ) {
        mCategoryId = pCategoryId;
    }
    @Column( name = "QUIZ_ID" )
    public Long getQuizId() {
        return mQuizId;
    }
    public void setQuizId( Long pQuizId ) {
        mQuizId = pQuizId;
    }    
    @Column( name = "CATEGORY" )
    public String getCategory() {
        return mCategory;
    }
    public void setCategory( String pCategory ) {
        mCategory = pCategory;
    }

    /**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }

}
