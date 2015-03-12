package com.ontarget.api.service;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.request.bean.TaskProgressInfo;

/**
 * Created by Owner on 11/25/14.
 */
public interface TaskPercentageService {

	public boolean addTaskPercentage(List<TaskProgress> taskProgressList,
			int addedBy) throws Exception;

	public boolean updateTaskPercentage(
			List<TaskProgressInfo> taskPercentageList, int modifiedBy)
			throws Exception;

	List<TaskPercentage> getTaskPercentageByTask(int taskId) throws Exception;

	Map<ProjectTaskInfo, List<TaskPercentage>> getTaskPercentageByProject(int projectId)
			throws Exception;
}
