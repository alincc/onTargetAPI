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
@Table(name = "document_template")
public class DocumentTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "document_template_id", nullable = false)
	private Integer documentTemplateId;
	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 45)
	private String name;
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
	@Column(name = "modfied_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modfiedDate;
	@OneToMany(mappedBy = "documentTemplate", fetch = FetchType.LAZY)
	private List<Document> documentList;

	public DocumentTemplate() {
	}

	public DocumentTemplate(Integer documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}

	public Integer getDocumentTemplateId() {
		return documentTemplateId;
	}

	public void setDocumentTemplateId(Integer documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getModfiedDate() {
		return modfiedDate;
	}

	public void setModfiedDate(Date modfiedDate) {
		this.modfiedDate = modfiedDate;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (documentTemplateId != null ? documentTemplateId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DocumentTemplate)) {
			return false;
		}
		DocumentTemplate other = (DocumentTemplate) object;
		if ((this.documentTemplateId == null && other.documentTemplateId != null)
				|| (this.documentTemplateId != null && !this.documentTemplateId.equals(other.documentTemplateId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.DocumentTemplate[documentTemplateId=" + documentTemplateId + "]";
	}

}
