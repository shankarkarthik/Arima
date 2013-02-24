package org.ahp.commons.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AhpAbstractProcessAction extends AhpAbstractAction {
    
    final static Logger LOGGER = LoggerFactory.getLogger( AhpAbstractProcessAction.class );
    
    @Override
    public ActionForward execute( ActionMapping pActionMapping, 
                                  ActionForm pActionForm, 
                                  HttpServletRequest pHttpServletRequest, 
                                  HttpServletResponse pHttpServletResponse ) 
    throws Exception {

        ActionForward lProcessActionForward = process( pActionMapping, pActionForm, pHttpServletRequest, pHttpServletResponse );
        return lProcessActionForward;
    }
    
    /**
     * 
     * @param pActionMapping
     * @param pActionForm
     * @param pHttpServletRequest
     * @param pHttpServletResponse
     * @return
     */
    public abstract ActionForward process( ActionMapping pActionMapping, 
                                           ActionForm pActionForm, 
                                           HttpServletRequest pHttpServletRequest, 
                                           HttpServletResponse pHttpServletResponse );

}
