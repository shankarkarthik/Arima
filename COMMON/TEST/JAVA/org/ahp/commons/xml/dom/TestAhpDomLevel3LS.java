package org.ahp.commons.xml.dom;

import java.io.ByteArrayInputStream;

import org.ahp.commons.util.AhpResourceUtil;
import org.ahp.test.AhpBastTest;
import org.junit.Test;
import org.w3c.dom.Node;

public class TestAhpDomLevel3LS extends AhpBastTest {

	@Test
	public void testLSSave(){
		System.out.println( AhpResourceUtil.getClassPathResourceAsFileResource( "classpath:/DATA/test.xml" ) );
		Node lLoadedNode = AhpDomLevel3LS.loadNodeFromUri( AhpResourceUtil.getClassPathResourceAsFileResource( "classpath:DATA/test.xml" ) );
		AhpDomLevel3LS.saveNodeToFile( lLoadedNode, "file:///c:/temp/test2.xml" );
	}
	
	@Test
	public void testLSLoad(){
		String lXmlString = "<test><data>Testing LS - Load from String</data></test>";
		Node lLoadedStringNode = AhpDomLevel3LS.loadNodeFromString( lXmlString );
		String lXmlStream = "<test><data>Testing LS - Load from Stream</data></test>";
		Node lLoadedStreamNode = AhpDomLevel3LS.loadNodeFromStream( new ByteArrayInputStream( lXmlStream.getBytes() ) );
	}
}
