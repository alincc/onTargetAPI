package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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

@Repository("timeCardJpaDAOImpl")
public class TimeCardJpaDAOImpl implements TimeCardDAO {

	@Resource
	private TimeCardRepository timeCardRepository;
	@Resource
	private FieldWorkerRepository fieldWorkerRepository;

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

}
