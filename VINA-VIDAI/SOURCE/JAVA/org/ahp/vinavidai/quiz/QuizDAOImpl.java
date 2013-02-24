package org.ahp.vinavidai.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ahp.core.pojo.User;
import org.ahp.vinavidai.dao.IQuizDAO;
import org.ahp.vinavidai.pojo.Category;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.pojo.QuizConfig;
import org.ahp.vinavidai.pojo.SkillLevel;
import org.ahp.vinavidai.pojo.UserQuiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 * @spring.bean
 *     id="quizDAO"
 *       
 */
public class QuizDAOImpl implements IQuizDAO {
	
    final static Logger LOGGER = LoggerFactory.getLogger( QuizDAOImpl.class );
    
    @PersistenceContext
    private EntityManager mEntityManager;

    final String GET_ALL_CATEGORIES_BY_USER = 
        " select category.category from vinavidai.category, vinavidai.quiz, vinavidai.user, vinavidai.user_quiz "+ 
        " where user.login_name = ? " +
        " and user_quiz.user_id = user.user_id " +
        " and user_quiz.quiz_id = quiz.quiz_id " +
        " and category.quiz_id = quiz.quiz_id ";

    final String GET_ALL_SKILL_LEVELS_BY_USER = 
        " select skill_level.skill_level from vinavidai.skill_level, vinavidai.quiz, vinavidai.user, vinavidai.user_quiz "+ 
        " where user.login_name = ? " +
        " and user_quiz.user_id = user.user_id " +
        " and user_quiz.quiz_id = quiz.quiz_id " +
        " and skill_level.quiz_id = quiz.quiz_id ";
 
    /**
     * @return pQuiz
     */
    public void createQuiz( Quiz pQuiz ){
        mEntityManager.persist( pQuiz );
        for ( Category lCategory : pQuiz.getCategorySet() ) {
            lCategory.setQuizId( pQuiz.getQuizId() );
            this.mEntityManager.persist( lCategory );
        }
        for ( SkillLevel lSkillLevel : pQuiz.getSkillLevelSet() ) {
            lSkillLevel.setQuizId( pQuiz.getQuizId() );
            this.mEntityManager.persist( lSkillLevel );
        }
        for ( QuizConfig lQuizConfig : pQuiz.getQuizConfigSet() ) {
            lQuizConfig.setQuizId( pQuiz.getQuizId() );
            this.mEntityManager.persist( lQuizConfig );
        }	    
	}
	
	/**
	 * 
	 */
	public Quiz loadQuiz( Long pQuizId ){
	    return ( Quiz ) mEntityManager.find( org.ahp.vinavidai.pojo.Quiz.class, pQuizId );
	}
	
	public void updateQuiz( Quiz pQuiz ){
	    mEntityManager.merge( pQuiz );
	}
	
	public void deleteQuiz( Quiz pQuiz ){
	    mEntityManager.remove( pQuiz );
	}
	
	public List<Quiz> loadQuizByUser( User pUser ){
	    /*Quiz lQuiz = ( Quiz ) mEntityManager.createQuery( "" ).find( org.vv.pojo.Quiz.class, new Long( "1" ) );
	    System.out.println( lQuiz );*/
        return null;
    }

    public List<String> getAllCategoryNames( Quiz pQuiz ) {
        Query lQuery = mEntityManager.createQuery( "SELECT DISTINCT categoryBean.category FROM Category categoryBean where categoryBean.quizId = ?1 ORDER BY categoryBean.category ASC" );
        lQuery.setParameter( 1, pQuiz.getQuizId() );
        List<String> lCategoryList = new ArrayList<String>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lCategoryList.add( ( String ) lResultListIterator.next() );
            }
        }
        return lCategoryList;
    }

    public List<String> getAllSkillLevelNames( Quiz pQuiz ) {
        Query lQuery = mEntityManager.createQuery( "SELECT DISTINCT skillLevelBean.skillLevel FROM SkillLevel skillLevelBean where skillLevelBean.quizId = ?1 ORDER BY skillLevelBean.skillLevel ASC" );
        lQuery.setParameter( 1, pQuiz.getQuizId() );
        List<String> lSkillLevelList = new ArrayList<String>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lSkillLevelList.add( ( String ) lResultListIterator.next() );
            }
        }
        return lSkillLevelList;
    }
    /**
     * 
     * @return
     */
    public List<String> getAllCategoryNames( User pUser ){
        Query lQuery = mEntityManager.createNativeQuery( GET_ALL_CATEGORIES_BY_USER );
        lQuery.setParameter( 1, pUser.getLoginName() );
        List lResultList = lQuery.getResultList();
        List<String> lCategoryList = new ArrayList<String>();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lCategoryList.add( ( String ) lResultListIterator.next() );
            }
        }
        return lCategoryList;
    }
    
    /**
     * 
     * @return
     */
    public List<String> getAllSkillLevelNames( User pUser ){
        Query lQuery = mEntityManager.createNativeQuery( GET_ALL_SKILL_LEVELS_BY_USER );
        lQuery.setParameter( 1, pUser.getLoginName() );
        List<String> lSkillLevelList = new ArrayList<String>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lSkillLevelList.add( ( String ) lResultListIterator.next() );
            }
        }
        return lSkillLevelList;
    }
    public List<Category> getAllCategories( Quiz pQuiz ) {
        Query lQuery = mEntityManager.createQuery( "SELECT categoryBean FROM Category categoryBean ORDER BY categoryBean.category ASC" );
        List<Category> lCategoryList = new ArrayList<Category>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lCategoryList.add( ( Category ) lResultListIterator.next() );
            }
        }
        return lCategoryList;
    }

    public List<SkillLevel> getAllSkillLevels( Quiz pQuiz ) {
        Query lQuery = mEntityManager.createQuery( "SELECT skillLevelBean FROM SkillLevel skillLevelBean ORDER BY skillLevelBean.skillLevel ASC" );
        List<SkillLevel> lSkillLevelList = new ArrayList<SkillLevel>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lSkillLevelList.add( ( SkillLevel ) lResultListIterator.next() );
            }
        }
        return lSkillLevelList;
    }

    public List<UserQuiz> getUserQuiz( User pUser ){
        Query lQuery = mEntityManager.createQuery( "SELECT userQuizBean FROM UserQuiz userQuizBean WHERE userQuizBean.userId = ?1 ORDER BY userQuizBean.quizId ASC" );
        lQuery.setParameter( 1, pUser.getUserId() );
        List<UserQuiz> lUserQuizList = new ArrayList<UserQuiz>();
        List lResultList = lQuery.getResultList();
        if( lResultList.size() != 0 ){
            Iterator lResultListIterator = lResultList.iterator();
            while( lResultListIterator.hasNext() ){
                lUserQuizList.add( ( UserQuiz ) lResultListIterator.next() );
            }
        }
        return lUserQuizList;
    }
}
