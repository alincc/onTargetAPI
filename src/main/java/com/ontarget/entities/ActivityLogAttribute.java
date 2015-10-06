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

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "activity_log_attribute")
public class ActivityLogAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "activity_log_attribute_id", nullable = false)
	private Long activityLogAttributeId;
	@Column(name = "attribute_key", length = 20, nullable = false)
	private String attributeKey;
	@Column(name = "attribute_value", length = 20, nullable = false)
	private String attributeValue;
	@JoinColumn(name = "activity_log_id", referencedColumnName = "activity_log_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ActivityLog activityLog;

	public ActivityLogAttribute() {
	}

	public ActivityLogAttribute(Long activityLogAttributeId) {
		super();
		this.activityLogAttributeId = activityLogAttributeId;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ActivityLogAttribute)) {
			return false;
		}
		ActivityLogAttribute other = (ActivityLogAttribute) object;
		if ((this.activityLogAttributeId == null && other.activityLogAttributeId != null)
				|| (this.activityLogAttributeId != null && !this.activityLogAttributeId.equals(other.activityLogAttributeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.NotificationAttribute[activityLogAttributeId=" + activityLogAttributeId + "]";
	}

}
