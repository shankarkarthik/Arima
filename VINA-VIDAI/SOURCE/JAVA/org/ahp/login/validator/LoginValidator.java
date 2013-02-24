package org.ahp.login.validator;

import org.ahp.login.form.LoginForm;
import org.apache.struts.action.ActionErrors;

public final class LoginValidator extends BaseValidator {
    
    /**
     * 
     * @param pLoginForm
     * @param pActionErrors
     */
    public static void validateLoginForm( LoginForm pLoginForm, ActionErrors pActionErrors ){
        validateLoginName( pLoginForm.getLoginName(), pActionErrors, LOGIN_ERROR_KEY_PREFIX  );
        validateLoginPassword( pLoginForm.getPassword(), pActionErrors, LOGIN_ERROR_KEY_PREFIX  );
    }

}
