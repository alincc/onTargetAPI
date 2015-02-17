package com.ontarget.api.response;

import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/2/14.
 */
public class TaskPercentageResponse extends OnTargetResponse{

    private Map<TaskDTO,List<TaskPercentage>> taskListMap;


    public Map<TaskDTO, List<TaskPercentage>> getTaskListMap() {
        return taskListMap;
    }

    public void setTaskListMap(Map<TaskDTO, List<TaskPercentage>> taskListMap) {
        this.taskListMap = taskListMap;
    }
}
