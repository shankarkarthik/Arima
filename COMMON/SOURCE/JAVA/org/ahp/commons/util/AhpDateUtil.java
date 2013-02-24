package org.ahp.commons.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AhpDateUtil {
	
    final static Logger LOGGER = LoggerFactory.getLogger( AhpDateUtil.class );
    
    /**
     * 
     * @param pObject
     * @return
     */
	public static Date addDays( Date pInputDate, int pNumberOfDays )
	{
		try
		{
			Calendar lNewDate = Calendar.getInstance();
		    lNewDate.setTime( pInputDate );
		    lNewDate.add( Calendar.DATE, pNumberOfDays );
		    return lNewDate.getTime();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	} 
	
	/**
     * 
     * @param pObject
     * @return
     */
	public static boolean checkForDateExpiry(Date pExpiryDate )
	{
		try
		{
			Date lTodayDate = new Date(System.currentTimeMillis());			
		    return lTodayDate.after( pExpiryDate );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	} 

	
}
