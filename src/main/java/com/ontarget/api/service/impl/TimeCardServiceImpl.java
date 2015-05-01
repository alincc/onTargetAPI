package com.ontarget.api.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TimeCardDAO;
import com.ontarget.api.service.TimeCardService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectTask;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.util.DateFormater;

@Service
public class TimeCardServiceImpl implements TimeCardService {

	private Logger logger = Logger.getLogger(TimeCardServiceImpl.class);

	@Autowired
	@Qualifier("timeCardJpaDAOImpl")
	private TimeCardDAO timeCardDAO;

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addTimeCard(AddTimeCardRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		try {
			ProjectTask projectTask = taskDAO.getProjectTaskById(request.getProjectTaskId());

			Date timeIn = DateFormater.getFormattedDate(request.getTimeIn());
			Date timeOut = DateFormater.getFormattedDate(request.getTimeOut());

			Date projectTaskStartDate = DateFormater.getFormattedDate(projectTask.getStartDate());
			Date projectTaskEndDate = DateFormater.getFormattedDate(projectTask.getEndDate());

			if (timeIn.before(projectTaskStartDate)) {
				logger.info("time-in before task start date");
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("time-in before task start date");
				return response;
			} else {
				if (timeOut.after(projectTaskEndDate)) {
					logger.info("time-out after task end date");
					response.setReturnVal(OnTargetConstant.ERROR);
					response.setReturnMessage("time-out after task end date");
					return response;
				}
			}
			if (timeCardDAO.add(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Time card added for task");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while adding time card");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while adding time card");
		}
		return response;
	}

}
