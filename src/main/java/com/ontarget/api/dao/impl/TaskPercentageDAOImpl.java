package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Owner on 11/25/14.
 */
@Repository
public class TaskPercentageDAOImpl implements TaskPercentageDAO {

    private Logger logger = Logger.getLogger(TaskPercentageDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<Task, List<TaskPercentage>> getTaskPercentageCompletes(int projectId) throws Exception {
        logger.info("getting percentage for project Id: "+ projectId);
        Map<Task, List<TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE,new Object[]{projectId},new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                TaskPercentage percentage = new TaskPercentage();
                percentage.setId(resultSet.getInt("id"));
                Date fromDate = resultSet.getDate("start_date");
                percentage.setFromDate(fromDate);
                percentage.setToDate(resultSet.getDate("end_date"));
                percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
                percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

                int year=0;
                int month=0;
                if(fromDate!=null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fromDate);
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                }
                percentage.setMonth(month);
                percentage.setYear(year);

                Task task = new Task();
                task.setProjectTaskId(resultSet.getInt("project_task_id"));
                task.setTitle(resultSet.getString("title"));
                List<TaskPercentage> percentageList = taskToPercentageMap.get(task);
                if(percentageList == null){
                    percentageList = new ArrayList<>();
                }
                percentageList.add(percentage);

                // sorting by month and year using java 8 lambda expression.
                Comparator<TaskPercentage> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
                Comparator<TaskPercentage> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));

                percentageList.stream().sorted(byYear.thenComparing(byMonth));

                taskToPercentageMap.put(task, percentageList);
                return null;
            }
        });

        return taskToPercentageMap;
    }


    @Override
    public Map<Task, Map<TaskInterval,TaskPercentage>> getTaskPercentageCompletesByMonthYear(int projectId) throws Exception {
        logger.info("getting percentage for project Id: "+ projectId);
        Map<Task, Map<TaskInterval,TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE,new Object[]{projectId},new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                TaskPercentage percentage = new TaskPercentage();
                percentage.setId(resultSet.getInt("id"));
                Date fromDate = resultSet.getDate("start_date");
                percentage.setFromDate(fromDate);
                percentage.setToDate(resultSet.getDate("end_date"));
                percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
                percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

                int year=0;
                int month=0;
                if(fromDate!=null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fromDate);
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                }
                percentage.setMonth(month);
                percentage.setYear(year);

                Task task = new Task();
                task.setProjectTaskId(resultSet.getInt("project_task_id"));
                task.setTitle(resultSet.getString("title"));

                Map<TaskInterval,TaskPercentage> percentageMapByMonthYear = taskToPercentageMap.get(task);
                if(percentageMapByMonthYear == null){
                    percentageMapByMonthYear = new LinkedHashMap<TaskInterval, TaskPercentage>();
                }
                percentageMapByMonthYear.put(new TaskInterval(month,year), percentage);

                // sorting by month and year using java 8 lambda expression.
                // Comparator<TaskPercentage> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
                // Comparator<TaskPercentage> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));
                //percentageList.stream().sorted(byYear.thenComparing(byMonth));

                taskToPercentageMap.put(task, percentageMapByMonthYear);
                return null;
            }
        });
        return taskToPercentageMap;
    }


    @Override
    public int addTaskPercentageComplete(TaskPercentage taskPercentage) throws Exception{
        logger.info("Adding task percentage: " + taskPercentage);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK_PERCENTAGE_COMPLETE, new String[]{"id"});
                        ps.setInt(1, taskPercentage.getTask().getProjectTaskId());
                        ps.setDate(2, new java.sql.Date(taskPercentage.getFromDate().getTime()));
                        ps.setDate(3, new java.sql.Date(taskPercentage.getToDate().getTime()));
                        ps.setString(4, taskPercentage.getTaskPercentageType());
                        ps.setDouble(5, taskPercentage.getTaskPercentageComplete());
                        ps.setString(6,"");//get user who added this.
                        ps.setString(7, "");// get user who modified this.
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added Task Costs: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean updateTaskPercentageComplete(TaskPercentage cost) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_PERCENTAGE_COMPLETE, new Object[]{cost.getTaskPercentageComplete(), "USER", cost.getId()});
        if (row == 0) {
            throw new Exception("Unable to update task estimated and planned cost");
        }
        return true;
    }


    @Override
    public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception{
        final List<TaskPercentage> taskPercentageList=new ArrayList<>();

        jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE_BY_TASK,new Object[]{projectTaskId},new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                TaskPercentage percentage = new TaskPercentage();
                percentage.setId(resultSet.getInt("task_percentage_log_id"));
                Date fromDate = resultSet.getDate("start_date");
                percentage.setFromDate(fromDate);
                percentage.setToDate(resultSet.getDate("end_date"));
                percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
                percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));
                percentage.setCreatedBy(resultSet.getString("created_by"));

                int year=0;
                int month=0;
                if(fromDate!=null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fromDate);
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                }
                percentage.setMonth(month);
                percentage.setYear(year);

                taskPercentageList.add(percentage);
                return null;
            }
        });

        return taskPercentageList;
    }



}
