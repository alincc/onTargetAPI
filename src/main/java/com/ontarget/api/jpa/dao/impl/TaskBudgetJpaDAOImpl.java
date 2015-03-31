package com.ontarget.api.jpa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.repository.PlannedActualsCostRepository;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.PlannedActualsCost;

@Repository("taskBudgetJpaDAOImpl")
public class TaskBudgetJpaDAOImpl implements TaskBudgetDAO {
	@Resource
	private PlannedActualsCostRepository plannedActualsCostRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Map<String, Object> getMinStartMaxEndDate(long projectId, String costType) throws Exception {
		Object[] minMaxDateRecord = plannedActualsCostRepository.getTaskCostMinMaxDate(costType, (int) projectId);
		Map<String, Object> minMaxDateMap = new HashMap<String, Object>();
		minMaxDateMap.put("min_date", minMaxDateRecord[0]);
		minMaxDateMap.put("max_date", minMaxDateRecord[1]);

		return minMaxDateMap;
	}

	@Override
	public Map<ProjectTaskInfo, List<TaskEstimatedCost>> getTaskToCostMap(long projectId, String costType) throws Exception {
		Map<ProjectTaskInfo, List<TaskEstimatedCost>> taskToCostMap = new LinkedHashMap<>();

		List<PlannedActualsCost> plannedActualsCostList = plannedActualsCostRepository.getPlannedAcutalsCostByProject(costType,
				(int) projectId);

		if (plannedActualsCostList != null && !plannedActualsCostList.isEmpty()) {
			for (PlannedActualsCost plannedActualsCost : plannedActualsCostList) {
				TaskEstimatedCost cost = new TaskEstimatedCost();
				cost.setId(plannedActualsCost.getId());
				cost.setFromDate(plannedActualsCost.getFromDate());
				cost.setToDate(plannedActualsCost.getToDate());
				cost.setCostType(costType);
				cost.setCost(plannedActualsCost.getValue().doubleValue());

				int year = 0;
				int month = 0;
				Date fromDate = cost.getFromDate();
				if (fromDate != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(fromDate);
					year = cal.get(Calendar.YEAR);
					month = cal.get(Calendar.MONTH);
				}
				cost.setMonth(month);
				cost.setYear(year);

				ProjectTaskInfo task = new ProjectTaskInfo();
				task.setProjectTaskId(plannedActualsCost.getProjectTask().getProjectTaskId());
				task.setTitle(plannedActualsCost.getProjectTask().getTitle());
				List<TaskEstimatedCost> costList = taskToCostMap.get(task);
				if (costList == null) {
					costList = new ArrayList<>();
				}
				costList.add(cost);

				// sorting by month and year using java 8 lambda expression.
				Comparator<TaskEstimatedCost> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(
						Integer.valueOf(o2.getYear()));
				Comparator<TaskEstimatedCost> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(
						Integer.valueOf(o2.getMonth()));

				costList.stream().sorted(byYear.thenComparing(byMonth));

				taskToCostMap.put(task, costList);
			}
		}

		return taskToCostMap;
	}

