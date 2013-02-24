package org.ahp.core.businessdelegate;

import org.ahp.commons.businessdelegate.AhpAbstractBusinessDelegate;
import org.ahp.core.pojo.Audit;
import org.ahp.core.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AhpBusinessDelegate extends AhpAbstractBusinessDelegate {

    final static Logger LOGGER = LoggerFactory.getLogger( AhpBusinessDelegate.class );

    /**
     *
     * @param pUser
     * @return
     */
    protected Audit createAudit( User pUser ){
        java.util.Date lTodayDate = new java.sql.Timestamp( System.currentTimeMillis() );
        Audit lAudit = new Audit();
        lAudit.setCreatedBy( pUser.getUserId() );
        lAudit.setCreatedDate( lTodayDate );
        lAudit.setLastUpdatedBy( pUser.getUserId() );
        lAudit.setLastUpdatedDate( lTodayDate );
        return lAudit;

    }

    /**
     * @param pUser
     * @param pTodayDate
     * @return
     */
    protected Audit createAudit( User pUser, java.util.Date pTodayDate ){
        Audit lAudit = new Audit();
        lAudit.setCreatedBy( pUser.getUserId() );
        lAudit.setCreatedDate( pTodayDate );
        lAudit.setLastUpdatedBy( pUser.getUserId() );
        lAudit.setLastUpdatedDate( pTodayDate );
        return lAudit;
    }

}
