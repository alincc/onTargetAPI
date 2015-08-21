package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "project_task")
public class ProjectTask implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_task_id", nullable = false)
	private Integer projectTaskId;
	@Basic(optional = false)
	@Column(name = "title", nullable = false, length = 200)
	private String title;
	@Column(name = "parent_task_id")
	private Integer parentTaskId;
	@Column(name = "status", length = 10)
	private String status;
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;
	@Column(name = "created_by", insertable = false, updatable = false)
	private Integer creatorId;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@Column(name = "severity", length = 45)
	private String severity;
	@Column(name = "description", length = 65535, columnDefinition = "TEXT")
	private String description;
	@Column(name = "task_percentage")
	private Integer taskPercentage;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<ProjectTaskComments> projectTaskCommentsList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<DependentTask> dependentTaskList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<ProjectTaskFiles> projectTaskFilesList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<ProjectActivities> projectActivitiesList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<TaskPercentageLog> taskPercentageLogList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<PlannedActualsCost> plannedActualsCostList;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
	@ManyToOne(optional = false)
	private Project project;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<TaskComment> taskCommentList;
	@OneToMany(mappedBy = "projectTask", fetch = FetchType.LAZY)
	private List<TaskAssignee> taskAssigneeList;

	public ProjectTask() {
	}

	public ProjectTask(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public ProjectTask(Integer projectTaskId, String title) {
		this.projectTaskId = projectTaskId;
		this.title = title;
	}

	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(Integer parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectTaskComments> getProjectTaskCommentsList() {
		return projectTaskCommentsList;
	}

	public void setProjectTaskCommentsList(List<ProjectTaskComments> projectTaskCommentsList) {
		this.projectTaskCommentsList = projectTaskCommentsList;
	}

	public List<ProjectTaskFiles> getProjectTaskFilesList() {
		return projectTaskFilesList;
	}

	public void setProjectTaskFilesList(List<ProjectTaskFiles> projectTaskFilesList) {
		this.projectTaskFilesList = projectTaskFilesList;
	}

	public List<ProjectActivities> getProjectActivitiesList() {
		return projectActivitiesList;
	}

	public void setProjectActivitiesList(List<ProjectActivities> projectActivitiesList) {
		this.projectActivitiesList = projectActivitiesList;
	}

	public List<TaskPercentageLog> getTaskPercentageLogList() {
		return taskPercentageLogList;
	}

	public void setTaskPercentageLogList(List<TaskPercentageLog> taskPercentageLogList) {
		this.taskPercentageLogList = taskPercentageLogList;
	}

	public List<PlannedActualsCost> getPlannedActualsCostList() {
		return plannedActualsCostList;
	}

	public void setPlannedActualsCostList(List<PlannedActualsCost> plannedActualsCostList) {
		this.plannedActualsCostList = plannedActualsCostList;
	}

	public List<DependentTask> getDependentTaskList() {
		return dependentTaskList;
	}

	public void setDependentTaskList(List<DependentTask> dependentTaskList) {
		this.dependentTaskList = dependentTaskList;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<TaskComment> getTaskCommentList() {
		return taskCommentList;
	}

	public void setTaskCommentList(List<TaskComment> taskCommentList) {
		this.taskCommentList = taskCommentList;
	}

	public List<TaskAssignee> getTaskAssigneeList() {
		return taskAssigneeList;
	}

	public void setTaskAssigneeList(List<TaskAssignee> taskAssigneeList) {
		this.taskAssigneeList = taskAssigneeList;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getTaskPercentage() {
		return taskPercentage;
	}

	public void setTaskPercentage(Integer taskPercentage) {
		this.taskPercentage = taskPercentage;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectTaskId != null ? projectTaskId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectTask)) {
			return false;
		}
		ProjectTask other = (ProjectTask) object;
		if ((this.projectTaskId == null && other.projectTaskId != null)
				|| (this.projectTaskId != null && !this.projectTaskId.equals(other.projectTaskId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectTask[projectTaskId=" + projectTaskId + "]";
	}

}
