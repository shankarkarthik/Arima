package org.ahp.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.action.AhpAbstractDisplayAction;
import org.ahp.login.enums.NavigateActions;
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
 *      path="/DisplayLogin"
 *      name="LoginForm"
 *      scope="session"
 *      validate="false"
 *    
 * @struts.action-forward
 *      name="DisplayLogin"
 *      path="/login/Login.jsp"
 *      
 * @struts.action-forward
 *      name="DisplayHomePage"
 *      path="/login/Home.jsp"
 *      
 * @struts.action-forward
 *      name="DisplayResetPassword"
 *      path="/ProcessResetPassword.do"     
 *   
 */
public class DisplayLogin extends AhpAbstractDisplayAction {

    final static Logger LOGGER = LoggerFactory.getLogger( DisplayLogin.class );
    
    @Override
    public ActionForward display( ActionMapping pActionMapping,
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse ) {
        LoginForm lLoginForm = ( LoginForm ) pActionForm;
        if ( NavigateActions.DisplayHomePage.toString().equals( StringUtils.trimToEmpty( lLoginForm.getNextPage() ) ) ){
            return pActionMapping.findForward( NavigateActions.DisplayHomePage.toString() );
        }
        else if(NavigateActions.DisplayResetPassword.toString().equals(StringUtils.trimToEmpty(lLoginForm.getNextPage())))
        {
            return pActionMapping.findForward( NavigateActions.DisplayResetPassword.toString() );
        }
        return pActionMapping.findForward( NavigateActions.DisplayLogin.toString() );
    }
}
