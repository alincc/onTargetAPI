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
@Table(name = "bulk_activity_attribute")
public class BulkActivityAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "row_index", nullable = false)
	private String index;
	@Column(name = "attribute_key", length = 20, nullable = false)
	private String attributeKey;
	@Column(name = "attribute_value", length = 20, nullable = false)
	private String attributeValue;
	@JoinColumn(name = "bulk_activity_log_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private BulkActivityLog bulkActivityLog;
	@Basic(optional = false)
	@Column(name = "valid", nullable = false, length = 2)
	private String valid;

	public BulkActivityAttribute() {
	}

	public BulkActivityAttribute(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public BulkActivityLog getBulkActivityLog() {
		return bulkActivityLog;
	}

	public void setBulkActivityLog(BulkActivityLog bulkActivityLog) {
		this.bulkActivityLog = bulkActivityLog;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof BulkActivityAttribute)) {
			return false;
		}
		BulkActivityAttribute other = (BulkActivityAttribute) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserNotification[id=" + id + "]";
	}

}
