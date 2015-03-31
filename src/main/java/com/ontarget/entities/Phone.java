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
@Table(name = "phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "phone_id", nullable = false)
	private Integer phoneId;
	@Column(name = "area_code")
	private Integer areaCode;
	@Column(name = "phone_number", length = 45)
	private String phoneNumber;
	@Column(name = "phone_type", length = 45)
	private String phoneType;
	@Column(name = "status", length = 45)
	private String status;
	@JoinColumn(name = "contact_id", referencedColumnName = "contact_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Contact contact;

	public Phone() {
	}

	public Phone(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
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
		hash += (phoneId != null ? phoneId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Phone)) {
			return false;
		}
		Phone other = (Phone) object;
		if ((this.phoneId == null && other.phoneId != null)
				|| (this.phoneId != null && !this.phoneId.equals(other.phoneId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Phone[phoneId=" + phoneId + "]";
	}

}
