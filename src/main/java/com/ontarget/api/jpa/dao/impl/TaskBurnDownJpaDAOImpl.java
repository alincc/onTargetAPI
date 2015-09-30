package com.ontarget.api.jpa.dao.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskBurnDownDAO;
import com.ontarget.api.repository.TaskBurnDownRepository;

@Repository
public class TaskBurnDownJpaDAOImpl implements TaskBurnDownDAO {
	private Logger logger = Logger.getLogger(TaskBurnDownJpaDAOImpl.class);

	@Resource
	private TaskBurnDownRepository taskBurnDownRepository;

	@Override
	public BigInteger getCompleteTaskOfActivity(Integer activityId, String toDate) throws Exception {
		return taskBurnDownRepository.getCompletedTaskCount(activityId, toDate);
	}

	@Override
	public BigInteger getIncompleteTaskOfActivity(Integer activityId,String toDate) throws Exception {
		return taskBurnDownRepository.getIncompletTaskCount(activityId,toDate);
	}

}
