package org.ahp.login.form;

import javax.servlet.http.HttpServletRequest;

import org.ahp.commons.form.AhpAbstractForm;
import org.ahp.login.enums.SubmitActions;
import org.ahp.login.validator.ResetPasswordValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Anita
 * 
 * @struts.form name="ResetPasswordForm" 
 */
public class ResetPasswordForm extends AhpAbstractForm 
{

	final static Logger LOGGER = LoggerFactory.getLogger( LoginForm.class );
    
    private String mNewPassword;
    private String mConfirmPassword;
    
    @Override
    protected void resetForm( ActionMapping pActionMapping,
                              HttpServletRequest pHttpServletRequest ) 
    {
    }

    @Override
    public ActionErrors validate( ActionMapping pActionMapping,
                                  HttpServletRequest pHttpServletRequest ) 
    {
        ActionErrors lActionErrors = new ActionErrors();
        String lSubmitAction = StringUtils.trimToNull( this.getSubmitAction() );
        if ( lSubmitAction != null && SubmitActions.RESETPASSWORD.toString().equals( ( lSubmitAction ) ) )
        {
            ResetPasswordValidator.validateResetPasswordForm( this, lActionErrors );    
        }
        return lActionErrors;
    }

	public String getNewPassword() {
		return mNewPassword;
	}

	public void setNewPassword(String pNewPassword) {
		mNewPassword = pNewPassword;
	}

	public String getConfirmPassword() {
		return mConfirmPassword;
	}

	public void setConfirmPassword(String pConfirmPassword) {
		mConfirmPassword = pConfirmPassword;
	}
}
