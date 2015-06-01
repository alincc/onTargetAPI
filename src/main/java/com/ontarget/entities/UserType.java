package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_type")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_type_id", nullable = false)
	private Integer userTypeId;
	@Basic(optional = false)
	@Column(name = "user_type", nullable = false, length = 100)
	private String userType;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false, length = 20)
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false, length = 20)
	private String modifiedBy;
	@Basic(optional = false)
	@Column(name = "is_expired", nullable = false, length = 2)
	private String isExpired;
	@OneToMany(mappedBy = "userType", fetch = FetchType.LAZY)
	private List<User> userList;

	public UserType() {
	}

	public UserType(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public UserType(Integer userTypeId, String userType, Date createdDate,
			String createdBy, Date modifiedDate, String modifiedBy,
			String isExpired) {
		this.userTypeId = userTypeId;
		this.userType = userType;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.isExpired = isExpired;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userTypeId != null ? userTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserType)) {
			return false;
		}
		UserType other = (UserType) object;
		if ((this.userTypeId == null && other.userTypeId != null)
				|| (this.userTypeId != null && !this.userTypeId
						.equals(other.userTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserType[userTypeId=" + userTypeId + "]";
	}

}
