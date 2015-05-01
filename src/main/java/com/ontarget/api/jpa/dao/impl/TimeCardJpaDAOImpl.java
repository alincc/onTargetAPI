package com.ontarget.api.jpa.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TimeCardDAO;
import com.ontarget.api.repository.TimeCardRepository;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.TimeCard;
import com.ontarget.entities.User;
import com.ontarget.request.bean.AddTimeCardRequest;

@Repository("timeCardJpaDAOImpl")
public class TimeCardJpaDAOImpl implements TimeCardDAO {

	@Resource
	private TimeCardRepository timeCardRepository;

	@Override
	public boolean add(AddTimeCardRequest request) throws Exception {
		TimeCard timeCard = new TimeCard();
		timeCard.setName(request.getName());
		timeCard.setProjectTask(new ProjectTask(request.getProjectTaskId()));
		timeCard.setRecordedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		timeCard.setRecordedDate(new Date());
		timeCard.setTimeIn(request.getTimeIn());
		timeCard.setTimeOut(request.getTimeOut());
		timeCardRepository.save(timeCard);
		return true;
	}

}
