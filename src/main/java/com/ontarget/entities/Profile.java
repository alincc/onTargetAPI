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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "profile_id", nullable = false)
	private Integer profileId;
	@Column(name = "name", length = 45)
	private String name;
	@Column(name = "profile_code", length = 45)
	private String profileCode;
	@Column(name = "description", length = 255)
	private String description;
	@Column(name = "profile_type", length = 20)
	private String profileType;
	@Column(name = "active", length = 1)
	private Character active;
	@Column(name = "added_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;
	@JoinColumn(name = "added_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User addedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
	private List<ProfileMenu> profileMenuList;
	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
	private List<ProfilePermission> profilePermissionList;

	public Profile() {
	}

	public Profile(Integer profileId) {
		super();
		this.profileId = profileId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<ProfileMenu> getProfileMenuList() {
		return profileMenuList;
	}

	public void setProfileMenuList(List<ProfileMenu> profileMenuList) {
		this.profileMenuList = profileMenuList;
	}

	public List<ProfilePermission> getProfilePermissionList() {
		return profilePermissionList;
	}

	public void setProfilePermissionList(List<ProfilePermission> profilePermissionList) {
		this.profilePermissionList = profilePermissionList;
	}

	public String getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (profileId != null ? profileId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Profile)) {
			return false;
		}
		Profile other = (Profile) object;
		if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Profile[profileId=" + profileId + "]";
	}

}
