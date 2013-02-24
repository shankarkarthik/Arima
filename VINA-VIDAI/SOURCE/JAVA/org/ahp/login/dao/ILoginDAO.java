package org.ahp.login.dao;

import java.sql.Date;

import org.ahp.core.pojo.User;

public interface ILoginDAO {
	
	public User loadUserByLoginName( String pLoginName );
	public User loadUserByLoginId( Long pLoginId );
	public Date getPasswordExpiryDate(String pLoginName);
	public void updateUserInfo(String pLoginName,String pPassword);
}
