package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_groups")
public class UserGroups implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_group_id", nullable = false)
	private Integer userGroupId;
	@Basic(optional = false)
	@Column(name = "user_group_name", nullable = false, length = 255)
	private String userGroupName;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;
	@Basic(optional = false)
	@Column(name = "delete_flag", nullable = false, columnDefinition = "TINYINT")
	private short deleteFlag;
	@Basic(optional = false)
	@Column(name = "deleted_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;
	@Basic(optional = false)
	@Column(name = "deleted_by", nullable = false)
	private int deletedBy;

	public UserGroups() {
	}

	public UserGroups(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public UserGroups(Integer userGroupId, String userGroupName, Date createdDate, int createdBy, Date modifiedDate,
			int modifiedBy, short deleteFlag, Date deletedDate, int deletedBy) {
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.deleteFlag = deleteFlag;
		this.deletedDate = deletedDate;
		this.deletedBy = deletedBy;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public short getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public int getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(int deletedBy) {
		this.deletedBy = deletedBy;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userGroupId != null ? userGroupId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserGroups)) {
			return false;
		}
		UserGroups other = (UserGroups) object;
		if ((this.userGroupId == null && other.userGroupId != null)
				|| (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserGroups[userGroupId=" + userGroupId + "]";
	}

}
