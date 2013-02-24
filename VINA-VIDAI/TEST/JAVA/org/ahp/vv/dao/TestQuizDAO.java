package org.ahp.vv.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.List;

import org.ahp.commons.util.AhpResourceUtil;
import org.ahp.core.pojo.User;
import org.ahp.test.AhpSpringBaseTest;
import org.ahp.vinavidai.dao.IQuizDAO;
import org.ahp.vinavidai.pojo.Quiz;
import org.ahp.vinavidai.pojo.UserQuiz;
import org.ahp.vinavidai.quiz.QuizDAOImpl;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.annotation.Rollback;
import org.xml.sax.InputSource;

public class TestQuizDAO extends AhpSpringBaseTest {
    
    @Autowired
    protected IQuizDAO mQuizDAO;
    
    ///@Test
    @Ignore
    public void onSetUpInTransaction() throws Exception {
        java.sql.Timestamp lTimestamp = new java.sql.Timestamp( System.currentTimeMillis() );        
        Connection lConnection = DataSourceUtils.getConnection( super.getDataSource() );
        /*IDatabaseConnection lIDatabaseConnection = new DatabaseConnection( lConnection );
        InputSource lInputSource = new InputSource( AhpResourceUtil.getClassPathResource( "classpath:dbunit/test-dbUnit.xml" ) );
        ReplacementDataSet lDataSet = new ReplacementDataSet( new FlatXmlDataSet( new FlatXmlProducer( lInputSource ) ) );
        lDataSet.addReplacementObject( "[SYSDATE]", DATE_FORMATTER.format( lTimestamp ) );
        lDataSet.addReplacementObject( "[NULL]", null );
        try {
            DatabaseOperation.REFRESH.execute( lIDatabaseConnection, lDataSet );
            lConnection.commit();
        } finally {
            DataSourceUtils.releaseConnection( lConnection, super.getDataSource() );
        }*/
    }
 
    @Test
    public final void testFindById() {
        User lUser = new User();
        lUser.setUserId( new Long( "1" ) );
        //mQuizDAO.createQuiz( new Quiz() );
        List<UserQuiz> lUserQuizList = mQuizDAO.getUserQuiz( lUser );
        System.out.println( lUserQuizList.toString() );
    }

}
