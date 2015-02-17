package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.ontarget.dto.BaseRequestDTO;

public class BaseBean extends BaseRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected UserDTO createdBy;
	protected Date createdDate;
	protected UserDTO modifiedBy;
	protected Date modifiedDate;

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserDTO getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserDTO modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
