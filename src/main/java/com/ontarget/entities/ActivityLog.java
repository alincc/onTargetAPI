package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "activity_log")
public class ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "text", nullable = false, length = 65535, columnDefinition = "TEXT")
	private String text;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne()
	private User user;
	@Column(name = "category")
	private Long category;
	@Basic(optional = false)
	@Column(name = "ts_insert", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsInsert;
	@Column(name = "project_id", nullable = true)
	private Integer projectId;

	public ActivityLog() {
	}

	public ActivityLog(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Date getTsInsert() {
		return tsInsert;
	}

	public void setTsInsert(Date tsInsert) {
		this.tsInsert = tsInsert;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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
		if (!(object instanceof ActivityLog)) {
			return false;
		}
		ActivityLog other = (ActivityLog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ActivityLog[id=" + id + "]";
	}

}
