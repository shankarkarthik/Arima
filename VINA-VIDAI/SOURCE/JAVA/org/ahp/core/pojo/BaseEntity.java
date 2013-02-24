package org.ahp.core.pojo;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Audit mAudit;
    
    @Embedded
    public Audit getAudit() {
        return mAudit;
    }
    public void setAudit( Audit pAudit ) {
        mAudit = pAudit;
    }
    

}
