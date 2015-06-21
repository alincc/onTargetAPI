package com.ontarget.api.jpa.dao.impl;

import java.util.*;

import javax.annotation.Resource;

import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TimeCardDAO;
import com.ontarget.api.repository.FieldWorkerRepository;
import com.ontarget.api.repository.TimeCardRepository;
import com.ontarget.entities.Discipline;
import com.ontarget.entities.FieldWorker;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.TimeCard;
import com.ontarget.entities.User;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

@Repository("timeCardJpaDAOImpl")
public class TimeCardJpaDAOImpl implements TimeCardDAO {

	@Resource
	private TimeCardRepository timeCardRepository;
	@Resource
	private FieldWorkerRepository fieldWorkerRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public boolean add(AddTimeCardRequest request) throws Exception {
		TimeCard timeCard = new TimeCard();
		timeCard.setFieldworker(new FieldWorker(request.getFieldWorkerId()));
		timeCard.setProjectTask(new ProjectTask(request.getProjectTaskId()));
		timeCard.setAddedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		timeCard.setAddedDate(new Date());
		timeCard.setTimeIn(request.getTimeIn());
		timeCard.setTimeOut(request.getTimeOut());
		timeCardRepository.save(timeCard);
		return true;
	}

	@Override
	public boolean update(UpdateTimeCardRequest request) throws Exception {
		TimeCard timeCard = timeCardRepository.findById(request.getId());
		timeCard.setFieldworker(new FieldWorker(request.getFieldWorkerId()));
		timeCard.setProjectTask(new ProjectTask(request.getProjectTaskId()));
		timeCard.setModifiedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		timeCard.setModifiedDate(new Date());
		timeCard.setTimeIn(request.getTimeIn());
		timeCard.setTimeOut(request.getTimeOut());
		timeCardRepository.save(timeCard);
		return true;
	}

	@Override
	public boolean addFieldWorker(AddFieldWorkerRequest request) throws Exception {
		FieldWorker fieldWorker = new FieldWorker();
		fieldWorker.setEmailAddress(request.getEmail());
		fieldWorker.setFirstName(request.getFirstName());
		fieldWorker.setLastName(request.getLastName());
		fieldWorker.setDiscipline(new Discipline(request.getDiscipline()));
		fieldWorker.setPhoneNumber(request.getPhoneNumber());
		fieldWorker.setAddedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		fieldWorker.setAddedDate(new Date());
		fieldWorkerRepository.save(fieldWorker);
		return true;
	}

	@Override
	public boolean updateFieldWorker(UpdateFieldWorkerRequest request) throws Exception {
		FieldWorker fieldWorker = fieldWorkerRepository.findById(request.getId());
		fieldWorker.setEmailAddress(request.getEmail());
		fieldWorker.setFirstName(request.getFirstName());
		fieldWorker.setLastName(request.getLastName());
		fieldWorker.setDiscipline(new Discipline(request.getDiscipline()));
		fieldWorker.setPhoneNumber(request.getPhoneNumber());
		fieldWorker.setModifiedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		fieldWorker.setModifiedDate(new Date());
		fieldWorkerRepository.save(fieldWorker);
		return true;
	}

	@Override
	public List<FieldWorker> getAllFieldWorkers() throws Exception {
		return fieldWorkerRepository.findAllFieldWorker();
	}


    @Override
    public Map<TaskInfo, Map<TaskInterval, Double>>  calculateActualCostByMonthYear(long projectId){
        Map<TaskInfo, Map<TaskInterval, Double>> taskToCostMap = new LinkedHashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_TIME_CARD_PER_PROJECT, new Object[] { projectId }, (
                resultSet, i) -> {

            //get the clock in and clock out date.
            Date timeIn = resultSet.getDate("time_in");
            Date timeOut = resultSet.getDate("time_out");

            Calendar beginCalendar = Calendar.getInstance();
            beginCalendar.setTime(timeIn);

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(timeOut);

            long timeInterval = endCalendar.getTimeInMillis() - beginCalendar.getTimeInMillis();
            double totalHours=timeInterval / OnTargetConstant.HOUR;

            int year = 0;
            int month = 0;
            if (timeOut != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(timeOut);
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH) + 1;
            }

            TaskInfo task = new TaskInfo();
            task.setProjectTaskId(resultSet.getInt("project_task_id"));
            task.setTitle(resultSet.getString("title"));

            TaskInterval taskInterval=new TaskInterval(month, year);

            Map<TaskInterval, Double> monthYearCost = taskToCostMap.get(task);
            if (monthYearCost == null) {
                monthYearCost = new LinkedHashMap<>();
            }

            if(monthYearCost.get(taskInterval)!=null) {
                totalHours += monthYearCost.get(taskInterval).doubleValue();
            }

            monthYearCost.put(taskInterval, totalHours);

            taskToCostMap.put(task, monthYearCost);
            return null;
        });

        return taskToCostMap;

    }
}
