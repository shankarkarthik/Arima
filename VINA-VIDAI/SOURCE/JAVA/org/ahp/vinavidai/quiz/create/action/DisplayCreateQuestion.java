package org.ahp.vinavidai.quiz.create.action;

import static org.ahp.vinavidai.constants.HttpSessionAttributeConstants.QUIZ_UNDER_CREATION;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractDisplayAction;
import org.ahp.vinavidai.enums.NavigateActions;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.quiz.QuizService;
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
 *      path="/DisplayCreateQuestion"
 *      name="CreateQuestionForm"
 *      scope="session"
 *      validate="false"
 *    
 * @struts.action-forward
 *      name="DisplayCreateQuestionCompleted"
 *      path="/createQuiz/CreateQuizCompleted.jsp"
 *            
 * @struts.action-forward
 *      name="DisplayCreateQuestion"
 *      path="/createQuiz/CreateQuestion.jsp"
 * 
 * @spring.bean
 *     name="/DisplayCreateQuestion"
 * 
 * @spring.property
 *     name="quizService"
 *     ref="quizService"   
 */
public class DisplayCreateQuestion extends AhpAbstractDisplayAction {

    final static Logger LOGGER = LoggerFactory.getLogger( ProcessCreateQuestion.class );
    
    private QuizService mQuizService;
    
    public void setQuizService( QuizService pQuizService ){
        this.mQuizService = pQuizService;
    }

    @Override
    public ActionForward display( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
    	CreateQuestionForm lCreateQuestionForm = ( CreateQuestionForm ) pActionForm;
    	String lNextPage = StringUtils.trimToEmpty( lCreateQuestionForm.getNextPage() );
    	ActionForward lActionForward = pActionMapping.findForward( NavigateActions.DisplayCreateQuestion.toString() ); 
    	if ( NavigateActions.DisplayCreateQuestion.toString().equals( lNextPage ) ||
    	     NavigateActions.DisplayCreateQuestionNext.toString().equals( lNextPage ) ){
            Quiz lQuiz = ( Quiz ) pHttpServletRequest.getSession().getAttribute( QUIZ_UNDER_CREATION );
            lQuiz = new Quiz();
            lQuiz.setQuizId( new Long( 1 ) );
            lCreateQuestionForm.setCategories( mQuizService.getAllCategories( lQuiz ) );
            lCreateQuestionForm.setSkillLevels( mQuizService.getAllSkillLevels( lQuiz ) );
        }
    	if ( NavigateActions.DisplayCreateQuizCompleted.toString().equals( lNextPage ) ){
            Quiz lQuiz = ( Quiz ) pHttpServletRequest.getSession().getAttribute( QUIZ_UNDER_CREATION );
        }
        if ( NavigateActions.DisplayCreateQuizCancelled.toString().equals( lNextPage ) ){
            Quiz lQuiz = ( Quiz ) pHttpServletRequest.getSession().getAttribute( QUIZ_UNDER_CREATION );
        }
    	return lActionForward;
    }
}

