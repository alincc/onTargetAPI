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
@Table(name = "document_attachment")
public class DocumentAttachment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_attachment_id", nullable = false)
	private Integer documentAttachmentId;
	@Basic(optional = false)
	@Column(name = "file_path", nullable = false, length = 255)
	private String filePath;
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

	public DocumentAttachment() {
	}

	public DocumentAttachment(Integer documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}

	public Integer getDocumentAttachmentId() {
		return documentAttachmentId;
	}

	public void setDocumentAttachmentId(Integer documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		hash += (documentAttachmentId != null ? documentAttachmentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DocumentAttachment)) {
			return false;
		}
		DocumentAttachment other = (DocumentAttachment) object;
		if ((this.documentAttachmentId == null && other.documentAttachmentId != null)
				|| (this.documentAttachmentId != null && !this.documentAttachmentId.equals(other.documentAttachmentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.DocumentAttachment[documentAttachmentId=" + documentAttachmentId + "]";
	}

}
