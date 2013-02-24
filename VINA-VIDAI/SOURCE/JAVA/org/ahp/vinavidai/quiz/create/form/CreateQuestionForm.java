package org.ahp.vinavidai.quiz.create.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ahp.commons.form.AhpAbstractForm;
import org.ahp.vinavidai.pojo.Category;
import org.ahp.vinavidai.pojo.SkillLevel;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shankar Karthik Vaithianathan
 * 
 * @struts.form name="CreateQuestionForm" 
 */
public class CreateQuestionForm extends AhpAbstractForm {

    private static final long serialVersionUID = 1L;

    final static Logger LOGGER = LoggerFactory.getLogger( CreateQuestionForm.class );
    
    private String mQuestionDescription;
    private String mQuestionObjective;
    private String mSelectedQuestionCategory;
    private String mSelectedQuestionSkillLevel;
    private int mDuration;
    private List<Category> mCategories;
    private List<SkillLevel> mSkillLevels;   

    @Override
    protected void resetForm( ActionMapping pActionMapping,
                              HttpServletRequest pHttpServletRequest ) {
    }

    @Override
    public ActionErrors validate( ActionMapping pActionMapping,
                                     HttpServletRequest pHttpServletRequest ) {
        return null;
    }

    public String getQuestionDescription() {
        return mQuestionDescription;
    }

    public void setQuestionDescription( String pQuestionDescription ) {
        mQuestionDescription = pQuestionDescription;
    }

    public String getQuestionObjective() {
        return mQuestionObjective;
    }

    public void setQuestionObjective( String pQuestionObjective ) {
        mQuestionObjective = pQuestionObjective;
    }

    public String getSelectedQuestionCategory() {
        return mSelectedQuestionCategory;
    }

    public void setSelectedQuestionCategory( String pSelectedQuestionCategory ) {
        mSelectedQuestionCategory = pSelectedQuestionCategory;
    }

    public String getSelectedQuestionSkillLevel() {
        return mSelectedQuestionSkillLevel;
    }

    public void setSelectedQuestionSkillLevel( String pSelectedQuestionSkillLevel ) {
        mSelectedQuestionSkillLevel = pSelectedQuestionSkillLevel;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration( int pDuration ) {
        mDuration = pDuration;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories( List<Category> pCategories ) {
        mCategories = pCategories;
    }

    public List<SkillLevel> getSkillLevels() {
        return mSkillLevels;
    }

    public void setSkillLevels( List<SkillLevel> pSkillLevels ) {
        mSkillLevels = pSkillLevels;
    }
    

}
