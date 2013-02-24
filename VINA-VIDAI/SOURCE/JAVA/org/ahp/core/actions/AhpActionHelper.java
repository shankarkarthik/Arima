package org.ahp.core.actions;

import static org.ahp.core.constants.HttpSessionAttributeConstants.LOGGED_IN_USER;

import javax.servlet.http.HttpServletRequest;

import org.ahp.core.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AhpActionHelper {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpActionHelper.class );

    /**
     *
     * @param pHttpServletRequest
     * @return
     */
    public static User getLoggedInUser( HttpServletRequest pHttpServletRequest ){
        return ( User ) pHttpServletRequest.getSession().getAttribute( LOGGED_IN_USER );
    }

    

}
