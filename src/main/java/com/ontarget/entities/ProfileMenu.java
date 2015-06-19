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
@Table(name = "profile_menu")
public class ProfileMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "profile_menu_id", nullable = false)
	private Integer profileMenuId;
	@JoinColumn(name = "application_menu_id", referencedColumnName = "application_menu_id")
	@ManyToOne()
	private ApplicationMenu applicationMenu;
	@JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Profile profile;
	@Column(name = "active", length = 1)
	private Character active;

	public ProfileMenu() {
	}

	public ProfileMenu(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
	}

	public Integer getProfileMenuId() {
		return profileMenuId;
	}

	public void setProfileMenuId(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
	}

	public ApplicationMenu getApplicationMenu() {
		return applicationMenu;
	}

	public void setApplicationMenu(ApplicationMenu applicationMenu) {
		this.applicationMenu = applicationMenu;
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
		hash += (profileMenuId != null ? profileMenuId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the profileMenuId
		// fields are
		// not set
		if (!(object instanceof ProfileMenu)) {
			return false;
		}
		ProfileMenu other = (ProfileMenu) object;
		if ((this.profileMenuId == null && other.profileMenuId != null)
				|| (this.profileMenuId != null && !this.profileMenuId.equals(other.profileMenuId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProfileMenu[profileMenuId=" + profileMenuId + "]";
	}

}
