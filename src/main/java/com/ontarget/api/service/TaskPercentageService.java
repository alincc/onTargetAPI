package com.ontarget.api.service;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskPercentage;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/25/14.
 */
public interface TaskPercentageService {

    public boolean addTaskPercentage(List<TaskPercentage> taskPercentageList) throws Exception;

    public boolean updateTaskPercentage(List<TaskPercentage> taskPercentageList) throws Exception;

    List<TaskPercentage> getTaskPercentageByTask(int taskId) throws Exception;

    Map<Task,List<TaskPercentage>> getTaskPercentageByProject(int projectId) throws Exception;
}
