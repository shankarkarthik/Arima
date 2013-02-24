package org.ahp.commons.exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.MissingResourceException;

public final class AhpExceptionTranslator {

	/**
	 * 
	 * @param pClass
	 * @param pExceptionResourceKey
	 * @param pExceptionResourceArguments
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static AhpRuntimeException newException( Class pClass,
												    Throwable pThrowable,
			                                        String pExceptionResourceKey, 
			                                        Object[] pExceptionResourceArguments ) {
		try {
			Constructor lConstructor = pClass.getConstructor( String.class, Throwable.class );
			AhpRuntimeException lAhpRuntimeException = ( AhpRuntimeException ) lConstructor.newInstance( "", pThrowable );
			
		} catch ( InstantiationException exInstantiation ) {
			exInstantiation.printStackTrace();
		} catch ( IllegalAccessException exIllegal ) {
			exIllegal.printStackTrace();
		} catch ( MissingResourceException exMissingResource ) {
			exMissingResource.printStackTrace();
        } catch ( SecurityException exSecurity ) {
        	exSecurity.printStackTrace();
		} catch ( NoSuchMethodException exNoSuchMethod ) {
			exNoSuchMethod.printStackTrace();
		} catch ( IllegalArgumentException exIllegalArgument ) {
			exIllegalArgument.printStackTrace();
		} catch ( InvocationTargetException exInvocationTarget ) {
			exInvocationTarget.printStackTrace();
		}
		return new AhpRuntimeException( "AHP.000.0000" );
	}
	
	/**
	 * 
	 * @param pClass
	 * @param pExceptionResourceKey
	 * @param pExceptionResourceArguments
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static AhpRuntimeException newException( Throwable pThrowable,
			                                        String pExceptionResourceKey, 
			                                        Object[] pExceptionResourceArguments ) {
		return newException( AhpRuntimeException.class, pThrowable, pExceptionResourceKey, pExceptionResourceArguments );
	}
	
	public static void main( String[] pArgs ){
		AhpExceptionTranslator.newException( AhpRuntimeException.class, new RuntimeException(), "AHP.001.0001", null );
	}

}
