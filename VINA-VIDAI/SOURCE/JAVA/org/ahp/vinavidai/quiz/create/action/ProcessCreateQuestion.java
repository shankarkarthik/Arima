package org.ahp.vinavidai.quiz.create.action;


import static org.ahp.vinavidai.constants.HttpSessionAttributeConstants.QUIZ_UNDER_CREATION;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractProcessAction;
import org.ahp.vinavidai.enums.NavigateActions;
import org.ahp.vinavidai.enums.SubmitActions;
import org.ahp.vinavidai.quiz.create.form.CreateQuestionForm;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shankar Karthik Vaithianathan
 * 
 * @struts.action
 *      path="/ProcessCreateQuestion"
 *      name="CreateQuestionForm"
 *      input="/createQuiz/CreateQuestion.jsp"
 *      scope="session"
 *      validate="true"
 *    
 * @struts.action-forward
 *      name="DisplayCreateQuestion"
 *      path="/DisplayCreateQuestion.do"
 *      redirect="false"
 *  
 */
public class ProcessCreateQuestion extends AhpAbstractProcessAction {

    final static Logger LOGGER = LoggerFactory.getLogger( ProcessCreateQuestion.class );
    
    @Override
    public ActionForward process( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
    	CreateQuestionForm lCreateQuestionForm = ( CreateQuestionForm ) pActionForm;
    	String lSubmitAction = StringUtils.trimToNull( lCreateQuestionForm.getSubmitAction() );
    	if ( lSubmitAction != null ) {
    	    if ( SubmitActions.SAVE.equals( lSubmitAction ) ) {
    	        lCreateQuestionForm.setNextPage( NavigateActions.DisplayCreateQuestion.toString() );
    	        
    	        // Persist in DB
    	    }
    	    if ( SubmitActions.COMPLETE_QUIZ.equals( lSubmitAction ) ) {
                lCreateQuestionForm.setNextPage( NavigateActions.DisplayCreateQuizCompleted.toString() );
                
                pHttpServletRequest.getSession().setAttribute( QUIZ_UNDER_CREATION, null );
                // Persist in DB
            }
    	    if ( SubmitActions.CANCEL.equals( lSubmitAction ) ) {
                lCreateQuestionForm.setNextPage( NavigateActions.DisplayCreateQuestion.toString() );
                
                lCreateQuestionForm.setNextPage( NavigateActions.DisplayCreateQuizCancelled.toString() );
                // Persist in DB but make it Disabled.
            }
    	}
    	else {
    	    lCreateQuestionForm.setNextPage( NavigateActions.DisplayCreateQuestion.toString() );
    	}
        return pActionMapping.findForward( NavigateActions.DisplayCreateQuestion.toString() );
    }
    
}
