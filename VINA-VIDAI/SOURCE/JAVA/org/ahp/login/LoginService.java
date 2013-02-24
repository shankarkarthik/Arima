package org.ahp.login;

import java.sql.Date;

import org.ahp.commons.businessdelegate.AhpAbstractBusinessDelegate;
import org.ahp.commons.util.AhpDateUtil;
import org.ahp.core.pojo.User;
import org.ahp.login.dao.ILoginDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 * @spring.bean
 *     id="loginService"
 * 
 * @spring.property
 *     name="loginDAO"
 *     ref="loginDAO" 
 */
public class LoginService extends AhpAbstractBusinessDelegate {
    
    final static Logger LOGGER = LoggerFactory.getLogger( LoginService.class );
    
    private ILoginDAO mLoginDAO;
    
    public void setLoginDAO( ILoginDAO pLoginDAO ){
        mLoginDAO = pLoginDAO;
    }
    
    public boolean isUserAuthenticated( String pLoginName, String pPassword ){
        User lUser = mLoginDAO.loadUserByLoginName( pLoginName );
        if ( lUser != null ){
            if ( lUser.getPassword().equals( pPassword ) ){
                return true;                
            }
        }
        return false;
    }
    
    public boolean doesUserExist( String pLoginName ){
        User lUser = mLoginDAO.loadUserByLoginName( pLoginName );
        if ( lUser != null ){
            return true;
        }
        return false;
    }
    /**
     * 
     * @param pLoginName
     * @return
     */
    public User loadUserByLoginName( String pLoginName ){
        return mLoginDAO.loadUserByLoginName( pLoginName );            
    }
    
    /**
     * 
     * @param pLoginName
     * @return
     */
    public User loadUserByLoginId( long pLoginId ){
        return mLoginDAO.loadUserByLoginId( pLoginId );               
    }
    
    /**
     * 
     * DOCUMENT ME!
     * @param pNewPassword
     * @param pConfirmPassword
     * @return
     */
    public boolean isPasswordMatched(String pNewPassword,String pConfirmPassword)
    {
    	if(pNewPassword.equals(pConfirmPassword))
    	{
    	  return true;
    	}
    	
    	return false;
    }

	public boolean hasPasswordExpired(String pLoginName) 
	{
		Date lPasswordExpiryDate = mLoginDAO.getPasswordExpiryDate(pLoginName);
		if(lPasswordExpiryDate != null)
		{ 
		    return AhpDateUtil.checkForDateExpiry(lPasswordExpiryDate);
		}
		return true;
	}
}
