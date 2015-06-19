package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "application_permission")
public class ApplicationPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "application_permission_id", nullable = false)
	private Integer applicationPermissionId;
	@Column(name = "permission_name", length = 45)
	private String permissionName;
	@Column(name = "permission_key", length = 45)
	private String permissionKey;
	@Column(name = "active", length = 1)
	private Character active;

	public ApplicationPermission() {
	}

	public ApplicationPermission(Integer applicationPermissionId) {
		this.applicationPermissionId = applicationPermissionId;
	}

	public Integer getApplicationPermissionId() {
		return applicationPermissionId;
	}

	public void setApplicationPermissionId(Integer applicationPermissionId) {
		this.applicationPermissionId = applicationPermissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionKey() {
		return permissionKey;
	}

	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (applicationPermissionId != null ? applicationPermissionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ApplicationPermission)) {
			return false;
		}
		ApplicationPermission other = (ApplicationPermission) object;
		if ((this.applicationPermissionId == null && other.applicationPermissionId != null)
				|| (this.applicationPermissionId != null && !this.applicationPermissionId
						.equals(applicationPermissionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ApplicationPermission[applicationPermissionId=" + applicationPermissionId + "]";
	}

}
