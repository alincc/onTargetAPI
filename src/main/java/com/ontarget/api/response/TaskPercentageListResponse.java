package com.ontarget.api.response;

import com.ontarget.bean.TaskPercentage;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;

/**
 * Created by Owner on 12/2/14.
 */
public class TaskPercentageListResponse extends OnTargetResponse{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TaskPercentage> taskPercentageList;


    public List<TaskPercentage> getTaskPercentageList() {
        return taskPercentageList;
    }

    public void setTaskPercentageList(List<TaskPercentage> taskPercentageList) {
        this.taskPercentageList = taskPercentageList;
    }
}
