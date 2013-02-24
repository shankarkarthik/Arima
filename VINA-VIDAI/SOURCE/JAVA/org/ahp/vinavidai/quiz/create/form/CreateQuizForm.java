package org.ahp.vinavidai.quiz.create.form;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.ahp.commons.form.AhpAbstractForm;
import org.ahp.vinavidai.enums.SubmitActions;
import org.ahp.vinavidai.validator.QuizValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shankar Karthik Vaithianathan
 * 
 * @struts.form name="CreateQuizForm" 
 */
public class CreateQuizForm extends AhpAbstractForm {

    private static final long serialVersionUID = 1L;

    final static Logger LOGGER = LoggerFactory.getLogger( CreateQuizForm.class );
    
    // Form Fields
    private String mQuizName;
    private String mQuizDescription;
    private String mQuizDuration;
    private String mResponseDuration;
    private String[] mCategories;
    private String[] mSkillLevels;
    private String mSelectedListStyle;
    private String mSelectedDisplayStyle;
    
    // For Display
    private String mCategoriesAutoComplete;
    private String mSkillLevelsAutoComplete;
    private Set<String> mListStyleSet;
    private Set<String> mDisplayStyleSet;
        
    @Override
    protected void resetForm( ActionMapping pActionMapping,
                              HttpServletRequest pHttpServletRequest ) {
    }

    @Override
    public ActionErrors validate( ActionMapping pActionMapping,
                                     HttpServletRequest pHttpServletRequest ) {
        ActionErrors lActionErrors = new ActionErrors();
        String lSubmitAction = StringUtils.trimToNull( this.getSubmitAction() );
        if ( lSubmitAction != null && SubmitActions.NEXT.toString().equals( ( lSubmitAction ) ) ){
            QuizValidator.validateCreateQuizForm( this, lActionErrors );    
        }
        return lActionErrors;
    }

    public String getQuizName() {
        return mQuizName;
    }

    public void setQuizName( String pQuizName ) {
        mQuizName = pQuizName;
    }

    public String getQuizDescription() {
        return mQuizDescription;
    }

    public void setQuizDescription( String pQuizDescription ) {
        mQuizDescription = pQuizDescription;
    }

    public String getQuizDuration() {
        return mQuizDuration;
    }

    public void setQuizDuration( String pQuizDuration ) {
        mQuizDuration = pQuizDuration;
    }

    public String getResponseDuration() {
        return mResponseDuration;
    }

    public void setResponseDuration( String pResponseDuration ) {
        mResponseDuration = pResponseDuration;
    }

    public String[] getCategories() {
        return mCategories;
    }

    public void setCategories( String[] pCategories ) {
        mCategories = pCategories;
    }

    public String[] getSkillLevels() {
        return mSkillLevels;
    }

    public void setSkillLevels( String[] pSkillLevels ) {
        mSkillLevels = pSkillLevels;
    }

    public String getSelectedListStyle() {
        return mSelectedListStyle;
    }

    public void setSelectedListStyle( String pSelectedListStyle ) {
        mSelectedListStyle = pSelectedListStyle;
    }

    public String getSelectedDisplayStyle() {
        return mSelectedDisplayStyle;
    }

    public void setSelectedDisplayStyle( String pSelectedDisplayStyle ) {
        mSelectedDisplayStyle = pSelectedDisplayStyle;
    }

    public Set<String> getListStyleSet() {
        return mListStyleSet;
    }

    public void setListStyleSet( Set<String> pListStyleSet ) {
        mListStyleSet = pListStyleSet;
    }

    public Set<String> getDisplayStyleSet() {
        return mDisplayStyleSet;
    }

    public void setDisplayStyleSet( Set<String> pDisplayStyleSet ) {
        mDisplayStyleSet = pDisplayStyleSet;
    }

    public String getCategoriesAutoComplete() {
        return mCategoriesAutoComplete;
    }

    public void setCategoriesAutoComplete( String pCategoriesAutoComplete ) {
        mCategoriesAutoComplete = pCategoriesAutoComplete;
    }

    public String getSkillLevelsAutoComplete() {
        return mSkillLevelsAutoComplete;
    }

    public void setSkillLevelsAutoComplete( String pSkillLevelsAutoComplete ) {
        mSkillLevelsAutoComplete = pSkillLevelsAutoComplete;
    }
    
}
