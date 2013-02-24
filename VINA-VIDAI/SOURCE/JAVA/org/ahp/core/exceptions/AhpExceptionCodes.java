package org.ahp.core.exceptions;

public enum AhpExceptionCodes {
    
    AHP_00_000( "AHP.00.000" ),
    AHP_00_001( "AHP.00.001" );
    
    
    private String mExceptionCodeLiteral;
    
    /**
     * 
     * @param pExceptionCodeLiteral
     */
    private AhpExceptionCodes( String pExceptionCodeLiteral ){
        this.mExceptionCodeLiteral = pExceptionCodeLiteral;
    }
    
    public String getValue(){
        return this.mExceptionCodeLiteral;
    }

    public String toString(){
        return this.mExceptionCodeLiteral;
    }
    
}
