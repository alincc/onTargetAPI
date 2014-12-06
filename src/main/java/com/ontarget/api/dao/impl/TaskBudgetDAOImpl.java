package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Owner on 11/22/14.
 */
@Repository
public class TaskBudgetDAOImpl implements TaskBudgetDAO {

    private Logger logger = Logger.getLogger(TaskBudgetDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getMinStartMaxEndDate(int projectId, String costType) throws Exception {
        logger.info("Getting min date and max date for projectId "+ projectId + " and cost type:"+costType);
        return jdbcTemplate.queryForMap(OnTargetQuery.GET_TASK_COST_MIN_MAX_DATE, new Object[]{costType,projectId});
    }

    @Override
    public Map<Task, List<TaskEstimatedCost>> getTaskToCostMap(int projectId, String costType) throws Exception {
        logger.info("getting cost for project Id: "+ projectId +" and cost type: "+ costType);
         Map<Task, List<TaskEstimatedCost>> taskToCostMap = new LinkedHashMap<>();

         jdbcTemplate.query(OnTargetQuery.GET_TASK_PLANNED_ESTIMATED_COST_BY_PROJECT,new Object[]{costType, projectId},new RowMapper<Void>() {
             @Override
             public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                 TaskEstimatedCost cost = new TaskEstimatedCost();
                 cost.setId(resultSet.getInt("id"));
                 Date fromDate = resultSet.getDate("from_date");
                 cost.setFromDate(fromDate);
                 cost.setToDate(resultSet.getDate("to_date"));
                 cost.setCostType(costType);
                 cost.setCost(resultSet.getDouble("value"));

                 int year=0;
                 int month=0;
                 if(fromDate!=null) {
                     Calendar cal = Calendar.getInstance();
                     cal.setTime(fromDate);
                     year = cal.get(Calendar.YEAR);
                     month = cal.get(Calendar.MONTH);
                 }
                 cost.setMonth(month);
                 cost.setYear(year);

                 Task task = new Task();
                 task.setProjectTaskId(resultSet.getInt("project_task_id"));
                 task.setTitle(resultSet.getString("title"));
                 List<TaskEstimatedCost> costList = taskToCostMap.get(task);
                 if(costList == null){
                     costList = new ArrayList<>();
                 }
                 costList.add(cost);

                // sorting by month and year using java 8 lambda expression.
                 Comparator<TaskEstimatedCost> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
                 Comparator<TaskEstimatedCost> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));

                 costList.stream().sorted(byYear.thenComparing(byMonth));

                 taskToCostMap.put(task, costList);
                 return null;
             }
         });

        //sort map by created_date key.

        return taskToCostMap;
    }


    @Override
    public Map<Task, Map<TaskInterval,TaskEstimatedCost>> getTaskToCostMapByMonthYear(int projectId, String costType) throws Exception {
        logger.info("getting cost for project Id: "+ projectId +" and cost type: "+ costType);
        Map<Task, Map<TaskInterval,TaskEstimatedCost>> taskToCostMap = new LinkedHashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_TASK_PLANNED_ESTIMATED_COST_BY_PROJECT,new Object[]{costType, projectId},new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                TaskEstimatedCost cost = new TaskEstimatedCost();
                cost.setId(resultSet.getInt("id"));
                Date fromDate = resultSet.getDate("from_date");
                cost.setFromDate(fromDate);
                cost.setToDate(resultSet.getDate("to_date"));
                cost.setCostType(costType);
                cost.setCost(resultSet.getDouble("value"));

                int year=0;
                int month=0;
                if(fromDate!=null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fromDate);
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                }
                cost.setMonth(month+1);
                cost.setYear(year);

                Task task = new Task();
                task.setProjectTaskId(resultSet.getInt("project_task_id"));
                task.setTitle(resultSet.getString("title"));

                Map<TaskInterval,TaskEstimatedCost> monthYearCost = taskToCostMap.get(task);
                if(monthYearCost == null){
                    monthYearCost = new LinkedHashMap<TaskInterval, TaskEstimatedCost>();
                }
                monthYearCost.put(new TaskInterval(month,year), cost);

                // sorting by month and year using java 8 lambda expression.
                //Comparator<TaskEstimatedCost> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
                //Comparator<TaskEstimatedCost> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));
                //costList.stream().sorted(byYear.thenComparing(byMonth));

                taskToCostMap.put(task, monthYearCost);
                return null;
            }
        });

        return taskToCostMap;
    }


    @Override
    public List<TaskEstimatedCost> getTaskCostByTask(int projectTaskId) throws Exception{
        final List<TaskEstimatedCost> taskCostList=new ArrayList<>();

        jdbcTemplate.query(OnTargetQuery.GET_TASK_COST_BY_TASK,new Object[]{projectTaskId},new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                TaskEstimatedCost cost = new TaskEstimatedCost();
                cost.setId(resultSet.getInt("id"));
                Date fromDate = resultSet.getDate("from_date");
                cost.setFromDate(fromDate);
                cost.setToDate(resultSet.getDate("to_date"));
                cost.setCostType(resultSet.getString("cost_type"));
                cost.setCost(resultSet.getDouble("value"));
                cost.setCreatedBy(resultSet.getString("created_by"));

                int year=0;
                int month=0;
                if(fromDate!=null) {
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

        return taskCostList;
    }


}
