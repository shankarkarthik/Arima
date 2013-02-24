package org.ahp.vinavidai.enums;

public enum SubmitActions {
	
	CANCEL( "Cancel" ),
	GO( "Go" ),
	CONTINUE( "Continue" ),
	NEXT( "Next" ),
	SAVE( "Save" ),
	COMPLETE_QUIZ( "Complete Quiz" );
	
	private String mSubmitActionLiteral;
	
	private SubmitActions( String pSubmitActionLiteral ) {
	    this.mSubmitActionLiteral = pSubmitActionLiteral;	    
	}

	public String toString(){
	    return this.mSubmitActionLiteral;
	}

    public String getValue(){
        return this.mSubmitActionLiteral;
    }

}
