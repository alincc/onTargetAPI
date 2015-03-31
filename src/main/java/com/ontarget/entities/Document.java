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
@Table(name = "document")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_id", nullable = false)
	private Integer documentId;
	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Basic(optional = false)
	@Column(name = "status", nullable = false, length = 45)
	private String status;
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
	@Basic(optional = false)
	@Column(name = "project_id", nullable = false)
	private int projectId;
	@Basic(optional = false)
	@Column(name = "due_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	@JoinColumn(name = "document_template_id", referencedColumnName = "document_template_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private DocumentTemplate documentTemplate;
	@OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
	private List<DocumentAttachment> documentAttachmentList;
	@OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
	private List<DocumentSubmittal> documentSubmittalList;

	public Document() {
	}

	public Document(Integer documentId) {
		this.documentId = documentId;
	}

	public Document(Integer documentId, String name, String status, String createdBy, Date createdDate, String modifiedBy,
			Date modifiedDate, int projectId, Date dueDate) {
		this.documentId = documentId;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.projectId = projectId;
		this.dueDate = dueDate;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public DocumentTemplate getDocumentTemplate() {
		return documentTemplate;
	}

	public void setDocumentTemplate(DocumentTemplate documentTemplate) {
		this.documentTemplate = documentTemplate;
	}

	public List<DocumentAttachment> getDocumentAttachmentList() {
		return documentAttachmentList;
	}

	public void setDocumentAttachmentList(List<DocumentAttachment> documentAttachmentList) {
		this.documentAttachmentList = documentAttachmentList;
	}

	public List<DocumentSubmittal> getDocumentSubmittalList() {
		return documentSubmittalList;
	}

	public void setDocumentSubmittalList(List<DocumentSubmittal> documentSubmittalList) {
		this.documentSubmittalList = documentSubmittalList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (documentId != null ? documentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Document)) {
			return false;
		}
		Document other = (Document) object;
		if ((this.documentId == null && other.documentId != null)
				|| (this.documentId != null && !this.documentId.equals(other.documentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Document[documentId=" + documentId + "]";
	}

}
