package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.response.BIReportResponse;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.enums.TaskStatus;
import com.ontarget.util.OntargetUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Owner on 12/3/14.
 */
@Service
public class ProjectReportServiceImpl implements ProjectReportService {


    private Logger logger = Logger.getLogger(ProjectReportServiceImpl.class);

    @Autowired
    private TaskBudgetDAO taskBudgetDAO;

    @Autowired
    private TaskPercentageDAO taskPercentageDAO;

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public List<ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception {
        logger.debug("Getting earned value analysis report: " + projectId);
        //task planned cost
        Map<Task, Map<TaskInterval, TaskEstimatedCost>> taskPlannedCostByMonthAndYear = taskBudgetDAO.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.PLANNED);

        //task actual cost
        Map<Task, Map<TaskInterval, TaskEstimatedCost>> taskActualCostByMonthAndYear = taskBudgetDAO.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.ACTUAL);

        //task percentage
        Map<Task, Map<TaskInterval, TaskPercentage>> taskPercentageByMonthAndYear = taskPercentageDAO.getTaskPercentageCompletesByMonthYear(projectId);

        //Total budgeted cost
        Map<Task, Double> totalTaskBudgetCost = new HashMap<>();


        if (taskPlannedCostByMonthAndYear.isEmpty()) {
            return null;
        }

        //get all the time interval for the project
        Project project = projectDAO.getProject(projectId);
        Date startDate = project.getStartDate();
        Date endDate = project.getEndDate();
        List<TaskInterval> timeInterval = OntargetUtil.getTimeInterval(startDate, endDate);

        if (timeInterval.isEmpty()) {
            return null;
        }

        Map<TaskInterval, ProjectEarnedValueAnalysisReport> monthYearEarnedValueReportByTask = new LinkedHashMap<>();


        /**
         * calculate total estimated cost by month and year
         */
        for (Map.Entry<Task, Map<TaskInterval, TaskEstimatedCost>> entry : taskPlannedCostByMonthAndYear.entrySet()) {
            Task task = entry.getKey();
            Map<TaskInterval, TaskEstimatedCost> monthYearEstimatedCost = entry.getValue();

            for (TaskInterval ti : timeInterval) {
                TaskEstimatedCost cost = monthYearEstimatedCost.get(ti);
                double monthYearCost = 0.0;
                if(cost != null){
                    monthYearCost=cost.getCost();
                }

                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(ti);
                if (rpt == null) {
                    rpt = new ProjectEarnedValueAnalysisReport();

                }

                monthYearEarnedValueReportByTask.put(ti, rpt);
                double totalBudgetCost = rpt.getTotalBudgetedCost() + monthYearCost;
                rpt.setTotalBudgetedCost(totalBudgetCost);
            }


            /**
             * total budget of the task.
             */

            double totalTaskCost = 0.0;
            for (Map.Entry<TaskInterval, TaskEstimatedCost> eachTaskCostByMonthYear : monthYearEstimatedCost.entrySet()) {
                TaskEstimatedCost cost = eachTaskCostByMonthYear.getValue();
                double monthYearCost = 0.0;
                if(cost != null){
                    monthYearCost=cost.getCost();
                }
                totalTaskCost += monthYearCost;
            }
            totalTaskBudgetCost.put(task, totalTaskCost);
        }


        /**
         * calculate total actual cost by month year
         */

        for (Map.Entry<Task, Map<TaskInterval, TaskEstimatedCost>> entry : taskActualCostByMonthAndYear.entrySet()) {
            Task task = entry.getKey();
            Map<TaskInterval, TaskEstimatedCost> monthYearActualCost = entry.getValue();

            for (TaskInterval ti : timeInterval) {
                TaskEstimatedCost cost = monthYearActualCost.get(ti);
                double monthYearCost = 0.0;
                if(cost != null){
                    monthYearCost=cost.getCost();
                }

                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(ti);
                if (rpt == null) {
                    rpt = new ProjectEarnedValueAnalysisReport();

                }
                monthYearEarnedValueReportByTask.put(ti, rpt);
                double totalActualCost = rpt.getTotalActualCost() + monthYearCost;
                rpt.setTotalActualCost(totalActualCost);
            }

        }


        /**
         * Calculate cumulative earned value
         */

        calculateCumulativeEarnedValue(monthYearEarnedValueReportByTask, taskPercentageByMonthAndYear, totalTaskBudgetCost);

       return  calculateEarnedValueAnalysisReport(monthYearEarnedValueReportByTask,totalTaskBudgetCost);

    }

    @Override
    public BIReportResponse getTimeSaved(int projectId) throws Exception{

        // get all task done within time.
        List<Task> tasks = taskDAO.getTask(projectId, TaskStatus.COMPLETED.getTaskStatusId());

        //get all approved documents on time.


        //get SPI






        return null;
    }


    /**
     * Calculate cumulative earned value
     */
    private void calculateCumulativeEarnedValue(Map<TaskInterval, ProjectEarnedValueAnalysisReport> monthYearEarnedValueReportByTask, Map<Task, Map<TaskInterval, TaskPercentage>> taskPercentageByMonthAndYear, Map<Task, Double> totalTaskBudgetCost) {

        for (Map.Entry<Task, Map<TaskInterval, TaskPercentage>> entry : taskPercentageByMonthAndYear.entrySet()) {

            Task task = entry.getKey();
            Map<TaskInterval, TaskPercentage> monthYearTaskPercentage = entry.getValue();

            double totalBudgetCost = totalTaskBudgetCost.get(task);

            for (Map.Entry<TaskInterval, TaskPercentage> taskIntervalTaskPercentageEntry : monthYearTaskPercentage.entrySet()) {
                TaskInterval taskInterval = taskIntervalTaskPercentageEntry.getKey();
                ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(taskInterval);
                double cumulativeEV = rpt.getCumulativeEarnedValue() + monthYearTaskPercentage.get(taskInterval).getTaskPercentageComplete() * totalBudgetCost;
                rpt.setCumulativeEarnedValue(cumulativeEV);
            }
        }
    }


    /**
     * calculate other reports per task;
     *
     * @param reportMap
     */
    private List<ProjectEarnedValueAnalysisReport> calculateEarnedValueAnalysisReport(Map<TaskInterval, ProjectEarnedValueAnalysisReport> reportMap, Map<Task, Double> totalTaskBudgetCost) {

        /**
         * total budget cost of all the tasks
         *
         */
        double totalBudgetedCost=0.0;
        for (Map.Entry<Task, Double> entry : totalTaskBudgetCost.entrySet()) {
            totalBudgetedCost+=entry.getValue();
        }


        List<ProjectEarnedValueAnalysisReport> projectEarnedValueAnalysisReports = new LinkedList<>();


        /**
         * calculate cumulative planned value.
         */
        double cumulativePlannedValue = 0.0;
        double cumulativeActualValue = 0.0;
        for (Map.Entry<TaskInterval, ProjectEarnedValueAnalysisReport> entry : reportMap.entrySet()) {
            TaskInterval interval = entry.getKey();
            ProjectEarnedValueAnalysisReport report = entry.getValue();
            projectEarnedValueAnalysisReports.add(report);
            report.setMonth(interval.getMonth());
            report.setYear(interval.getYear());

            cumulativePlannedValue += report.getTotalBudgetedCost();
            report.setCumulativePlannedValue(cumulativePlannedValue);

            cumulativeActualValue += report.getTotalActualCost();
            report.setCumulativeActualCost(cumulativeActualValue);


            /**
             * calculate cost variance
             */

            double costVariance = report.getCumulativeEarnedValue() - report.getCumulativeActualCost();
            report.setCostVariance(costVariance);

            /**
             * calculate schedule variance
             */

            double scheduleVariance = report.getCumulativeEarnedValue() - report.getCumulativePlannedValue();
            report.setScheduleVariance(scheduleVariance);

            /**
             * cost performance index
             */

            double costPerformanceIndex = report.getCumulativeEarnedValue()/report.getCumulativeActualCost();
            report.setCostPerformanceIndex(costPerformanceIndex);

            /**
             * schedule performance index.
             */
            double schedulePerformanceIndex = report.getCumulativeEarnedValue()/report.getCumulativePlannedValue();
            report.setCostPerformanceIndex(schedulePerformanceIndex);

            /**
             * calculate estimated cost at completion.
             *
             */

            double estimatedCostAtCompletion=totalBudgetedCost * (1/costPerformanceIndex);
            report.setEstimatedCostAtCompletion(estimatedCostAtCompletion);

        }

        return projectEarnedValueAnalysisReports;
    }


}
