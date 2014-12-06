package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.util.OntargetUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

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
    public Map<Task,Map<TaskInterval, ProjectEarnedValueAnalysisReport>> getEarnedValueAnalysisReport(int projectId) throws Exception {
        logger.debug("Getting earned value analysis report: "+ projectId);
        //task planned cost
        Map<Task,Map<TaskInterval,TaskEstimatedCost>> taskPlannedCostByMonthAndYear = taskBudgetDAO.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.ESTIMATED);

        //task planned cost
        Map<Task,Map<TaskInterval,TaskEstimatedCost>> taskActualCostByMonthAndYear = taskBudgetDAO.getTaskToCostMapByMonthYear(projectId,OnTargetConstant.CostType.ACTUAL);


        if(taskPlannedCostByMonthAndYear.isEmpty()){
            return null;
        }

        //get all the time interval for the project
        Project project = projectDAO.getProject(projectId);
        Date startDate = project.getStartDate();
        Date endDate = project.getEndDate();
        List<TaskInterval> timeInterval = OntargetUtil.getTimeInterval(startDate, endDate);

        if(timeInterval.isEmpty()){
            return null;
        }

        Map<Task,Map<TaskInterval, ProjectEarnedValueAnalysisReport>> monthYearEarnedValueReportByTask = new LinkedHashMap<>();

        for (Map.Entry<Task, Map<TaskInterval,TaskEstimatedCost>> entry : taskPlannedCostByMonthAndYear.entrySet()) {
            Task task = entry.getKey();
            Map<TaskInterval,TaskEstimatedCost> monthYearEstimatedCost = entry.getValue();

            Map<TaskInterval, ProjectEarnedValueAnalysisReport> monthYearEarnedValueReport=monthYearEarnedValueReportByTask.get(task);

            if(monthYearEarnedValueReport == null){
                monthYearEarnedValueReport= new LinkedHashMap<>();
            }

            for(TaskInterval ti : timeInterval){
                TaskEstimatedCost cost = monthYearEstimatedCost.get(ti);

                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReport.get(ti);
                if(rpt == null){
                    rpt = new ProjectEarnedValueAnalysisReport();

                }

                monthYearEarnedValueReport.put(ti,rpt);
                double totalBudgetCost = rpt.getTotalBudgetedCost() + cost.getCost();
                rpt.setTotalBudgetedCost(totalBudgetCost);
            }
        }

        return monthYearEarnedValueReportByTask;
    }


    /**
     * calculate other reports per task;
     * @param reportMap
     */
    private void calculateEarnedValueAnalysisReport(Map<Task,Map<TaskInterval,ProjectEarnedValueAnalysisReport>> reportMap){







    }


}
