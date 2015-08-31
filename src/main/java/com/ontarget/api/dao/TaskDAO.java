package com.ontarget.api.dao;

import java.util.List;
import java.util.Set;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskObj;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.dto.ProjectTask;
import com.ontarget.entities.TaskFieldWorker;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

	public int addTask(Task task, int userId) throws Exception;

	public com.ontarget.entities.ProjectTask getProjectTaskById(int projectTaskId);

	public List<TaskInfo> getTask(int projectId) throws Exception;

	public List<TaskInfo> getAssignedTasksByProjectId(int projectId, int userId) throws Exception;

	public List<TaskObj> getTaskObjList(int projectId) throws Exception;

	public List<ProjectTask> getTasksByActivityAndUser(int projectId,int userId) throws Exception;

	public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

	public boolean updateComment(TaskCommentRequest comment) throws Exception;

	public int addComment(TaskCommentRequest comment) throws Exception;

	public List<TaskComment> getTaskComments(int projectTaskId) throws Exception;

	public boolean updateTask(Task task, int userId) throws Exception;

	public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception;

	public Set<Integer> getTaskMembers(int taskId) throws Exception;

	public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception;

	public boolean deleteAllTaskAssignedUsers(int taskId) throws Exception;

	public List<Integer> assignTaskToUser(int taskId, int userId, List<Integer> assignees) throws Exception;
	
	public boolean assignTaskToFieldworker(int taskId, int userId, List<Integer> fieldWorkerIds) throws Exception;

	boolean updateTaskAssignee(int taskId, int userId, int assigningUser) throws Exception;

	public Integer getAssignedUser(int taskId) throws Exception;

	public ProjectTask getTaskDetail(int taskId) throws Exception;

	public ProjectTaskInfo getTaskInfo(int taskId) throws Exception;

	public List<ProjectTask> getChildTasks(int taskId) throws Exception;

	public List<ProjectTask> getDependentTasks(int taskId) throws Exception;

	public List<ProjectTask> getUserTasks(int userId) throws Exception;

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception;

	public List<TaskInfo> getTask(int projectId, int completed) throws Exception;

	public boolean deleteTask(int taskId, int userId) throws Exception;
	
	public List<TaskFieldWorker> getTaskFieldWorkersByTask(int taskId) throws Exception;
	
	public List<com.ontarget.entities.ProjectTask> getProjectTaskByProjectId(int projectId);
	
	public Contact getContact(int userId) throws Exception;
	
	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception;
}
