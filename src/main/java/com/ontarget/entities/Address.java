/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ontarget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "address_id", nullable = false)
	private Integer addressId;
	@Basic(optional = false)
	@Column(name = "address1", nullable = false, length = 150)
	private String address1;
	@Column(name = "address2", length = 20)
	private String address2;
	@Column(name = "city", length = 45)
	private String city;
	@Basic(optional = false)
	@Column(name = "state", nullable = false, length = 5)
	private String state;
	@Column(name = "zip", length = 10)
	private String zip;
	@Basic(optional = false)
	@Column(name = "country", nullable = false, length = 20)
	private String country;
	@Column(name = "address_type", length = 45)
	private String addressType;
	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	private List<Project> projectList;

	public Address() {
	}

	public Address(Integer addressId) {
		this.addressId = addressId;
	}

	public Address(Integer addressId, String address1, String state,
			String country) {
		this.addressId = addressId;
		this.address1 = address1;
		this.state = state;
		this.country = country;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (addressId != null ? addressId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Address)) {
			return false;
		}
		Address other = (Address) object;
		if ((this.addressId == null && other.addressId != null)
				|| (this.addressId != null && !this.addressId
						.equals(other.addressId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Address[addressId=" + addressId + "]";
	}

}
