package com.ontarget.api.response;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 12/2/14.
 */
public class TaskPercentageResponse extends OnTargetResponse {

	private Map<ProjectTaskInfo, List<TaskPercentage>> taskListMap;

	public Map<ProjectTaskInfo, List<TaskPercentage>> getTaskListMap() {
		return taskListMap;
	}

	public void setTaskListMap(Map<ProjectTaskInfo, List<TaskPercentage>> taskListMap) {
		this.taskListMap = taskListMap;
	}

}
