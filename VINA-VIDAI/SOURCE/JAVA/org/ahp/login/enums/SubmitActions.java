package org.ahp.login.enums;

public enum SubmitActions {
	
	LOGIN( "Login" ),
	RESETPASSWORD( "ResetPassword" );
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
