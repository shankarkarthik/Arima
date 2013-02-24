package org.ahp.vinavidai.quiz.create.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractDisplayAction;
import org.ahp.commons.util.AhpStringUtil;
import org.ahp.core.actions.AhpActionHelper;
import org.ahp.core.pojo.User;
import org.ahp.vinavidai.enums.DisplayStyle;
import org.ahp.vinavidai.enums.EnumWrapper;
import org.ahp.vinavidai.enums.ListStyle;
import org.ahp.vinavidai.enums.NavigateActions;
import org.ahp.vinavidai.quiz.QuizService;
import org.ahp.vinavidai.quiz.create.form.CreateQuizForm;
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
 *      path="/DisplayCreateQuiz"
 *      name="CreateQuizForm"
 *      scope="session"
 *      validate="false"
 *    
 * @struts.action-forward
 *      name="DisplayCreateQuiz"
 *      path="/createQuiz/CreateQuiz.jsp"
 *      
 * @struts.action-forward
 *      name="DisplayCreateQuestion"
 *      path="/ProcessCreateQuestion.do"
 *      redirect="true"
 *   
 * @spring.bean
 *     name="/DisplayCreateQuiz"
 * 
 * @spring.property
 *     name="quizService"
 *     ref="quizService"
 *      
 */
public class DisplayCreateQuiz extends AhpAbstractDisplayAction {

    final static Logger LOGGER = LoggerFactory.getLogger( DisplayCreateQuiz.class );
    
    private QuizService mQuizService;
    
    public void setQuizService( QuizService pQuizService ){
        this.mQuizService = pQuizService;
    }
    
    @Override
    public ActionForward display( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
        User lLoggedInUser = AhpActionHelper.getLoggedInUser( pHttpServletRequest );
    	CreateQuizForm lCreateQuizForm = ( CreateQuizForm ) pActionForm;
    	String lNextPage = StringUtils.trimToEmpty( lCreateQuizForm.getNextPage() );
    	ActionForward lActionForward = pActionMapping.findForward( NavigateActions.DisplayCreateQuiz.toString() ); 
    	if ( NavigateActions.DisplayCreateQuiz.toString().equals( lNextPage ) ){
    	    lCreateQuizForm.setListStyleSet( EnumWrapper.enumerateListStyle() );
    	    lCreateQuizForm.setDisplayStyleSet( EnumWrapper.enumerateDisplayStyle() );
    	    lCreateQuizForm.setCategoriesAutoComplete( AhpStringUtil.listToString( this.mQuizService.getAllCategoryNames( lLoggedInUser ) ) );
    	    lCreateQuizForm.setSkillLevelsAutoComplete( AhpStringUtil.listToString( this.mQuizService.getAllSkillLevelNames( lLoggedInUser ) ) );
    	    lCreateQuizForm.setSelectedListStyle( ListStyle.Numeric.toString() );
    	    lCreateQuizForm.setSelectedDisplayStyle( DisplayStyle.Dot.toString() );
    		lActionForward = pActionMapping.findForward( NavigateActions.DisplayCreateQuiz.toString() );
    	}
    	if ( NavigateActions.DisplayCreateQuestion.toString().equals( lNextPage ) ){
            lActionForward = pActionMapping.findForward( NavigateActions.DisplayCreateQuestion.toString() );
        }
    	return lActionForward;
    }
}
