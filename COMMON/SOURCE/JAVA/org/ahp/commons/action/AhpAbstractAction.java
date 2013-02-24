package org.ahp.commons.action;

import org.ahp.commons.form.AhpAbstractForm;
import org.apache.struts.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AhpAbstractAction extends Action {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpAbstractAction.class );

    public static final String PREVIOUS_ACTION = "Previous";
    public static final String NEXT_ACTION = "Next";
    public static final String BACK_BUTTON_USER_MESSAGE = "An error has occurred, most likely from viewing a screen using the back button.  Please try the operation again.";
    
    /**
     *
     * @param pAbstractForm
     */
    public void clearNavigation( AhpAbstractForm pAbstractForm ){
        if ( LOGGER.isDebugEnabled() ) LOGGER.debug( "clearNavigation :: starts" );
        pAbstractForm.setSubmitAction( null );
        pAbstractForm.setNextPage( null );
        if ( LOGGER.isDebugEnabled() ) LOGGER.debug( "clearNavigation :: ends" );
    }

    /**
     *
     * @param pAbstractForm
     */
    public void clearPagination( AhpAbstractForm pAbstractForm ){
        if ( LOGGER.isDebugEnabled() ) LOGGER.debug( "clearPagination :: starts" );
        pAbstractForm.setPaginationData( null );
        if ( LOGGER.isDebugEnabled() ) LOGGER.debug( "clearPagination :: ends" );
    }

}
