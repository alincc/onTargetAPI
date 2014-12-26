package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectTaskFileDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskStatusCount;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private Logger logger = Logger.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private TaskEstimatedCostDAO taskEstimatedCostDAO;

    @Autowired
    private ProjectTaskFileDAO projectTaskFileDAO;

    @Autowired
    private EmailService emailService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean addTaskService(Task task) throws Exception {
        logger.info("Add/Update task: " + task);

        int taskId = task.getProjectTaskId();
        // validate times
        if (task.getProject() == null) {
            throw new Exception("task project is null");
        } else if (task.getStartDate().getTime() < task.getProject().getStartDate().getTime()) {
            throw new Exception("Task starts before project start date");
        } else if (task.getEndDate().getTime() > task.getProject().getEndDate().getTime()) {
            throw new Exception("Task ends after project end date");
        }

        Task parentTask = task.getParentTask();
        if (parentTask != null) {
            if (task.getStartDate().getTime() < parentTask.getStartDate().getTime()) {
                throw new Exception("Task starts before parent task start date");
            } else if (task.getEndDate().getTime() > parentTask.getEndDate().getTime()) {
                throw new Exception("Task ends after parent task end date");
            }
        }

        if (taskId <= 0) {
            taskId = taskDAO.addTask(task);
        } else {
            boolean updated = taskDAO.updateTask(task);
            if (!updated) {
                throw new Exception("Add/update task failed.");
            }
        }


        if (taskId == 0) {
            throw new Exception("Add/update task failed.");
        }

        // add project task assignee.


        return true;
    }

    @Override
    public List<Task> getTask(int projectId) throws Exception {
        return taskDAO.getTask(projectId);
    }

    @Override
    public List<TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception {
        return taskDAO.getTaskCountByStatus(projectId);
    }

    @Override
    public boolean addTaskComment(TaskComment comment) throws Exception {
        if (comment.getTaskCommentId() > 0) {
            return taskDAO.updateComment(comment);
        } else {
            int taskCommentId = taskDAO.addComment(comment);
            if (taskCommentId > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean updateTaskStatus(long taskId, String taskStatus) throws Exception {
        return taskDAO.updateTaskStatus(taskId, taskStatus);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Set<Long> getTaskMembers(long taskId) throws Exception {
        return taskDAO.getTaskMembers(taskId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception {
        return taskDAO.addTaskMember(projectId, taskId, memberId);
    }

    @Override
    public long saveTaskFile(long taskid, long userId, String fileName, String location) throws Exception {
        return projectTaskFileDAO.saveTaskFile(taskid, fileName, userId, location);
    }

    @Override
    public List<FileAttachment> getTaskAttachments(long taskId) throws Exception {
        return projectTaskFileDAO.getTaskAttachments(taskId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean assignTaskToUser(long taskId, long userId) throws Exception {
        boolean assigned = taskDAO.assignTaskToUser(taskId, userId);

        if (assigned) {
            emailService.sendTaskAssignmentEmail(taskId, userId);
        }

        return assigned;
    }


}
