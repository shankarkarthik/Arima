package org.ahp.login.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ahp.core.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 * 
 * @spring.bean
 *     id="loginDAO"
 *
 */
public class LoginDAOImpl implements ILoginDAO {
	
    final static Logger LOGGER = LoggerFactory.getLogger( LoginDAOImpl.class );
    
    private EntityManager mEntityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.mEntityManager = entityManager;
    }
    
    /**
     * 
     * @param pLoginName
     * @return
     */
	public User loadUserByLoginName( String pLoginName ){
        return ( User ) mEntityManager.createQuery( "SELECT user FROM User user WHERE LOWER(user.loginName) like LOWER('%" + pLoginName + "%')" ).getSingleResult();       	    
	}
	
	/**
	 * 
	 * @param pLoginId
	 * @return
	 */
	public User loadUserByLoginId( Long pLoginId ){
	    return ( User ) mEntityManager.find( User.class, pLoginId );	    
	}
	
	/**
	 * 
	 * DOCUMENT ME!
	 * @param pLoginName
	 * @return
	 */
	public Date getPasswordExpiryDate(String pLoginName)
	{
		return (Date) mEntityManager.createQuery( "SELECT user.passwordExpiryDate FROM User user WHERE user.loginName = '" + pLoginName + "'").getSingleResult();
	}
}
