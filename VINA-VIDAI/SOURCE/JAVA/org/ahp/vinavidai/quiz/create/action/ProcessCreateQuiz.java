package org.ahp.vinavidai.quiz.create.action;


import static org.ahp.vinavidai.constants.HttpSessionAttributeConstants.QUIZ_UNDER_CREATION;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractProcessAction;
import org.ahp.vinavidai.enums.NavigateActions;
import org.ahp.vinavidai.enums.QuizConfigEnum;
import org.ahp.vinavidai.enums.SubmitActions;
import org.ahp.vinavidai.pojo.Category;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.pojo.QuizConfig;
import org.ahp.vinavidai.pojo.SkillLevel;
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
 *      path="/ProcessCreateQuiz"
 *      name="CreateQuizForm"
 *      input="/createQuiz/CreateQuiz.jsp"
 *      scope="session"
 *      validate="true"
 *    
 * @struts.action-forward
 *      name="DisplayCreateQuiz"
 *      path="/DisplayCreateQuiz.do"
 *      redirect="false"
 *      
 * @spring.bean
 *     name="/ProcessCreateQuiz"
 * 
 * @spring.property
 *     name="quizService"
 *     ref="quizService" 
 *  
 */
public class ProcessCreateQuiz extends AhpAbstractProcessAction {

    final static Logger LOGGER = LoggerFactory.getLogger( ProcessCreateQuiz.class );
    
    private QuizService mQuizService;
    
    public void setQuizService( QuizService pQuizService ){
        this.mQuizService = pQuizService;
    }
    
    @Override
    public ActionForward process( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
    	CreateQuizForm lCreateQuizForm = ( CreateQuizForm ) pActionForm;
    	String lSubmitAction = StringUtils.trimToNull( lCreateQuizForm.getSubmitAction() );
    	if ( lSubmitAction != null ) {
    	    if ( SubmitActions.NEXT.toString().equals( lSubmitAction ) ) {
    	        lCreateQuizForm.setNextPage( NavigateActions.DisplayCreateQuestion.toString() );
    	        Quiz lQuiz = this.storeQuiz( lCreateQuizForm );
    	        pHttpServletRequest.getSession().setAttribute( QUIZ_UNDER_CREATION, lQuiz );
    	    }
    	}
    	else {
    	    lCreateQuizForm.setNextPage( NavigateActions.DisplayCreateQuiz.toString() );
    	}
        return pActionMapping.findForward( NavigateActions.DisplayCreateQuiz.toString() );
    }
    
    /**
     * 
     * @param pCreateQuizForm
     * @return
     */
    private Quiz storeQuiz( CreateQuizForm pCreateQuizForm ){
        Quiz lQuiz = new Quiz();
        lQuiz.setName( pCreateQuizForm.getQuizName() );
        lQuiz.setDescription( pCreateQuizForm.getQuizDescription() );
        Set<Category> lCategorySet = new LinkedHashSet<Category>();
        for ( String lCategoryStr : pCreateQuizForm.getCategories() ) {
            Category lCategory = new Category();
            lCategory.setCategory( lCategoryStr );
            lCategorySet.add( lCategory );
        }
        lQuiz.setCategorySet( lCategorySet );
        
        Set<SkillLevel> lSkillLevelSet = new LinkedHashSet<SkillLevel>();
        for ( String lSkillLevelStr : pCreateQuizForm.getSkillLevels() ) {
            SkillLevel lSkillLevel = new SkillLevel(); 
            lSkillLevel.setSkillLevel( lSkillLevelStr );
            lSkillLevelSet.add( lSkillLevel );
        }
        lQuiz.setSkillLevelSet( lSkillLevelSet );
        
        // All optional fields go to QuizConfig
        Set<QuizConfig> lQuizConfigSet = new LinkedHashSet<QuizConfig>();
        QuizConfig lQuizDurationConfig = new QuizConfig();
        lQuizDurationConfig.setConfigName( QuizConfigEnum.QuizDuration.toString() );
        lQuizDurationConfig.setConfigValue( pCreateQuizForm.getQuizDuration() );
        lQuizConfigSet.add( lQuizDurationConfig );
        
        QuizConfig lQuestionDurationConfig = new QuizConfig();
        lQuestionDurationConfig.setConfigName( QuizConfigEnum.QuestionResponseDuration.toString() );
        lQuestionDurationConfig.setConfigValue( pCreateQuizForm.getResponseDuration() );
        lQuizConfigSet.add( lQuestionDurationConfig );
        
        QuizConfig lListStykeConfig = new QuizConfig();
        lListStykeConfig.setConfigName( QuizConfigEnum.QuestionListStyle.toString() );
        lListStykeConfig.setConfigValue( pCreateQuizForm.getSelectedListStyle() );
        lQuizConfigSet.add( lListStykeConfig );
        
        QuizConfig lListDisplayStyleConfig = new QuizConfig();
        lListDisplayStyleConfig.setConfigName( QuizConfigEnum.QuestionDisplayStyle.toString() );
        lListDisplayStyleConfig.setConfigValue( pCreateQuizForm.getSelectedDisplayStyle() );
        lQuizConfigSet.add( lListDisplayStyleConfig );
        lQuiz.setQuizConfigSet( lQuizConfigSet );
        
        this.mQuizService.createQuiz( lQuiz );
        
        LOGGER.debug( "Created Quiz with Id: " + lQuiz.getQuizId() );
        System.out.println( "Created Quiz with Id: " + lQuiz.getQuizId() );
        return lQuiz;
    }

}

