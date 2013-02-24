package org.ahp.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.ahp.core.constants.HttpSessionAttributeConstants.LOGGED_IN_USER;
import static org.ahp.core.constants.HttpSessionAttributeConstants.LOGGED_IN_USER_NAME;
import org.ahp.commons.action.AhpAbstractProcessAction;
import org.ahp.core.pojo.User;
import org.ahp.login.LoginService;
import org.ahp.login.enums.NavigateActions;
import org.ahp.login.enums.SubmitActions;
import org.ahp.login.form.ResetPasswordForm;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anita
 * 
 * @struts.action
 *      path="/ProcessResetPassword"
 *      name="ResetPasswordForm"
 *      scope="session"
 *      validate="true"
 *    
 * @struts.action-forward
 *      name="DisplayResetPassword"
 *      path="/DisplayResetPassword.do"
 *      redirect="false"
 *      
 * @spring.bean
 *     name="/ProcessResetPassword"
 *   
 */

public class ProcessResetPassword extends AhpAbstractProcessAction 
{

    final static Logger LOGGER = LoggerFactory.getLogger( ProcessResetPassword.class );
    
    LoginService mLoginService;
    
    public void setLoginService( LoginService pLoginService ){
        this.mLoginService = pLoginService;
    }
       
    @Override
    public ActionForward process( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) 
    {
        ResetPasswordForm lResetPasswordForm = ( ResetPasswordForm ) pActionForm;
        String lSubmitAction = StringUtils.trimToNull( lResetPasswordForm.getSubmitAction() );
        if ( lSubmitAction != null ){
            if ( SubmitActions.RESETPASSWORD.toString().equals( lSubmitAction ) ){
                String lNewPassword = lResetPasswordForm.getNewPassword();
                String lConfirmPassword = lResetPasswordForm.getConfirmPassword();
                boolean lPasswordMatched = mLoginService.isPasswordMatched(lNewPassword, lConfirmPassword);
                if ( lPasswordMatched )
                {
                    LOGGER.debug( "Reset Password Matched" );                  
                    String lUserName = (String)pHttpServletRequest.getSession().getAttribute(LOGGED_IN_USER_NAME );
                    User lUser = mLoginService.updateUserInfo( lUserName,lNewPassword);
                    pHttpServletRequest.getSession().setAttribute( LOGGED_IN_USER, lUser );
                    lResetPasswordForm.setNextPage( NavigateActions.DisplayHomePage.toString() );
                }
            }
        }
        System.out.println( "ProcessResetPassword" );
        return pActionMapping.findForward( NavigateActions.DisplayResetPassword.toString() );
    }

}
