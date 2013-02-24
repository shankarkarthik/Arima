package org.ahp.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractDisplayAction;
import org.ahp.login.enums.NavigateActions;
import org.ahp.login.form.LoginForm;
import org.ahp.login.form.ResetPasswordForm;
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
 *      path="/DisplayResetPassword"
 *      name="ResetPasswordForm"
 *      scope="session"
 *      validate="false"
 *      
 * @struts.action-forward
 *      name="DisplayResetPassword"
 *      path="/login/ResetPassword.jsp"      
 *   
 */
public class DisplayResetPassword extends AhpAbstractDisplayAction {

    final static Logger LOGGER = LoggerFactory.getLogger( DisplayLogin.class );
    
    @Override
    public ActionForward display( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) 
    {
    	ResetPasswordForm lResetPasswordForm = (ResetPasswordForm) pActionForm;
    	System.out.println( "DisplayResetPassword" );
        return pActionMapping.findForward( NavigateActions.DisplayResetPassword.toString() );
    }
}
