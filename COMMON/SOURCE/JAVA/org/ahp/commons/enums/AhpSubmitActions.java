package org.ahp.commons.enums;

public enum AhpSubmitActions {
	
	LOGIN( "Login" ),
	CANCEL( "Cancel" ),
	GO( "Go" ),
	CONTINUE( "Continue" ),
	NEXT( "Next" ),
	SAVE( "Save" ),
	COMPLETE_QUIZ( "Complete Quiz" );
	
	private String mSubmitActionLiteral;
	
	private AhpSubmitActions( String pSubmitActionLiteral ) {
	    this.mSubmitActionLiteral = pSubmitActionLiteral;	    
	}

	public String toString(){
	    return this.mSubmitActionLiteral;
	}

    public String getValue(){
        return this.mSubmitActionLiteral;
    }

}
