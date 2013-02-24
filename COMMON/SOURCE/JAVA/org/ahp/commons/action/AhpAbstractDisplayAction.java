package org.ahp.commons.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ahp.commons.form.AhpAbstractForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AhpAbstractDisplayAction extends AhpAbstractAction {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpAbstractDisplayAction.class );

    @Override
    public ActionForward execute( ActionMapping pActionMapping,
                                  ActionForm pActionForm,
                                  HttpServletRequest pHttpServletRequest,
                                  HttpServletResponse pHttpServletResponse )
    throws Exception {
        AhpAbstractForm lAbstractForm = ( AhpAbstractForm ) pActionForm;
        ActionForward lDisplayActionForward = display( pActionMapping, pActionForm, pHttpServletRequest, pHttpServletResponse );
        super.clearNavigation( lAbstractForm );
        super.clearPagination( lAbstractForm );
        return lDisplayActionForward;
    }

    /**
     *
     * @param pActionMapping
     * @param pActionForm
     * @param pHttpServletRequest
     * @param pHttpServletResponse
     * @return
     */
    public abstract ActionForward display( ActionMapping pActionMapping,
                                           ActionForm pActionForm,
                                           HttpServletRequest pHttpServletRequest,
                                           HttpServletResponse pHttpServletResponse );

}
