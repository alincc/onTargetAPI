package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_safety_info")
public class UserSafetyInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Long id;
	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 524)
	private String name;
	@Basic(optional = false)
	@Column(name = "info", nullable = false, length = 65535, columnDefinition = "TEXT")
	private String info;
	@Basic(optional = false)
	@Column(name = "discipline_id", nullable = false)
	private long disciplineId;
	@Basic(optional = false)
	@Column(name = "ts_create", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsCreate;

	public UserSafetyInfo() {
	}

	public UserSafetyInfo(Long id) {
		this.id = id;
	}

	public UserSafetyInfo(Long id, String name, String info, long disciplineId, Date tsCreate) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.disciplineId = disciplineId;
		this.tsCreate = tsCreate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public long getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(long disciplineId) {
		this.disciplineId = disciplineId;
	}

	public Date getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(Date tsCreate) {
		this.tsCreate = tsCreate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserSafetyInfo)) {
			return false;
		}
		UserSafetyInfo other = (UserSafetyInfo) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserSafetyInfo[id=" + id + "]";
	}

}
