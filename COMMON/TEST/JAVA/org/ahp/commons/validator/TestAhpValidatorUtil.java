package org.ahp.commons.validator;

import junit.framework.TestCase;

import org.ahp.test.AhpBastTest;
import org.junit.Test;

public class TestAhpValidatorUtil extends AhpBastTest {

    @Test
    public void testIsAlphaNumeric(){
        TestCase.assertEquals( true, ValidatorUtil.isAlphaNumeric( "AU7" ) );
        TestCase.assertEquals( true, ValidatorUtil.isAlphaNumeric( "AU" ) );
        TestCase.assertEquals( true, ValidatorUtil.isAlphaNumeric( "7" ) );
    }

    @Test
    public void testIsAlpha(){
        TestCase.assertEquals( true, ValidatorUtil.isAlpha( "AU" ) );
        TestCase.assertEquals( false, ValidatorUtil.isAlpha( "7" ) );
    }

    @Test
    public void testIsNumeric(){
        TestCase.assertEquals( false, ValidatorUtil.isNumeric( "AU7" ) );
        TestCase.assertEquals( false, ValidatorUtil.isNumeric( "AU" ) );
        TestCase.assertEquals( true, ValidatorUtil.isNumeric( "7" ) );
    }

}
