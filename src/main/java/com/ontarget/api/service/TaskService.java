package com.ontarget.api.service;

import java.util.List;
import java.util.Set;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectTask;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.response.bean.TaskResponse;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

	public TaskResponse addTaskService(Task task, int userId) throws Exception;

	public List<TaskInfo> getTask(Integer projectId) throws Exception;

	public List<ProjectTask> getTasksByProjectAndUser(Integer projectId,Integer userId) throws Exception;

	public boolean isTaskAdd(Task task);

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception;

	public TaskResponse getTaskDetail(int taskId) throws Exception;

	public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

	Contact addTaskComment(TaskCommentRequest comment) throws Exception;

	public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception;

	public Set<Integer> getTaskMembers(int taskId) throws Exception;

	public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception;

	public long saveTaskFile(int taskid, int userId, String fileName, String location) throws Exception;

	public List<FileAttachment> getTaskAttachments(int taskId) throws Exception;
	
	public OnTargetResponse deleteTaskAttachment(Integer taskFileId,int userId) throws Exception;

	public void assignTaskToUser(int taskId, List<Integer> users, int assigningUser) throws Exception;

	public boolean assignTaskToFieldworker(int taskId, List<Integer> users, int assigningUser) throws Exception;

	public List<ProjectTask> getDependentTasks(int taskId) throws Exception;

	public List<ProjectTask> getUserTasks(int userId) throws Exception;

	public boolean deleteTask(int taskId, int userId) throws Exception;

	public FieldWorkerResponse getFieldWorkersByTask(int taskId) throws Exception;

	public com.ontarget.response.bean.TaskListResponse getTaskListByProjectAndUser(Integer projectId,Integer userId) throws Exception;

}
