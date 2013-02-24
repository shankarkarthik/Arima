package org.ahp.vinavidai.validator;

import java.util.LinkedHashSet;
import java.util.Set;

import org.ahp.commons.validator.AbstractValidator;
import org.ahp.commons.validator.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionErrors;

public class BaseValidator extends AbstractValidator {

    public static final String CREATE_QUIZ_ERROR_KEY_PREFIX = "quiz.create";
    public static final String EDIT_QUIZ_ERROR_KEY_PREFIX = "quiz.edit";
    public static final String CREATE_QUESTION_ERROR_KEY_PREFIX = "question.create";
    public static final String EDIT_QUESTION_ERROR_KEY_PREFIX = "question.edit";
    
    /**
     * 
     * @param pQuizName
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuizName( String pQuizName, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( pQuizName == null || "".equals( pQuizName ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".name.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if ( !ValidatorUtil.isAlphaNumeric( pQuizName ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".name.invalid" );
        }
        AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
    }
    
    /**
     * 
     * @param pQuizDescription
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuizDescription( String pQuizDescription, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if ( pQuizDescription == null || "".equals( pQuizDescription ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".description.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
    }
    
    /**
     * 
     * @param pQuizDuration
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuizDuration( String pQuizDuration, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if( StringUtils.trimToNull( pQuizDuration ) != null ){
            if ( !ValidatorUtil.isNumeric( pQuizDuration ) ) {
                lErrorKeySet.add( pErrorKeyPrefix + ".quizduration.invalid" );
            }
        }
        AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
    }
    
    /**
     * 
     * @param pQuestionDuration
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuestionDuration( String pQuestionDuration, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        if( StringUtils.trimToNull( pQuestionDuration ) != null ){
            if ( !ValidatorUtil.isNumeric( pQuestionDuration ) ) {
                lErrorKeySet.add( pErrorKeyPrefix + ".questionduration.invalid" );
            }
        }
        AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
    }
    
    /**
     * 
     * @param pQuizCategories
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuizCategories( String[] pQuizCategories, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        Set<String> lReplacementTokensSet = new LinkedHashSet<String>();
        if ( pQuizCategories == null || ( pQuizCategories != null && pQuizCategories.length == 0 ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".category.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if ( pQuizCategories != null && pQuizCategories.length != 0 ) {
            for ( String lCategory : pQuizCategories ) {
                if ( !ValidatorUtil.isAlphaNumeric( lCategory ) ) {
                    lReplacementTokensSet.add( lCategory );
                }
            }
            AbstractValidator.populateActionErrorsWithReplacementTokens( pActionErrors, pErrorKeyPrefix + ".category.invalid", lReplacementTokensSet );
        }
    }
    
    /**
     * 
     * @param pQuizSkillLevels
     * @param pActionErrors
     * @param pErrorKeyPrefix
     */
    @SuppressWarnings( "unchecked" )
    public static void validateQuizSkillLevels( String[] pQuizSkillLevels, ActionErrors pActionErrors, String pErrorKeyPrefix ){
        Set<String> lErrorKeySet = new LinkedHashSet<String>();
        Set<String> lReplacementTokensSet = new LinkedHashSet<String>();
        if ( pQuizSkillLevels == null || ( pQuizSkillLevels != null && pQuizSkillLevels.length == 0 ) ) {
            lErrorKeySet.add( pErrorKeyPrefix + ".skilllevel.required" );
            AbstractValidator.populateActionErrors( pActionErrors, lErrorKeySet );
            return;
        }
        if ( pQuizSkillLevels != null && pQuizSkillLevels.length != 0 ) {
            for ( String lQuizSkillLevel : pQuizSkillLevels ) {
                if ( !ValidatorUtil.isAlphaNumeric( lQuizSkillLevel ) ) {
                    lReplacementTokensSet.add( lQuizSkillLevel );
                }
            }
            AbstractValidator.populateActionErrorsWithReplacementTokens( pActionErrors, pErrorKeyPrefix + ".skilllevel.invalid", lReplacementTokensSet );
        }
    }
}
