package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/3/14.
 */
public class ProjectReportServiceImpl implements ProjectReportService {


    private Logger logger = Logger.getLogger(ProjectReportServiceImpl.class);

    @Autowired
    private TaskBudgetDAO taskBudgetDAO;

    @Autowired
    private TaskPercentageDAO taskPercentageDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public Map<TaskInterval, ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception {
        logger.debug("Getting earned value analysis report: "+ projectId);
        Map<Task, List<TaskEstimatedCost>> taskCostByMonthAndYear= taskBudgetDAO.getTaskToCostMap(projectId, OnTargetConstant.CostType.PLANNED);

        if(taskCostByMonthAndYear.isEmpty()){
            return null;
        }

        Project project = projectDAO.getProject(projectId);
        Date startDate = project.getStartDate();
        Date endDate = project.getEndDate();


        Map<TaskInterval, Double> totalBudgetedCost = new HashMap<>();


        for (Map.Entry<Task, List<TaskEstimatedCost>> entry : taskCostByMonthAndYear.entrySet()) {
           // double totalBudgetedCost = 0.0;








        }

        return null;
    }


}
