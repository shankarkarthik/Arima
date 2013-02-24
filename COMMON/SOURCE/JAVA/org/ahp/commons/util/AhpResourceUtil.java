package org.ahp.commons.util;

import static org.ahp.commons.constants.AhpConstants.CLASSPATH_RESOURCE_PREFIX;
import static org.ahp.commons.constants.AhpConstants.FILE_RESOURCE_PREFIX;
import static org.ahp.commons.constants.AhpConstants.FILE_RESOURCE_URI_PREFIX;
import static org.ahp.commons.constants.AhpConstants.WEB_INF_RESOURCE_PREFIX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.ahp.commons.exceptions.AhpRuntimeException;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public final class AhpResourceUtil {
	
	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static boolean isClassPathResource( String pResourceUri ){
		if ( pResourceUri.trim().toUpperCase().startsWith( CLASSPATH_RESOURCE_PREFIX.toUpperCase() ) ){
			return true;
		} 
		return false;
	}

	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static boolean isFileResource( String pResourceUri ){
		if ( pResourceUri.trim().toUpperCase().startsWith( FILE_RESOURCE_PREFIX.toUpperCase() ) || 
			 pResourceUri.trim().toUpperCase().startsWith( FILE_RESOURCE_URI_PREFIX.toUpperCase() ) ){
			return true;
		} 
		return false;
	}
	
	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static boolean isWebInfResource( String pResourceUri ){
		if ( pResourceUri.trim().toUpperCase().startsWith( WEB_INF_RESOURCE_PREFIX.toUpperCase() ) ){
			return true;
		} 
		return false;
	}
	
	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static String getClassPathResourcePath( String pResourceUri ){
		if ( isClassPathResource( pResourceUri ) ){
			return StringUtils.substringAfter( pResourceUri, CLASSPATH_RESOURCE_PREFIX );
		} 
		return null;
	}
	
	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static String getFileResourcePath( String pResourceUri ){
		if ( isFileResource( pResourceUri ) ){
			return StringUtils.substringAfter( pResourceUri.trim(), FILE_RESOURCE_PREFIX );
		} 
		return null;
	}
	
	public static InputStream getClassPathResource( String pResourceUri ){
		if ( isClassPathResource( pResourceUri ) ){
			return AhpResourceUtil.class.getResourceAsStream ( getClassPathResourcePath( pResourceUri.trim() ) );
		} 
		throw new AhpRuntimeException( "AHP.110.001" );
	}

	/**
	 * 
	 * @param pResourceUri
	 * @return
	 */
	public static InputStream getFileResource( String pResourceUri ){
		if ( isFileResource( pResourceUri ) ){
			try {
				return new FileInputStream( new File( new URI ( pResourceUri.trim() ) ) );
			} catch ( FileNotFoundException exFileNotFound ) {
				new AhpRuntimeException( "AHP.110.001", exFileNotFound );
			} catch (URISyntaxException exURISyntax ) {
				new AhpRuntimeException( "AHP.110.001", exURISyntax );
			}
		} 
		throw new AhpRuntimeException( "AHP.110.001" );
	}

	/**
	 * 
	 * @param pClasspathResourceUri
	 * @return
	 */
	public static URL getClassPathResourceAsFileUrl( String pClasspathResourceUri ){
		if ( isClassPathResource( pClasspathResourceUri ) ){
			pClasspathResourceUri = StringUtils.substringAfter( pClasspathResourceUri, CLASSPATH_RESOURCE_PREFIX + "/" );
			System.out.println( pClasspathResourceUri );
			return Thread.currentThread().getContextClassLoader().getResource( pClasspathResourceUri );
		}
		throw new AhpRuntimeException( "AHP.110.0001" );
	}

	/**
	 * 
	 * @param pClasspathResourceUri
	 * @return
	 */
	public static String getClassPathResourceAsFileResource( String pClasspathResourceUri ){
		return getClassPathResourceAsFileUrl( pClasspathResourceUri ).toString();
	}
	
	/**
	 * 
	 * @param pRealPath
	 * @param pResourceUri
	 * @return
	 */
	public static String getWebInfResourceAsFileResourceUri( String pResourceUri, String pRealPath ) {
        Path lFilePath = Paths.get( pRealPath + pResourceUri );
        return lFilePath.toUri().toString();        
	}
}
