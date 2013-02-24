package org.ahp.login.validator;

import org.ahp.login.form.ResetPasswordForm;
import org.apache.struts.action.ActionErrors;

/**
 * 
 * @author Anita Onnuvel
 *
 */
public final class ResetPasswordValidator extends BaseValidator
{
    
    /**
     * 
     * @param pLoginForm
     * @param pActionErrors
     */
    public static void validateResetPasswordForm( ResetPasswordForm pResetPasswordForm, ActionErrors pActionErrors )
    {
        validatePasswordFields( pResetPasswordForm.getNewPassword(),pResetPasswordForm.getConfirmPassword(),pActionErrors,RESETPASSWORD_ERROR_KEY_PREFIX);

    }
}
