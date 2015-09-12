package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "permission_mapped_request")
public class PermissionMappedRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "permission_mapped_request_id", nullable = false)
	private Integer permissionMappedRequestId;
	@JoinColumn(name = "application_permission_id", referencedColumnName = "application_permission_id", nullable = false)
	@ManyToOne(optional = false)
	private ApplicationPermission applicationPermission;
	@Column(name = "request_path", length = 45)
	private String requestPath;
	@Column(name = "has_permission", length = 1)
	private Character hasPermission;

	public PermissionMappedRequest() {
	}

	public PermissionMappedRequest(Integer permissionMappedRequestId) {
		this.permissionMappedRequestId = permissionMappedRequestId;
	}

	public Integer getPermissionMappedRequestId() {
		return permissionMappedRequestId;
	}

	public void setPermissionMappedRequestId(Integer permissionMappedRequestId) {
		this.permissionMappedRequestId = permissionMappedRequestId;
	}

	public ApplicationPermission getApplicationPermission() {
		return applicationPermission;
	}

	public void setApplicationPermission(ApplicationPermission applicationPermission) {
		this.applicationPermission = applicationPermission;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	public Character getHasPermission() {
		return hasPermission;
	}

	public void setHasPermission(Character hasPermission) {
		this.hasPermission = hasPermission;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (permissionMappedRequestId != null ? permissionMappedRequestId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PermissionMappedRequest)) {
			return false;
		}
		PermissionMappedRequest other = (PermissionMappedRequest) object;
		if ((this.permissionMappedRequestId == null && other.permissionMappedRequestId != null)
				|| (this.permissionMappedRequestId != null && !this.permissionMappedRequestId.equals(other.permissionMappedRequestId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.PermissionMappedRequest[permissionMappedRequestId=" + permissionMappedRequestId + "]";
	}

}
