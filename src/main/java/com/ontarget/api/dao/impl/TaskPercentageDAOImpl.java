package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.request.bean.TaskProgressInfo;

/**
 * Created by Owner on 11/25/14.
 */
@Repository("taskPercentageDAOImpl")
public class TaskPercentageDAOImpl implements TaskPercentageDAO {

	private Logger logger = Logger.getLogger(TaskPercentageDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Map<ProjectTaskInfo, List<TaskPercentage>> getTaskPercentageCompletes(int projectId) throws Exception {
		logger.info("getting percentage for project Id: " + projectId);
		Map<ProjectTaskInfo, List<TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

		jdbcTemplate.query(
				OnTargetQuery.GET_TASK_PERCENTAGE,
				new Object[] { projectId },
				(resultSet, i) -> {
					TaskPercentage percentage = new TaskPercentage();
					percentage.setId(resultSet.getInt("task_percentage_log_id"));
					Date fromDate = resultSet.getDate("start_date");
					percentage.setFromDate(fromDate);
					percentage.setToDate(resultSet.getDate("end_date"));
					percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
					percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

					int year = 0;
					int month = 0;
					if (fromDate != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(fromDate);
						year = cal.get(Calendar.YEAR);
						month = cal.get(Calendar.MONTH);
					}
					percentage.setMonth(month);
					percentage.setYear(year);

					ProjectTaskInfo task = new ProjectTaskInfo();
					task.setProjectTaskId(resultSet.getInt("project_task_id"));
					task.setTitle(resultSet.getString("title"));
					List<TaskPercentage> percentageList = taskToPercentageMap.get(task);
					if (percentageList == null) {
						percentageList = new ArrayList<>();
					}
					percentageList.add(percentage);

					// sorting by month and year using java 8 lambda
					// expression.
					Comparator<TaskPercentage> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(
							Integer.valueOf(o2.getYear()));
					Comparator<TaskPercentage> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(
							Integer.valueOf(o2.getMonth()));

					percentageList.stream().sorted(byYear.thenComparing(byMonth));

					taskToPercentageMap.put(task, percentageList);

					return null;
				});

		return taskToPercentageMap;
	}

	@Override
	public Map<TaskInfo, Map<TaskInterval, TaskPercentage>> getTaskPercentageCompletesByMonthYear(long projectId)
			throws Exception {
		logger.info("getting percentage for project Id: " + projectId);
		Map<TaskInfo, Map<TaskInterval, TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE, new Object[] { projectId }, (resultSet, i) -> {
			TaskPercentage percentage = new TaskPercentage();
			percentage.setId(resultSet.getInt("task_percentage_log_id"));
			Date fromDate = resultSet.getDate("start_date");
			percentage.setFromDate(fromDate);
			percentage.setToDate(resultSet.getDate("end_date"));
			percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
			percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
			percentage.setMonth(month);
			percentage.setYear(year);

			TaskInfo task = new TaskInfo();
			task.setProjectTaskId(resultSet.getInt("project_task_id"));
			task.setTitle(resultSet.getString("title"));

			Map<TaskInterval, TaskPercentage> percentageMapByMonthYear = taskToPercentageMap.get(task);
			if (percentageMapByMonthYear == null) {
				percentageMapByMonthYear = new LinkedHashMap<>();
			}
			percentageMapByMonthYear.put(new TaskInterval(month, year), percentage);

			/**
			 * if percentage complete is zero for this month year, use the
			 * previous month/year
			 */
			double percentageComplete = percentage.getTaskPercentageComplete();
			while (percentageComplete == 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				cal.add(Calendar.MONTH, -1);

				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
				// set the from date incase the previous
				// month/year is also zero.
				fromDate = cal.getTime();

				TaskPercentage lastMonthPercentage = percentageMapByMonthYear.get(new TaskInterval(month, year));
				percentageComplete = lastMonthPercentage.getTaskPercentageComplete();
			}

			percentage.setTaskPercentageComplete(percentageComplete);

			// sorting by month and year using java 8 lambda
			// expression.
			// Comparator<TaskPercentage> byYear = (o1, o2) ->
			// Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
			// Comparator<TaskPercentage> byMonth = (o1, o2) ->
			// Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));
			// percentageList.stream().sorted(byYear.thenComparing(byMonth));

				taskToPercentageMap.put(task, percentageMapByMonthYear);
				return null;
			});
		return taskToPercentageMap;
	}

	@Override
	public int addTaskPercentageComplete(TaskProgress taskProgress, int addedBy) throws Exception {
		logger.info("Adding task percentage: " + taskProgress);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_TASK_PERCENTAGE_COMPLETE,
						new String[] { "id" });
				ps.setInt(1, taskProgress.getTaskId());
				ps.setString(2, taskProgress.getPercentageType());
				ps.setDouble(3, taskProgress.getPercentageComplete());
				ps.setInt(4, addedBy);// get user who added this.
				ps.setInt(5, 0);// get user who modified this.
				return ps;
			}
		}, keyHolder);
		logger.debug("Added Task Costs: " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

	@Override
	public boolean updateTaskPercentageComplete(TaskProgressInfo taskProgressOfTask, int modifiedBy) throws Exception {
		int row = jdbcTemplate.update(
				OnTargetQuery.UPDATE_TASK_PERCENTAGE_COMPLETE,
				new Object[] { taskProgressOfTask.getPercentageComplete(), modifiedBy,
						taskProgressOfTask.getTaskPercentageLogId() });
		if (row == 0) {
			throw new Exception("Unable to update task estimated and planned cost");
		}
		return true;
	}

	@Override
	public boolean expireTaskPercentage(int taskPercentageLogId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.EXPIRE_TASK_PERCENTAGE_COMPLETE, new Object[] { taskPercentageLogId });
		if (row == 0) {
			throw new Exception("Unable to expire task estimated and planned cost");
		}
		return true;
	}

	@Override
	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception {
		final List<TaskPercentage> taskPercentageList = new ArrayList<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE_BY_TASK, new Object[] { projectTaskId }, (resultSet, i) -> {
			TaskPercentage percentage = new TaskPercentage();
			percentage.setId(resultSet.getInt("task_percentage_log_id"));
			Date fromDate = resultSet.getDate("start_date");
			percentage.setFromDate(fromDate);
			percentage.setToDate(resultSet.getDate("end_date"));
			percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
			percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));
			percentage.setCreatedBy(resultSet.getString("created_by"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
			percentage.setMonth(month);
			percentage.setYear(year);

			taskPercentageList.add(percentage);
			return null;
		});

		return taskPercentageList;
	}

	@Override
	public TaskPercentage getExistingTaskPercentageForTheMonth(int taskId) throws Exception {
		logger.debug("Getting existing task percentage for task Id: " + taskId);
		TaskPercentage taskPercentage = new TaskPercentage();
		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE_FOR_THIS_MONTH, new Object[] { taskId }, (resultSet, i) -> {
			taskPercentage.setId(resultSet.getInt("task_percentage_log_id"));
			return null;
		});

		return taskPercentage;
	}

}
