package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
	@Column(name = "status", length = 45)
	private String status;
	@Column(name = "added_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private User user;

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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
