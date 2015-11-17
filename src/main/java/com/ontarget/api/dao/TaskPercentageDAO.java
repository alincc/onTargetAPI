package com.ontarget.api.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.request.bean.TaskProgress;

/**
 * Created by Owner on 11/24/14.
 */
@Repository
public interface TaskPercentageDAO {

	public Map<ProjectTaskInfo, List<TaskPercentage>> getTaskPercentageCompletes(int projectId) throws Exception;

	public Map<TaskInfo, Map<TaskInterval, TaskPercentage>> getTaskPercentageCompletesByMonthYear(long projectId) throws Exception;

    Map<TaskInfo, Map<TaskInterval, TaskPercentage>> getTaskPercentageCompletesByMonthYearTemp(Integer projectId) throws Exception;

    public int addTaskPercentageComplete(TaskProgress taskProgress, int addedBy) throws Exception;

	public int updateTaskPercentageComplete(TaskProgress taskProgress, int addedBy) throws Exception;

	boolean expireTaskPercentage(int taskPercentageLogId) throws Exception;

	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception;

	public TaskPercentage getExistingTaskPercentageForTheMonth(int taskId) throws Exception;
}
