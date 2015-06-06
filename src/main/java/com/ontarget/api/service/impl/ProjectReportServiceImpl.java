package com.ontarget.api.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.AccidentReportDAO;
import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.api.dao.DocumentDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.AccidentReport;
import com.ontarget.bean.ActivityLog;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.NoAccidentReport;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.bean.TimeSaved;
import com.ontarget.bean.TreesSaved;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ActivityLogDTO;
import com.ontarget.enums.TaskStatus;
import com.ontarget.util.OntargetUtil;

/**
 * Created by Owner on 12/3/14.
 */
@Service
public class ProjectReportServiceImpl implements ProjectReportService {

	private Logger logger = Logger.getLogger(ProjectReportServiceImpl.class);

	@Autowired
	@Qualifier("taskBudgetDAOImpl")
	private TaskBudgetDAO taskBudgetDAO;

	@Autowired
	@Qualifier("taskPercentageDAOImpl")
	private TaskPercentageDAO taskPercentageDAO;

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Autowired
	@Qualifier("documentJpaDAOImpl")
	private DocumentDAO documentDAO;

	@Autowired
	@Qualifier("activityJpaDAOImpl")
	private ActivityDAO activityDAO;

	@Autowired
	@Qualifier("accidentReportJpaDAOImpl")
	private AccidentReportDAO accidentReportDAO;

	@Override
	public List<ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception {
		logger.debug("Getting earned value analysis report: " + projectId);
		// task planned cost
		Map<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> taskPlannedCostByMonthAndYear = taskBudgetDAO
				.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.PLANNED);

		// task actual cost
		Map<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> taskActualCostByMonthAndYear = taskBudgetDAO
				.getTaskToCostMapByMonthYear(projectId, OnTargetConstant.CostType.ACTUAL);

		// task percentage
		Map<TaskInfo, Map<TaskInterval, TaskPercentage>> taskPercentageByMonthAndYear = taskPercentageDAO
				.getTaskPercentageCompletesByMonthYear(projectId);

		// Total budgeted cost
		Map<TaskInfo, Double> totalTaskBudgetCost = new HashMap<>();

		if (taskPlannedCostByMonthAndYear.isEmpty()) {
			return null;
		}

