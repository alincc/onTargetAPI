package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.ontarget.dto.BaseRequest;

public class BaseBean extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	protected User createdBy;
	protected Date createdDate;
	protected User modifiedBy;
	protected Date modifiedDate;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
