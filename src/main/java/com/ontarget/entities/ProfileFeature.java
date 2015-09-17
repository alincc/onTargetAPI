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
@Table(name = "profile_feature")
public class ProfileFeature implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "profile_feature_id", nullable = false)
	private Integer profileFeatureId;
	@JoinColumn(name = "application_feature_id", referencedColumnName = "application_feature_id")
	@ManyToOne()
	private ApplicationFeature applicationFeature;
	@JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Profile profile;
	@Column(name = "active", length = 1)
	private Character active;

	public ProfileFeature() {
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Integer getProfileFeatureId() {
		return profileFeatureId;
	}

	public void setProfileFeatureId(Integer profileFeatureId) {
		this.profileFeatureId = profileFeatureId;
	}

	public ApplicationFeature getApplicationFeature() {
		return applicationFeature;
	}

	public void setApplicationFeature(ApplicationFeature applicationFeature) {
		this.applicationFeature = applicationFeature;
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
		hash += (profileFeatureId != null ? profileFeatureId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the profileMenuId
		// fields are
		// not set
		if (!(object instanceof ProfileFeature)) {
			return false;
		}
		ProfileFeature other = (ProfileFeature) object;
		if ((this.profileFeatureId == null && other.profileFeatureId != null)
				|| (this.profileFeatureId != null && !this.profileFeatureId.equals(other.profileFeatureId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProfileFeature[profileFeatureId=" + profileFeatureId + "]";
	}

}
