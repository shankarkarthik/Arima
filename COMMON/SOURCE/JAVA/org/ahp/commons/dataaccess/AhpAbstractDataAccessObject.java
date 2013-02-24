package org.ahp.commons.dataaccess;

import javax.persistence.EntityManager;

public abstract class AhpAbstractDataAccessObject {
    
    public abstract void setEntityManager( EntityManager pEntityManager );
        
}
