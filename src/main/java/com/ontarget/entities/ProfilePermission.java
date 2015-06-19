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
@Table(name = "profile_permission")
public class ProfilePermission implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "profile_permission_id", nullable = false)
	private Integer profilePermissionId;
	@JoinColumn(name = "application_permission_id", referencedColumnName = "application_permission_id")
	@ManyToOne()
	private ApplicationPermission applicationPermission;
	@JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Profile profile;
	@Column(name = "active", length = 1)
	private Character active;

	public ProfilePermission() {
	}

	public ProfilePermission(Integer profilePermissionId) {
		this.profilePermissionId = profilePermissionId;
	}

	public Integer getProfilePermissionId() {
		return profilePermissionId;
	}

	public void setProfilePermissionId(Integer profilePermissionId) {
		this.profilePermissionId = profilePermissionId;
	}

	public ApplicationPermission getApplicationPermission() {
		return applicationPermission;
	}

	public void setApplicationPermission(ApplicationPermission applicationPermission) {
		this.applicationPermission = applicationPermission;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
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
		hash += (profilePermissionId != null ? profilePermissionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the profileMenuId
		// fields are
		// not set
		if (!(object instanceof ProfilePermission)) {
			return false;
		}
		ProfilePermission other = (ProfilePermission) object;
		if ((this.profilePermissionId == null && other.profilePermissionId != null)
				|| (this.profilePermissionId != null && !this.profilePermissionId.equals(other.profilePermissionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProfilePermission[profilePermissionId=" + profilePermissionId + "]";
	}

}
