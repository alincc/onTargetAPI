package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "time_card")
public class TimeCard implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@JoinColumn(name = "recorded_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User recordedBy;
	@Basic(optional = false)
	@Column(name = "recorded_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordedDate;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;
	@Column(name = "name", length = 150)
	private String name;
	@Basic(optional = false)
	@Column(name = "time_in", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeIn;
	@Basic(optional = false)
	@Column(name = "time_out", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeOut;

	public TimeCard() {
	}

	public TimeCard(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getRecordedBy() {
		return recordedBy;
	}

	public void setRecordedBy(User recordedBy) {
		this.recordedBy = recordedBy;
	}

	public Date getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
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
		if (!(object instanceof TimeCard)) {
			return false;
		}
		TimeCard other = (TimeCard) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TimeCard[id=" + id + "]";
	}

}
