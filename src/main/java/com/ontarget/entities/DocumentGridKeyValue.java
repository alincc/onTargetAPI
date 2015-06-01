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
@Table(name = "document_grid_key_value")
public class DocumentGridKeyValue implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_grid_key_value_id", nullable = false)
	private Integer documentGridKeyValueId;
	@Basic(optional = false)
	@Column(name = "grid_id", nullable = false, length = 45)
	private String gridId;
	@Basic(optional = false)
	@Column(name = "`key`", nullable = false, length = 45)
	private String key;
	@Basic(optional = false)
	@Column(name = "grid_row_index", nullable = false, length = 11)
	private Integer gridRowIndex;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "document_id", referencedColumnName = "document_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Document document;
	@Column(name = "value", columnDefinition = "TEXT")
	private String value;

	public DocumentGridKeyValue() {
	}

	public DocumentGridKeyValue(Integer documentKeyValueId) {

	}

	public Integer getDocumentGridKeyValueId() {
		return documentGridKeyValueId;
	}

	public void setDocumentGridKeyValueId(Integer documentGridKeyValueId) {
		this.documentGridKeyValueId = documentGridKeyValueId;
	}

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public Integer getGridRowIndex() {
		return gridRowIndex;
	}

	public void setGridRowIndex(Integer gridRowIndex) {
		this.gridRowIndex = gridRowIndex;
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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
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
		hash += (documentGridKeyValueId != null ? documentGridKeyValueId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DocumentGridKeyValue)) {
			return false;
		}
		DocumentGridKeyValue other = (DocumentGridKeyValue) object;
		if ((this.documentGridKeyValueId == null && other.documentGridKeyValueId != null)
				|| (this.documentGridKeyValueId != null && !this.documentGridKeyValueId.equals(other.documentGridKeyValueId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.DocumentGridKeyValue[documentGridKeyValueId=" + documentGridKeyValueId + "]";
	}

}
