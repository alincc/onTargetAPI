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
@Table(name = "project_member")
public class ProjectMember implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_member_id", nullable = false)
	private Integer projectMemberId;
	@Column(name = "member_status", length = 45)
	private String memberStatus;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne()
	private User user;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Project project;

	public ProjectMember() {
	}

	public ProjectMember(Integer projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public Integer getProjectMemberId() {
		return projectMemberId;
	}

	public void setProjectMemberId(Integer projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectMemberId != null ? projectMemberId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectMember)) {
			return false;
		}
		ProjectMember other = (ProjectMember) object;
		if ((this.projectMemberId == null && other.projectMemberId != null)
				|| (this.projectMemberId != null && !this.projectMemberId.equals(other.projectMemberId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectMember[projectMemberId=" + projectMemberId + "]";
	}

}
