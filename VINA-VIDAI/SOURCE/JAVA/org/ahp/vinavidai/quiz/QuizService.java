package org.ahp.vinavidai.quiz;

import java.util.List;

import org.ahp.commons.businessdelegate.AhpAbstractBusinessDelegate;
import org.ahp.core.pojo.User;
import org.ahp.vinavidai.dao.IQuizDAO;
import org.ahp.vinavidai.enums.Status;
import org.ahp.vinavidai.pojo.Category;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.pojo.SkillLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 * @spring.bean
 *     id="quizService"
 * 
 * @spring.property
 *     name="quizDAO"
 *     ref="quizDAO" 
 */
public class QuizService extends AhpAbstractBusinessDelegate {
    
    final static Logger LOGGER = LoggerFactory.getLogger( QuizService.class );
    
    private IQuizDAO mQuizDAO;
    
    public void setQuizDAO( IQuizDAO pQuizDAO ){
        mQuizDAO = pQuizDAO;
    }
    
    /**
     * 
     * @param pQuiz
     */
    public void createQuiz( Quiz pQuiz ){
        if ( pQuiz.getStatus() == null ) {
            pQuiz.setStatus( Status.Disabled );
        }        
        this.mQuizDAO.createQuiz( pQuiz );
    }
    
    /**
     * 
     * @return
     */
    public List<String> getAllCategoryNames( Quiz pQuiz ) {
        return this.mQuizDAO.getAllCategoryNames( pQuiz );
    }

    /**
     * 
     * @return
     */
    public List<String> getAllSkillLevelNames( Quiz pQuiz ) {
        return this.mQuizDAO.getAllSkillLevelNames( pQuiz );
    }
    
    /**
     * 
     * @return
     */
    public List<String> getAllCategoryNames( User pUser) {
        return this.mQuizDAO.getAllCategoryNames( pUser );
    }

    /**
     * 
     * @return
     */
    public List<String> getAllSkillLevelNames( User pUser ) {
        return this.mQuizDAO.getAllSkillLevelNames( pUser );
    }
    
    /**
     * 
     * @return
     */
    public List<Category> getAllCategories( Quiz pQuiz ) {
        return this.mQuizDAO.getAllCategories( pQuiz );
    }

    /**
     * 
     * @return
     */
    public List<SkillLevel> getAllSkillLevels( Quiz pQuiz  ) {
        return this.mQuizDAO.getAllSkillLevels( pQuiz );
    }
    
}
