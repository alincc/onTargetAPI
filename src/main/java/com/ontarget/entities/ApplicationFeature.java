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
@Table(name = "application_feature")
public class ApplicationFeature implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "application_feature_id", nullable = false)
	private Integer applicationFeatureId;
	@Column(name = "feature_name", length = 45)
	private String featureName;
	@Column(name = "feature_key", length = 45)
	private String featureKey;
	@Column(name = "active", length = 1)
	private Character active;

	public ApplicationFeature() {
	}

	public Integer getApplicationFeatureId() {
		return applicationFeatureId;
	}

	public void setApplicationFeatureId(Integer applicationFeatureId) {
		this.applicationFeatureId = applicationFeatureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureKey() {
		return featureKey;
	}

	public void setFeatureKey(String featureKey) {
		this.featureKey = featureKey;
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
		hash += (applicationFeatureId != null ? applicationFeatureId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ApplicationFeature)) {
			return false;
		}
		ApplicationFeature other = (ApplicationFeature) object;
		if ((this.applicationFeatureId == null && other.applicationFeatureId != null)
				|| (this.applicationFeatureId != null && !this.applicationFeatureId.equals(applicationFeatureId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ApplicationFeature[applicationFeatureId=" + applicationFeatureId + "]";
	}

}
