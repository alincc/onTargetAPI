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
@Table(name = "document_submittal")
public class DocumentSubmittal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_submittal_id", nullable = false)
	private Integer documentSubmittalId;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User modifiedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "assignee_user_id", referencedColumnName = "user_id")
	@ManyToOne()
	private User user;
	@JoinColumn(name = "document_id", referencedColumnName = "document_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Document document;

	public DocumentSubmittal() {
	}

	public DocumentSubmittal(Integer documentSubmittalId) {
		this.documentSubmittalId = documentSubmittalId;
	}

	public Integer getDocumentSubmittalId() {
		return documentSubmittalId;
	}

	public void setDocumentSubmittalId(Integer documentSubmittalId) {
		this.documentSubmittalId = documentSubmittalId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		hash += (documentSubmittalId != null ? documentSubmittalId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DocumentSubmittal)) {
			return false;
		}
		DocumentSubmittal other = (DocumentSubmittal) object;
		if ((this.documentSubmittalId == null && other.documentSubmittalId != null)
				|| (this.documentSubmittalId != null && !this.documentSubmittalId.equals(other.documentSubmittalId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.DocumentSubmittal[documentSubmittalId=" + documentSubmittalId + "]";
	}

}
