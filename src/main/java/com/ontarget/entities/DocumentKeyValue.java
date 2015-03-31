package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "document_key_value")
public class DocumentKeyValue implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_key_value_id", nullable = false)
	private Integer documentKeyValueId;
	@Basic(optional = false)
	@Column(name = "`key`", nullable = false, length = 45)
	private String key;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false, length = 45)
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false, length = 45)
	private String modifiedBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "document_id", referencedColumnName = "document_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Document document;
	@Column(name = "value", columnDefinition = "TEXT")
	private String value;

	public DocumentKeyValue() {
	}

	public DocumentKeyValue(Integer documentKeyValueId) {

	}

	public Integer getDocumentKeyValueId() {
		return documentKeyValueId;
	}

	public void setDocumentKeyValueId(Integer documentKeyValueId) {
		this.documentKeyValueId = documentKeyValueId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (documentKeyValueId != null ? documentKeyValueId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DocumentKeyValue)) {
			return false;
		}
		DocumentKeyValue other = (DocumentKeyValue) object;
		if ((this.documentKeyValueId == null && other.documentKeyValueId != null)
				|| (this.documentKeyValueId != null && !this.documentKeyValueId
						.equals(other.documentKeyValueId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.DocumentKeyValue[documentKeyValueId="
				+ documentKeyValueId + "]";
	}

}
