package org.ahp.core.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ahp.commons.util.AhpStringUtil;

/**
 *
 * @author Shankar Karthik Vaithianathan
 *
 */
@Embeddable
public class Audit implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long mCreatedBy;
	private java.util.Date mCreatedDate;
	private Long mLastUpdatedBy;
	private java.util.Date mLastUpdatedDate;

	@Column( name = "CREATED_BY",
			 updatable = false )
	public Long getCreatedBy() {
		return mCreatedBy;
	}

	public void setCreatedBy( Long pCreatedBy ) {
		this.mCreatedBy = pCreatedBy;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "CREATED_DATE",
		     updatable = false )
	public java.util.Date getCreatedDate() {
		return mCreatedDate;
	}

	public void setCreatedDate( java.util.Date pCreatedDate ) {
		this.mCreatedDate = pCreatedDate;
	}

	@Column( name = "LAST_UPDATED_BY" )
	public Long getLastUpdatedBy() {
		return mLastUpdatedBy;
	}

	public void setLastUpdatedBy( Long pUpdatedBy ) {
		this.mLastUpdatedBy = pUpdatedBy;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "LAST_UPDATED_DATE" )
	public java.util.Date getLastUpdatedDate() {
		return mLastUpdatedDate;
	}

	public void setLastUpdatedDate(java.util.Date updatedDate) {
		this.mLastUpdatedDate = updatedDate;
	}

	/**
	 * @return String representation of the object
	 */
	public String toString(){
		return AhpStringUtil.reflectionToString( this );
	}
}
