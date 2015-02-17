package com.ontarget.api.service;

import java.util.List;
import java.util.Set;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskDTO;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

	public boolean addTaskService(Task task, int userId) throws Exception;

	public List<TaskDTO> getTask(int projectId) throws Exception;

	public boolean isTaskAdd(Task task);

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception;

	public TaskDTO getTaskDetail(int taskId) throws Exception;

	public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(
			int projectId) throws Exception;

	Contact addTaskComment(TaskCommentRequest comment) throws Exception;

	public boolean updateTaskStatus(int taskId, String taskStatus, int userId)
			throws Exception;

	public Set<Integer> getTaskMembers(int taskId) throws Exception;

	public boolean addTaskMember(int projectId, int taskId, int memberId)
			throws Exception;

	public long saveTaskFile(int taskid, int userId, String fileName,
			String location) throws Exception;

	public List<FileAttachment> getTaskAttachments(int taskId)
			throws Exception;

	public void assignTaskToUser(int taskId, List<Integer> users, int assigningUser)
			throws Exception;

	public List<TaskDTO> getDependentTasks(int taskId) throws Exception;

	public List<TaskDTO> getUserTasks(int userId) throws Exception;
}
