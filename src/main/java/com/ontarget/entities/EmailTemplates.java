package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "email_templates")
public class EmailTemplates implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "email_template_id", nullable = false)
	private Integer emailTemplateId;
	@Basic(optional = false)
	@Column(name = "email_template_name", nullable = false, length = 255)
	private String emailTemplateName;
	@Basic(optional = false)
	@Column(name = "slug_name", nullable = false, length = 255)
	private String slugName;
	@Basic(optional = false)
	@Column(name = "subject", nullable = false, length = 255)
	private String subject;
	@Column(name = "body", nullable = false, length = 65535, columnDefinition = "TEXT")
	private String body;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;

	public EmailTemplates() {
	}

	public EmailTemplates(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	public EmailTemplates(Integer emailTemplateId, String emailTemplateName, String slugName, String subject, String body,
			Date createdDate, int createdBy, Date modifiedDate, int modifiedBy) {
		this.emailTemplateId = emailTemplateId;
		this.emailTemplateName = emailTemplateName;
		this.slugName = slugName;
		this.subject = subject;
		this.body = body;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	public Integer getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	public String getEmailTemplateName() {
		return emailTemplateName;
	}

	public void setEmailTemplateName(String emailTemplateName) {
		this.emailTemplateName = emailTemplateName;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (emailTemplateId != null ? emailTemplateId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EmailTemplates)) {
			return false;
		}
		EmailTemplates other = (EmailTemplates) object;
		if ((this.emailTemplateId == null && other.emailTemplateId != null)
				|| (this.emailTemplateId != null && !this.emailTemplateId.equals(other.emailTemplateId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.EmailTemplates[emailTemplateId=" + emailTemplateId + "]";
	}

}
