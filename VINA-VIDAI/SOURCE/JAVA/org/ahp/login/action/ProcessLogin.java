package org.ahp.login.action;

import static org.ahp.core.constants.HttpSessionAttributeConstants.LOGGED_IN_USER;
import static org.ahp.core.constants.HttpSessionAttributeConstants.LOGGED_IN_USER_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractProcessAction;
import org.ahp.core.pojo.User;
import org.ahp.login.LoginService;
import org.ahp.login.enums.NavigateActions;
import org.ahp.login.enums.SubmitActions;
import org.ahp.login.form.LoginForm;
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
 *      path="/ProcessLogin"
 *      name="LoginForm"
 *      input="/login/Login.jsp"
 *      scope="session"
 *      validate="true"
 *    
 * @struts.action-forward
 *      name="DisplayLogin"
 *      path="/DisplayLogin.do"
 *      redirect="false"
 *      
 * @spring.bean
 *     name="/ProcessLogin"
 * 
 * @spring.property
 *     name="loginService"
 *     ref="loginService" 
 * 
 */
public class ProcessLogin extends AhpAbstractProcessAction {

    final static Logger LOGGER = LoggerFactory.getLogger( ProcessLogin.class );
    
    LoginService mLoginService;
    
    public void setLoginService( LoginService pLoginService ){
        this.mLoginService = pLoginService;
    }
    
    @Override
    public ActionForward process( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
        LoginForm lLoginForm = ( LoginForm ) pActionForm;
        String lSubmitAction = StringUtils.trimToNull( lLoginForm.getSubmitAction() );
        if ( lSubmitAction != null ){
            if ( SubmitActions.LOGIN.toString().equals( lSubmitAction ) ){
                String lLoginName = lLoginForm.getLoginName();
                String lPassword = lLoginForm.getPassword();
                boolean lAuthenticated = mLoginService.isUserAuthenticated( lLoginName, lPassword );
                boolean lPasswordExpired = mLoginService.hasPasswordExpired(lLoginName);
                if ( lAuthenticated && !lPasswordExpired)
                {
                    LOGGER.debug( "Login Successful" );
                    User lUser = mLoginService.loadUserByLoginName( lLoginName );
                    pHttpServletRequest.getSession().setAttribute( LOGGED_IN_USER, lUser );
                    lLoginForm.setNextPage( NavigateActions.DisplayHomePage.toString() );
                }
                else if(lPasswordExpired )
                {
                	LOGGER.debug( "Password Reset Required" );
                	pHttpServletRequest.getSession().setAttribute(LOGGED_IN_USER_NAME, lLoginName );
                	lLoginForm.setNextPage(NavigateActions.DisplayResetPassword.toString());
                }
            }
        }
        return pActionMapping.findForward( NavigateActions.DisplayLogin.toString() );
    }

}
