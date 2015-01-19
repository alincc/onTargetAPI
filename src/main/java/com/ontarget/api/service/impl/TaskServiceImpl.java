package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.*;
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private ProjectDAO projectDAO;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static final TimeZone cst = TimeZone.getTimeZone("America/Chicago");

    static {
        format.setTimeZone(cst);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean addTaskService(Task task, int userId) throws Exception {
        logger.info("Add/Update task: " + task);

        String startDateText = task.getStartDateText();
        if (startDateText != null && !startDateText.isEmpty()) {
            Date parse = format.parse(startDateText);

            Calendar calendar = Calendar.getInstance(cst);
            calendar.setTimeInMillis(parse.getTime());
            calendar.setTimeZone(cst);
            parse = calendar.getTime();
            logger.info("this is start date " + parse + " parsed from " + startDateText);
            task.setStartDate(parse);
        }

        String endDateText = task.getEndDateText();
        if (endDateText != null && !endDateText.isEmpty()) {
            Date parse = format.parse(endDateText);
            logger.info("this is end date " + parse + " parsed from " + endDateText);
            task.setEndDate(parse);
        }

        int taskId = task.getProjectTaskId();
        // validate times
        Date startDate = task.getStartDate();
        Date endDate = task.getEndDate();
        if (task.getProject() == null) {
            throw new Exception("task project is null");
        } else {
            Date projectStartDate = task.getProject().getStartDate();
            Date projectEndDate = task.getProject().getEndDate();
            if (projectStartDate == null || projectEndDate == null) {
                Project project = projectDAO.getProject(task.getProject().getProjectId());
                logger.info("start and end date of project is null so getting new project " + project.toString());
                if (project == null) {
                    throw new Exception("project is invalid for task");
                }
                task.setProject(project);
                projectStartDate = project.getStartDate();
                projectEndDate = project.getEndDate();
            }

            if (startDate.getTime() < projectStartDate.getTime()) {
//                throw new Exception("Task starts before project start date");
                logger.info(startDate.toString() + " less than " + projectStartDate.toString());
                throw new DateBeforeException("Task starts before project start date");
            } else {
                if (endDate.getTime() > projectEndDate.getTime()) {
//                    throw new Exception("Task ends after project end date");
                    logger.info(endDate.toString() + " more than " + projectEndDate.toString());
                    throw new DateAfterException("Task ends after project end date");
                }
            }
        }

        Task parentTask = task.getParentTask();
        if (parentTask != null) {
            Date parentTaskStartDate = parentTask.getStartDate();
            Date parentTaskEndDate = parentTask.getEndDate();
            if (parentTaskStartDate == null || parentTaskEndDate == null) {
                parentTask = taskDAO.getTaskDetail(parentTask.getProjectTaskId());
                if (parentTask == null) {
                    throw new Exception("parent task does not exists");
                }
                parentTaskStartDate = parentTask.getStartDate();
                parentTaskEndDate = parentTask.getEndDate();
            }

            if (parentTaskStartDate != null && startDate.getTime() < parentTaskStartDate.getTime()) {
                logger.info(startDate.toString() + " less than " + parentTaskStartDate.toString());
                throw new DateBeforeException("Task starts before parent task start date");
//                throw new Exception("Task starts before parent task start date");
            } else {
                if (parentTaskEndDate != null && endDate.getTime() > parentTaskEndDate.getTime()) {
                    logger.info(endDate.toString() + " more than " + parentTaskEndDate.toString());
                    throw new DateAfterException("Task ends after parent task end date");
//                    throw new Exception("Task ends after parent task end date");
                }
            }
        }

        if (isTaskAdd(taskId)) {
            taskId = taskDAO.addTask(task, userId);
        } else {
            boolean updated = taskDAO.updateTask(task, userId);
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

    public boolean isTaskAdd(Task task) {
        int taskId = task.getProjectTaskId();
        return isTaskAdd(taskId);
    }

    private boolean isTaskAdd(int taskId) {
        return taskId <= 0;
    }

    @Override
    public List<Task> getTask(int projectId) throws Exception {
        return taskDAO.getTask(projectId);
    }

    public int addDependentTask(DependentTask dependentTask) throws Exception {
        return taskDAO.addDependentTask(dependentTask);
    }

    public Task getTaskDetail(int taskId) throws Exception {
        Task task = taskDAO.getTaskDetail(taskId);
        Long assignedUserId = taskDAO.getAssignedUser(task.getProjectTaskId());
        if (assignedUserId > 0) {
            User assignedToUser = new User();
            assignedToUser.setUserId(assignedUserId.intValue());
            task.setAssignedTo(assignedToUser);
        }
        else {
            logger.info("task is unassigned");
        }
        setTaskLevel(task, 1);
        return task;
    }

    public List<Task> setTaskLevel(Task task, int level) throws Exception {
        List<Task> childTasks = taskDAO.getChildTasks(task.getProjectTaskId());
        if (level < 20 && childTasks != null && !childTasks.isEmpty()) {
            level++;
            for (Task p : childTasks) {
                setTaskLevel(p, level);
            }
        }

        task.setChildTasks(childTasks);
        return childTasks;
    }

    @Override
    public List<TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception {
        return taskDAO.getTaskCountByStatus(projectId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
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
    public boolean updateTaskStatus(long taskId, String taskStatus, int userId) throws Exception {
        return taskDAO.updateTaskStatus(taskId, taskStatus, userId);
    }

    @Override
    public Set<Long> getTaskMembers(long taskId) throws Exception {
        return taskDAO.getTaskMembers(taskId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception {
        return taskDAO.addTaskMember(projectId, taskId, memberId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public long saveTaskFile(long taskid, long userId, String fileName, String location) throws Exception {
        return projectTaskFileDAO.saveTaskFile(taskid, fileName, userId, location);
    }

    @Override
    public List<FileAttachment> getTaskAttachments(long taskId) throws Exception {
        List<FileAttachment> taskAttachments = projectTaskFileDAO.getTaskAttachments(taskId);
        Map<Long, Contact> contactSet = new HashMap<>();
        for (FileAttachment fileAttachment : taskAttachments) {
            long userId = fileAttachment.getUserId();
            if (contactSet.containsKey(userId)) {
                fileAttachment.setContact(contactSet.get(userId));
            } else {
                Contact c = contactDAO.getContact(userId);
                contactSet.put(userId, c);
                fileAttachment.setContact(c);
            }
        }

        return taskAttachments;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean assignTaskToUser(long taskId, long userId, int assigningUser) throws Exception {
//        Long assignedTo = taskDAO.getAssignedUser(taskId);
        boolean assigned = false;
//        if (assignedTo > 0) {
//            logger.info("updating user "+userId+ " for task "+taskId);
//            assigned = taskDAO.updateTaskAssignee(taskId, userId, assigningUser);
//        } else {
            logger.info("inserting user "+userId+ " for task "+taskId);
            assigned = taskDAO.assignTaskToUser(taskId, userId, assigningUser);
//        }

        if (assigned) {
            // get contact detail by userId
            Contact contact = contactDAO.getContact(userId);
            Task task = taskDAO.getTaskDetail(taskId);
            if (contact != null) {
                emailService.sendTaskAssignmentEmail(task, contact);
            }
        }

        return assigned;
    }

    public List<Task> getDependentTasks(long taskId) throws Exception {
        return taskDAO.getDependentTasks(taskId);
    }
}
