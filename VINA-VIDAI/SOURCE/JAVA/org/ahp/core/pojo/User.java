package org.ahp.core.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.ahp.commons.util.AhpStringUtil;

/**
 *
 * @author Shankar Karthik Vaithianathan
 *
 */
@Entity
@Table( name = "USER",
        schema = "VINAVIDAI" )
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long mUserId;
    private String mLoginName;
    private String mPassword;
    private Date mPasswordExpiryDate;
    
	@Id
    @GeneratedValue
    @Column( name = "USER_ID" )
    public Long getUserId() {
        return mUserId;
    }
    public void setUserId( Long pUserId ) {
        this.mUserId = pUserId;
    }
    @Column( name = "LOGIN_NAME" )
    public String getLoginName() {
        return mLoginName;
    }
    public void setLoginName( String pLoginName ) {
        this.mLoginName = pLoginName;
    }
    @Column( name = "PASSWORD" )
    public String getPassword() {
        return mPassword;
    }
    public void setPassword( String pPassword ) {
        this.mPassword = pPassword;
    }
    @Column( name = "PWD_EXP_DT" )
    public Date getPasswordExpiryDate() {
		return mPasswordExpiryDate;
	}
	public void setPasswordExpiryDate(Date pPasswordExpiryDate) {
		mPasswordExpiryDate = pPasswordExpiryDate;
	}
	/**
     * @return String representation of the object
     */
    public String toString(){
        return AhpStringUtil.reflectionToString( this );
    }
}