package org.ahp.commons.xml.xpath;

import junit.framework.TestCase;

import org.ahp.commons.xml.dom.AhpDomLevel3LS;
import org.ahp.test.AhpBastTest;
import org.junit.Test;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public class TestAhpXPathUtil extends AhpBastTest {

	@Test
	public void testXPath(){
		String lTestString = "<Test><StringData>TestString</StringData></Test>";
		String lTestBoolean = "<Test><BooleanData>true</BooleanData></Test>";
		String lTestInteger = "<Test><IntegerData>123</IntegerData></Test>";
		String lTestNode = "<Test><NodeData><Node1></Node1></NodeData></Test>";
		String lTestNodeList = "<Test><StringData></StringData></Test>";
		AhpXPathUtil lAhpXPathUtil = new AhpXPathUtil();
		TestCase.assertEquals( "TestString", lAhpXPathUtil.getAsString( AhpDomLevel3LS.loadNodeFromString( lTestString ), "/Test/StringData" ) );
		TestCase.assertTrue( lAhpXPathUtil.getAsBoolean( AhpDomLevel3LS.loadNodeFromString( lTestBoolean ), "/Test/BooleanData" ) );
		TestCase.assertEquals( new Integer( "123" ), lAhpXPathUtil.getAsInteger( AhpDomLevel3LS.loadNodeFromString( lTestInteger ), "/Test/IntegerData" ) );
	}
}
