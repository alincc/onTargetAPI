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
@Table(name = "feature_request_mapper")
public class FeatureRequestMapper implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "feature_request_mapper_id", nullable = false)
	private Integer featureRequestMapperId;
	@JoinColumn(name = "application_feature_id", referencedColumnName = "application_feature_id", nullable = false)
	@ManyToOne(optional = false)
	private ApplicationFeature applicationFeature;
	@Column(name = "request_path", length = 45)
	private String requestPath;
	@Column(name = "has_feature", length = 1)
	private Character hasFeature;

	public FeatureRequestMapper() {
	}

	public Integer getFeatureRequestMapperId() {
		return featureRequestMapperId;
	}

	public void setFeatureRequestMapperId(Integer featureRequestMapperId) {
		this.featureRequestMapperId = featureRequestMapperId;
	}

	public ApplicationFeature getApplicationFeature() {
		return applicationFeature;
	}

	public void setApplicationFeature(ApplicationFeature applicationFeature) {
		this.applicationFeature = applicationFeature;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	public Character getHasFeature() {
		return hasFeature;
	}

	public void setHasFeature(Character hasFeature) {
		this.hasFeature = hasFeature;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (featureRequestMapperId != null ? featureRequestMapperId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FeatureRequestMapper)) {
			return false;
		}
		FeatureRequestMapper other = (FeatureRequestMapper) object;
		if ((this.featureRequestMapperId == null && other.featureRequestMapperId != null)
				|| (this.featureRequestMapperId != null && !this.featureRequestMapperId.equals(other.featureRequestMapperId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.FeatureRequestMapper[featureRequestMapperId=" + featureRequestMapperId + "]";
	}

}
