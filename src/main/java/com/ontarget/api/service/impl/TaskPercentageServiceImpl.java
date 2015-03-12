package com.ontarget.api.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.service.TaskPercentageService;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskObj;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.request.bean.TaskProgressInfo;

/**
 * Created by Owner on 11/25/14.
 */
@Service
public class TaskPercentageServiceImpl implements TaskPercentageService {

	private Logger logger = Logger.getLogger(TaskPercentageServiceImpl.class);

	@Autowired
	private TaskPercentageDAO taskPercentageDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskPercentage(List<TaskProgress> taskProgressList,
			int addedBy) throws Exception {
		logger.debug("adding task percentage info : " + taskProgressList);

		if (taskProgressList != null && taskProgressList.size() > 0) {
			for (TaskProgress taskProgress : taskProgressList) {

				// figure if the task for the start date of the month already
				// exists. if exists expire and add a new one.
				TaskPercentage tpFromDatabase = taskPercentageDAO
						.getExistingTaskPercentageForTheMonth(taskProgress
								.getTaskId());
				if (tpFromDatabase.getId() > 0) {
					boolean expired = taskPercentageDAO
							.expireTaskPercentage(tpFromDatabase.getId());
					if (!expired) {
						throw new Exception(
								"Error while expiring task percentage.");
					}
				}

				int id = taskPercentageDAO.addTaskPercentageComplete(
						taskProgress, addedBy);
				if (id <= 0) {
					throw new Exception("Task Percentage could not be added: "
							+ taskProgress);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean updateTaskPercentage(
			List<TaskProgressInfo> taskPercentageList, int modifiedBy)
			throws Exception {
		logger.debug("updating task percentage info : " + taskPercentageList);

		if (taskPercentageList != null && taskPercentageList.size() > 0) {
			for (TaskProgressInfo taskPercentage : taskPercentageList) {
				boolean updated = taskPercentageDAO
						.updateTaskPercentageComplete(taskPercentage,
								modifiedBy);
				if (!updated) {
					throw new Exception(
							"Task Percentage could not be updated: "
									+ taskPercentage);
				}
			}
		}
		return true;
	}

	@Override
	public List<TaskPercentage> getTaskPercentageByTask(int taskId)
			throws Exception {
		logger.debug("Getting list of percentage complete for task: " + taskId);
		return taskPercentageDAO.getTaskPercentageByTask(taskId);
	}

	@Override
	public Map<ProjectTaskInfo, List<TaskPercentage>> getTaskPercentageByProject(
			int projectId) throws Exception {
		logger.debug("Getting list of percentage complete for project: "
				+ projectId);
		return taskPercentageDAO.getTaskPercentageCompletes(projectId);
	}

}
