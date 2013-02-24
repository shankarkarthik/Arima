package org.ahp.commons.form;

import static org.ahp.commons.constants.AhpConstants.DISPLAY;
import static org.ahp.commons.constants.AhpConstants.FORM_NAME;
import static org.ahp.commons.constants.AhpConstants.PROCESS;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shankar Karthik Vaithianathan
 */
public abstract class AhpAbstractForm extends ActionForm {
   
    private static final long serialVersionUID = 1L;
    
    final static Logger LOGGER = LoggerFactory.getLogger( AhpAbstractForm.class );
    
    /** ${form.formName} */
    private String mFormName;
    /** ${form.processAction} */
    private String mProcessAction;
    /** ${form.displayAction} */
    private String mDisplayAction;
    private String mCurrentAction;
    private String mSubmitAction;
    private String mNextPage;
    private AhpPagination mPaginationData;
    
    @Override
    public void reset( ActionMapping pActionMapping, 
                       HttpServletRequest pHttpServletRequest ) {
        super.reset( pActionMapping, pHttpServletRequest );        
        /** 
         *  The key that the form is stored under in session scope's map ${form.<YourAccessor>}, 
         *  useful mainly for passing it to javascript functions for use by the DOM.
         *  With JQuery May not be very useful. 
         */    
        pHttpServletRequest.getSession().setAttribute( FORM_NAME, this );
        this.mSubmitAction = null;
        this.mFormName = pActionMapping.getName();
        this.mCurrentAction = pActionMapping.getPath();
        this.mDisplayAction = this.mCurrentAction.startsWith( "/" + DISPLAY ) ? this.mCurrentAction : this.mCurrentAction.replaceFirst( PROCESS, DISPLAY );
        this.mProcessAction = this.mDisplayAction.replaceFirst( DISPLAY, PROCESS );
        if ( isProcessAction( pActionMapping ) ) {
            resetForm( pActionMapping, pHttpServletRequest );
        }
    }

    /**
     * 
     * @param pActionMapping
     * @return
     */
    protected boolean isProcessAction( ActionMapping pActionMapping ){
        return pActionMapping.getPath().startsWith( "/" + PROCESS );
    }
    
    /**
     * 
     * @param pActionMapping
     * @param pHttpServletRequest
     */
    protected abstract void resetForm( ActionMapping pActionMapping, 
                                       HttpServletRequest pHttpServletRequest );
    
	@Override
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
        return new ActionErrors();
	}

    public String getFormName() {
        return mFormName;
    }
    public void setFormName( String pFormName ) {
        mFormName = pFormName;
    }
    public String getProcessAction() {
        return mProcessAction;
    }
    public void setProcessAction( String pProcessAction ) {
        mProcessAction = pProcessAction;
    }
    public String getDisplayAction() {
        return mDisplayAction;
    }
    public void setDisplayAction( String pDisplayAction ) {
        mDisplayAction = pDisplayAction;
    }
    public String getCurrentAction() {
        return mCurrentAction;
    }
    public void setCurrentAction( String pCurrentAction ) {
        mCurrentAction = pCurrentAction;
    }
    public String getSubmitAction() {
        return mSubmitAction;
    }
    public void setSubmitAction( String pSubmitAction ) {
        mSubmitAction = pSubmitAction;
    }
    public String getNextPage() {
        return mNextPage;
    }
    public void setNextPage( String pNextPage ) {
        mNextPage = pNextPage;
    }
    public AhpPagination getPaginationData() {
        return mPaginationData;
    }
    public void setPaginationData( AhpPagination pPaginationData ) {
        mPaginationData = pPaginationData;
    }
}