	@Override
	public Map<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> getTaskToCostMapByMonthYear(int projectId, String costType)
			throws Exception {
		Map<TaskInfo, Map<TaskInterval, TaskEstimatedCost>> taskToCostMap = new LinkedHashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_PLANNED_ESTIMATED_COST_BY_PROJECT, new Object[] { costType, projectId }, (
				resultSet, i) -> {
			TaskEstimatedCost cost = new TaskEstimatedCost();
			cost.setId(resultSet.getInt("id"));
			Date fromDate = resultSet.getDate("from_date");
			cost.setFromDate(fromDate);
			cost.setToDate(resultSet.getDate("to_date"));
			cost.setCostType(costType);
			cost.setCost(resultSet.getDouble("value"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
			cost.setMonth(month);
			cost.setYear(year);

			TaskInfo task = new TaskInfo();
			task.setProjectTaskId(resultSet.getInt("project_task_id"));
			task.setTitle(resultSet.getString("title"));

			Map<TaskInterval, TaskEstimatedCost> monthYearCost = taskToCostMap.get(task);
			if (monthYearCost == null) {
				monthYearCost = new LinkedHashMap<>();
			}
			monthYearCost.put(new TaskInterval(month, year), cost);

			taskToCostMap.put(task, monthYearCost);
			return null;
		});

		return taskToCostMap;
	}

	@Override
	public Map<TaskInfo, Map<TaskInterval, List<TaskEstimatedCost>>> getTaskCostMapByTask(int projectTaskId) throws Exception {

		Map<TaskInfo, Map<TaskInterval, List<TaskEstimatedCost>>> taskMapMap = new LinkedHashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_COST_BY_TASK, new Object[] { projectTaskId }, (resultSet, i) -> {

			TaskInfo task = new TaskInfo();
			task.setProjectTaskId(resultSet.getInt("project_task_id"));
			task.setTitle("title");
			task.setDescription("description");
			task.setStartDate(resultSet.getDate("start_date"));
			task.setEndDate(resultSet.getDate("end_date"));

			Map<TaskInterval, List<TaskEstimatedCost>> actualsPlannedCostByMonthYear = taskMapMap.get(task);
			if (actualsPlannedCostByMonthYear == null) {
				actualsPlannedCostByMonthYear = new LinkedHashMap<>();
				taskMapMap.put(task, actualsPlannedCostByMonthYear);
			}

			TaskEstimatedCost cost = new TaskEstimatedCost();
			cost.setId(resultSet.getInt("id"));
			Date fromDate = resultSet.getDate("from_date");
			cost.setFromDate(fromDate);
			cost.setToDate(resultSet.getDate("to_date"));
			cost.setCostType(resultSet.getString("cost_type"));
			cost.setCost(resultSet.getDouble("value"));
			cost.setCreatedBy(resultSet.getInt("created_by"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
			cost.setMonth(month);
			cost.setYear(year);

			TaskInterval taskInterval = new TaskInterval(month, year);
			List<TaskEstimatedCost> taskEstimatedCosts = actualsPlannedCostByMonthYear.get(taskInterval);
			if (taskEstimatedCosts == null) {
				taskEstimatedCosts = new LinkedList<>();
				actualsPlannedCostByMonthYear.put(taskInterval, taskEstimatedCosts);
			}

			actualsPlannedCostByMonthYear.get(taskInterval).add(cost);

			return null;
		});

		return taskMapMap;
	}

	@Override
	public TaskInfo getTaskCostByTask(TaskInfo task) throws Exception {
		final List<TaskEstimatedCost> taskCostList = new ArrayList<>();
		task.setCosts(taskCostList);

		jdbcTemplate.query(OnTargetQuery.GET_TASK_COST_BY_TASK, new Object[] { task }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				TaskEstimatedCost cost = new TaskEstimatedCost();
				cost.setId(resultSet.getInt("id"));
				Date fromDate = resultSet.getDate("from_date");
				cost.setFromDate(fromDate);
				cost.setToDate(resultSet.getDate("to_date"));
				cost.setCostType(resultSet.getString("cost_type"));
				cost.setCost(resultSet.getDouble("value"));
				cost.setCreatedBy(resultSet.getInt("created_by"));

				int year = 0;
				int month = 0;
				if (fromDate != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(fromDate);
					year = cal.get(Calendar.YEAR);
					month = cal.get(Calendar.MONTH);
				}
				cost.setMonth(month);
				cost.setYear(year);

				taskCostList.add(cost);
				return null;
			}
		});

		return task;
	}

	@Override
	public Map<TaskInterval, List<TaskEstimatedCost>> getTaskCostByTaskMonthYear(int projectTaskId) throws Exception {
		final Map<TaskInterval, List<TaskEstimatedCost>> taskIntervalListMap = new HashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_COST_BY_TASK, new Object[] { projectTaskId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {

				TaskEstimatedCost cost = new TaskEstimatedCost();
				cost.setId(resultSet.getInt("id"));
				Date fromDate = resultSet.getDate("from_date");
				cost.setFromDate(fromDate);
				cost.setToDate(resultSet.getDate("to_date"));
				cost.setCostType(resultSet.getString("cost_type"));
				cost.setCost(resultSet.getDouble("value"));
				cost.setCreatedBy(resultSet.getInt("created_by"));

				int year = 0;
				int month = 0;
				if (fromDate != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(fromDate);
					year = cal.get(Calendar.YEAR);
					month = cal.get(Calendar.MONTH) + 1;
				}
				cost.setMonth(month);
				cost.setYear(year);

				TaskInterval taskInterval = new TaskInterval(month, year);
				List<TaskEstimatedCost> taskEstimatedCosts = taskIntervalListMap.get(taskInterval);
				if (taskEstimatedCosts == null) {
					taskEstimatedCosts = new LinkedList<>();
				}
				taskEstimatedCosts.add(cost);
				taskIntervalListMap.put(taskInterval, taskEstimatedCosts);

				return null;
			}
		});

		return taskIntervalListMap;
	}

}
