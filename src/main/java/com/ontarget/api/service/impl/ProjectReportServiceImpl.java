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
    public Map<TaskInterval, ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception {
        logger.debug("Getting earned value analysis report: "+ projectId);
        //task planned cost
        Map<Task,Map<TaskInterval,TaskEstimatedCost>> taskPlannedCostByMonthAndYear = taskBudgetDAO.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.ESTIMATED);

        //task actual cost
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

        Map<TaskInterval, ProjectEarnedValueAnalysisReport> monthYearEarnedValueReportByTask = new LinkedHashMap<>();


        /**
         * calculate total estimated cost by month and year
         */
        for (Map.Entry<Task, Map<TaskInterval,TaskEstimatedCost>> entry : taskPlannedCostByMonthAndYear.entrySet()) {
            Task task = entry.getKey();
            Map<TaskInterval,TaskEstimatedCost> monthYearEstimatedCost = entry.getValue();

            for(TaskInterval ti : timeInterval){
                TaskEstimatedCost cost = monthYearEstimatedCost.get(ti);

                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(ti);
                if(rpt == null){
                    rpt = new ProjectEarnedValueAnalysisReport();

                }

                monthYearEarnedValueReportByTask.put(ti,rpt);
                double totalBudgetCost = rpt.getTotalBudgetedCost() + cost.getCost();
                rpt.setTotalBudgetedCost(totalBudgetCost);
            }

        }


        /**
         * calculate total actual cost by month year
         */

        for (Map.Entry<Task, Map<TaskInterval,TaskEstimatedCost>> entry : taskActualCostByMonthAndYear.entrySet()) {
            Task task = entry.getKey();
            Map<TaskInterval,TaskEstimatedCost> monthYearActualCost = entry.getValue();

            for(TaskInterval ti : timeInterval){
                TaskEstimatedCost cost = monthYearActualCost.get(ti);

                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(ti);
                if(rpt == null){
                    rpt = new ProjectEarnedValueAnalysisReport();

                }
                monthYearEarnedValueReportByTask.put(ti,rpt);
                double totalActualCost = rpt.getTotalActualCost() + cost.getCost();
                rpt.setTotalActualCost(totalActualCost);
            }

        }

        calculateEarnedValueAnalysisReport(monthYearEarnedValueReportByTask);

        return monthYearEarnedValueReportByTask;
    }


    /**
     * calculate other reports per task;
     * @param reportMap
     */
    private void calculateEarnedValueAnalysisReport(Map<TaskInterval,ProjectEarnedValueAnalysisReport> reportMap){


        /**
         * calculate cumulative planned value.
         */

        double cumulativePlannedValue =0.0;
        double cumulativeActualValue=0.0;
        for (Map.Entry<TaskInterval,ProjectEarnedValueAnalysisReport> entry : reportMap.entrySet()) {

            TaskInterval interval=entry.getKey();
            ProjectEarnedValueAnalysisReport report = entry.getValue();

            cumulativePlannedValue+=report.getTotalBudgetedCost();
            report.setCumulativePlannedValue(cumulativePlannedValue);

            cumulativeActualValue+=report.getTotalActualCost();
            report.setCumulativePlannedValue(cumulativeActualValue);

        }


        /**
         * calculate cumulative earned value.
         */

        for (Map.Entry<TaskInterval,ProjectEarnedValueAnalysisReport> entry : reportMap.entrySet()) {



        }





    }


}
