package com.ontarget.api.response;

import com.ontarget.bean.TaskBurndownReport;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;

/**
 * Created by sanjeevghimire on 8/22/15.
 */
public class TaskBurnDownResponse extends OnTargetResponse {


    public TaskBurnDownResponse() {
    }


    private List<TaskBurndownReport> taskBurndownReportList;


    public List<TaskBurndownReport> getTaskBurndownReportList() {
        return taskBurndownReportList;
    }

    public void setTaskBurndownReportList(List<TaskBurndownReport> taskBurndownReportList) {
        this.taskBurndownReportList = taskBurndownReportList;
    }
}
