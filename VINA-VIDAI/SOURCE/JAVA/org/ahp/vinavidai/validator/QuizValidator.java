package org.ahp.vinavidai.validator;

import org.ahp.vinavidai.quiz.create.form.CreateQuizForm;
import org.apache.struts.action.ActionErrors;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public final class QuizValidator extends BaseValidator {

    /**
     * 
     * @param pCreateQuizForm
     * @param pActionErrors
     */
    public static void validateCreateQuizForm( CreateQuizForm pCreateQuizForm, ActionErrors pActionErrors ) {
        BaseValidator.validateQuizName( pCreateQuizForm.getQuizName(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
        BaseValidator.validateQuizDescription( pCreateQuizForm.getQuizDescription(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
        BaseValidator.validateQuizDuration( pCreateQuizForm.getQuizDuration(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
        BaseValidator.validateQuestionDuration( pCreateQuizForm.getResponseDuration(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
        BaseValidator.validateQuizCategories( pCreateQuizForm.getCategories(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
        BaseValidator.validateQuizSkillLevels( pCreateQuizForm.getSkillLevels(), pActionErrors, BaseValidator.CREATE_QUIZ_ERROR_KEY_PREFIX );
    }

}
