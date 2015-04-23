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
@Table(name = "email")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "email_id", nullable = false)
	private Integer emailId;
	@Column(name = "email_address", length = 45)
	private String emailAddress;
	@Column(name = "email_type", length = 45)
	private String emailType;
	@Column(name = "status", length = 45)
	private String status;
	@JoinColumn(name = "contact_id", referencedColumnName = "contact_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Contact contact;

	public Email() {
	}

	public Email(Integer emailId) {
		this.emailId = emailId;
	}

	public Integer getEmailId() {
		return emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (emailId != null ? emailId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Email)) {
			return false;
		}
		Email other = (Email) object;
		if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Email[emailId=" + emailId + "]";
	}

}
