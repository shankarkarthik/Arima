package org.ahp.test;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.ahp.login.dao.ILoginDAO;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = 
                        { "classpath:SPRING/applicationContext-tx-aop.xml",
                          "classpath:SPRING/test-applicationContext-datasource.xml",
                          "classpath:SPRING/test-applicationContext-emf.xml",
                          "classpath:SPRING/applicationContext-beans.xml"
                         }
                      )
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
@Ignore
public abstract class AhpSpringBaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat( "yyyy-mm-dd hh:mm:ss.S" );
        
    private DataSource mDataSource;
    
    @Autowired
    protected ILoginDAO mLoginDAO;
    
    @Autowired
    public void setDataSource( @Qualifier( value = "dataSource" ) DataSource pDataSource) {
        this.mDataSource = pDataSource;
    }
    
    public DataSource getDataSource(){
        return this.mDataSource;
    }
}