		// get all the time interval for the project
		ProjectDTO project = projectDAO.getProject(projectId);

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
		for (Map.Entry<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> entry : taskPlannedCostByMonthAndYear.entrySet()) {
			TaskInfo task = entry.getKey();
			Map<TaskInterval, TaskEstimatedCost> monthYearEstimatedCost = entry.getValue();

			for (TaskInterval ti : timeInterval) {
				TaskEstimatedCost cost = monthYearEstimatedCost.get(ti);
				double monthYearCost = 0.0;
				if (cost != null) {
					monthYearCost = cost.getCost();
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
				if (cost != null) {
					monthYearCost = cost.getCost();
				}
				totalTaskCost += monthYearCost;
			}
			totalTaskBudgetCost.put(task, totalTaskCost);
		}

		/**
		 * calculate total actual cost by month year
		 */

		for (Map.Entry<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> entry : taskActualCostByMonthAndYear.entrySet()) {
			TaskInfo task = entry.getKey();
			Map<TaskInterval, TaskEstimatedCost> monthYearActualCost = entry.getValue();

			for (TaskInterval ti : timeInterval) {
				TaskEstimatedCost cost = monthYearActualCost.get(ti);
				double monthYearCost = 0.0;
				if (cost != null) {
					monthYearCost = cost.getCost();
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

		return calculateEarnedValueAnalysisReport(monthYearEarnedValueReportByTask, totalTaskBudgetCost);

	}

	@Override
	public TimeSaved getTimeSaved(int projectId) throws Exception {

		// get all task done within time.
		List<TaskInfo> tasks = taskDAO.getTask(projectId, TaskStatus.COMPLETED.getTaskStatusId());

		// get all approved documents on time.

		List<DocumentDTO> documents = documentDAO.getDocumentsByProject(projectId, OnTargetConstant.APPROVED);

		int approvedDocumentsOnTime = documents.size();

		// get SPI
		List<ProjectEarnedValueAnalysisReport> reports = getEarnedValueAnalysisReport(projectId);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		double spi = 0.0;
		if (reports != null && reports.size() > 0) {
			for (ProjectEarnedValueAnalysisReport report : reports) {
				if (report.getMonth() == month && report.getYear() == year) {
					spi = report.getSchedulePerformanceIndex();
				}
			}
		}

		double timeSavedVal = tasks.size() * approvedDocumentsOnTime * spi;

		TimeSaved timeSaved = new TimeSaved();
		timeSaved.setTimeSavedValue(timeSavedVal);

		return timeSaved;
	}

	/**
	 * get trees saved for this project
	 *
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@Override
	public TreesSaved getTreesSaved(int projectId) throws Exception {
		TreesSaved treesSaved = new TreesSaved();
		ActivityLogDTO activityLogDTO = activityDAO.getActivityLog(1, 50, projectId);
		List<ActivityLog> logs = activityLogDTO.getActivityLogList();
		treesSaved.setTreesSaved(new Double(logs.size()));
		return treesSaved;
	}

	/**
	 * Get No accident days for the project.
	 *
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@Override
	public NoAccidentReport getNoAccidentReport(int projectId) throws Exception {
		logger.debug("Getting accident report for project: " + projectId);
		List<AccidentReport> accidents = accidentReportDAO.getAccidentReportsByProjectId(projectId);
		ProjectDTO project = projectDAO.getProject(projectId);
		Date startDate = project.getStartDate();

		int daysBetweenDates = (int) (new Date().getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
		int numOfAccidents = 0;
		if (accidents != null && accidents.size() > 0) {
			numOfAccidents = accidents.size();
		}

		NoAccidentReport report = new NoAccidentReport();
		report.setNoAccidentDays(new Double(daysBetweenDates - numOfAccidents));

		return report;
	}

	/**
	 * Calculate cumulative earned value
	 */
	private void calculateCumulativeEarnedValue(
			Map<TaskInterval, ProjectEarnedValueAnalysisReport> monthYearEarnedValueReportByTask,
			Map<TaskInfo, Map<TaskInterval, TaskPercentage>> taskPercentageByMonthAndYear,
			Map<TaskInfo, Double> totalTaskBudgetCost) {

		for (Map.Entry<TaskInfo, Map<TaskInterval, TaskPercentage>> entry : taskPercentageByMonthAndYear.entrySet()) {

			TaskInfo task = entry.getKey();
			Map<TaskInterval, TaskPercentage> monthYearTaskPercentage = entry.getValue();

			double totalBudgetCost = totalTaskBudgetCost.get(task);

			for (Map.Entry<TaskInterval, TaskPercentage> taskIntervalTaskPercentageEntry : monthYearTaskPercentage.entrySet()) {
				TaskInterval taskInterval = taskIntervalTaskPercentageEntry.getKey();
				ProjectEarnedValueAnalysisReport rpt = monthYearEarnedValueReportByTask.get(taskInterval);
				double cumulativeEV = rpt.getCumulativeEarnedValue()
						+ monthYearTaskPercentage.get(taskInterval).getTaskPercentageComplete() * totalBudgetCost;
				rpt.setCumulativeEarnedValue(cumulativeEV);
			}
		}
	}

	/**
	 * calculate other reports per task;
	 *
	 * @param reportMap
	 */
	private List<ProjectEarnedValueAnalysisReport> calculateEarnedValueAnalysisReport(
			Map<TaskInterval, ProjectEarnedValueAnalysisReport> reportMap, Map<TaskInfo, Double> totalTaskBudgetCost) {

		/**
		 * total budget cost of all the tasks
		 *
		 */
		double totalBudgetedCost = 0.0;
		for (Map.Entry<TaskInfo, Double> entry : totalTaskBudgetCost.entrySet()) {
			totalBudgetedCost += entry.getValue();
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

			double costPerformanceIndex = 0;
			if (report.getCumulativeActualCost() > 0) {
				costPerformanceIndex = report.getCumulativeEarnedValue() / report.getCumulativeActualCost();
			}
			report.setCostPerformanceIndex(costPerformanceIndex);

			/**
			 * schedule performance index.
			 */
			double schedulePerformanceIndex = 0;
			if (report.getCumulativePlannedValue() > 0) {
				schedulePerformanceIndex = report.getCumulativeEarnedValue() / report.getCumulativePlannedValue();
			}
			report.setCostPerformanceIndex(schedulePerformanceIndex);

			/**
			 * calculate estimated cost at completion.
			 *
			 */
			double estimatedCostAtCompletion = 0;
			if (costPerformanceIndex > 0) {
				estimatedCostAtCompletion = totalBudgetedCost * (1 / costPerformanceIndex);
			}
			report.setEstimatedCostAtCompletion(estimatedCostAtCompletion);

		}

		return projectEarnedValueAnalysisReports;
	}

}
