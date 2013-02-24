package org.ahp.vinavidai.dao;

import java.util.List;

import org.ahp.core.pojo.User;
import org.ahp.vinavidai.pojo.Category;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.pojo.SkillLevel;
import org.ahp.vinavidai.pojo.UserQuiz;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public interface IQuizDAO {
	
    /**
	 * 
	 * @param pQuiz
	 */
	public void createQuiz( Quiz pQuiz );
	
	/**
	 * 
	 * @param pQuizId
	 * @return
	 */
	public Quiz loadQuiz( Long pQuizId );
	
	/**
	 * 
	 * @param pQuiz
	 */
	public void updateQuiz( Quiz pQuiz );
	
	/**
	 * 
	 * @param pQuiz
	 */
	public void deleteQuiz( Quiz pQuiz );
	
	/**
	 * 
	 * @return
	 */
	public List<String> getAllCategoryNames( Quiz pQuiz );
	
	/**
	 * 
	 * @return
	 */
	public List<String> getAllSkillLevelNames( Quiz pQuiz );
	
	/**
     * 
     * @return
     */
    public List<String> getAllCategoryNames( User pUser );
    
    /**
     * 
     * @return
     */
    public List<String> getAllSkillLevelNames( User pUser );
    
	/**
     * 
     * @return
     */
    public List<Category> getAllCategories( Quiz pQuiz );
    
    /**
     * 
     * @return
     */
    public List<SkillLevel> getAllSkillLevels( Quiz pQuiz );
    
    /**
     * 
     * @param pUser
     * @return
     */
    public List<UserQuiz> getUserQuiz( User pUser );
}
