package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "states")
public class States implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "state_code", nullable = false, length = 2)
	private String stateCode;
	@Basic(optional = false)
	@Column(name = "state", nullable = false, length = 45)
	private String state;

	public States() {
	}

	public States(String stateCode) {
		this.stateCode = stateCode;
	}

	public States(String stateCode, String state) {
		this.stateCode = stateCode;
		this.state = state;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (stateCode != null ? stateCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof States)) {
			return false;
		}
		States other = (States) object;
		if ((this.stateCode == null && other.stateCode != null)
				|| (this.stateCode != null && !this.stateCode
						.equals(other.stateCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.States[stateCode=" + stateCode + "]";
	}

}
