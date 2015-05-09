package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TimeCardDAO;
import com.ontarget.api.service.TimeCardService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.FieldWorkerInfo;
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.FieldWorker;
import com.ontarget.entities.ProjectTask;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;
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

	private OnTargetResponse validateTimeFrame(Date inTime, Date outTime, int projectTaskId) {
		OnTargetResponse response = new OnTargetResponse();
		ProjectTask projectTask = taskDAO.getProjectTaskById(projectTaskId);
		Date timeIn = DateFormater.getFormattedDate(inTime);
		Date timeOut = DateFormater.getFormattedDate(outTime);

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
		return null;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addTimeCard(AddTimeCardRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		try {
			response = validateTimeFrame(request.getTimeIn(), request.getTimeOut(), request.getProjectTaskId());
			if (response != null) {
				return response;
			}

			response = new OnTargetResponse();

			if (timeCardDAO.add(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Time card added for task");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while adding time card");
			}
		} catch (Exception e) {
			logger.error(e);
			response = new OnTargetResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while adding time card");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse editTimeCard(UpdateTimeCardRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		try {
			response = validateTimeFrame(request.getTimeIn(), request.getTimeOut(), request.getProjectTaskId());
			if (response != null) {
				return response;
			}

			response = new OnTargetResponse();

			if (timeCardDAO.update(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Time card updated for task");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while updating time card");
			}
		} catch (Exception e) {
			logger.error(e);
			response = new OnTargetResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while updating time card");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addFieldWorker(AddFieldWorkerRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (timeCardDAO.addFieldWorker(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully added field worker");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while adding field worker");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while adding field worker");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse editFieldWorker(UpdateFieldWorkerRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (timeCardDAO.updateFieldWorker(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Field worker info updated successfully");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while editing field worker");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while editing field worker");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public FieldWorkerResponse fetchAllFieldWorkers() throws Exception {
		FieldWorkerResponse response = new FieldWorkerResponse();
		List<FieldWorkerInfo> fieldWorkerInfoList = new ArrayList<>();
		response.setFieldWorkers(fieldWorkerInfoList);
		try {
			List<FieldWorker> fieldWorkers = timeCardDAO.getAllFieldWorkers();
			if (fieldWorkers != null && !fieldWorkers.isEmpty()) {
				for (FieldWorker fieldWorker : fieldWorkers) {
					FieldWorkerInfo fieldWorkerInfo = new FieldWorkerInfo();
					fieldWorkerInfo.setId(fieldWorker.getId());
					fieldWorkerInfo.setFirstName(fieldWorker.getFirstName());
					fieldWorkerInfo.setLastName(fieldWorker.getLastName());
					fieldWorkerInfo.setEmailAddress(fieldWorker.getEmailAddress());
					fieldWorkerInfo.setPhoneNumber(fieldWorker.getPhoneNumber());
					fieldWorkerInfo.setDisciplineId(fieldWorker.getDiscipline().getId());
					fieldWorkerInfo.setDiscipline(fieldWorker.getDiscipline().getName());
					fieldWorkerInfo.setAddedDate(fieldWorker.getAddedDate());
					fieldWorkerInfoList.add(fieldWorkerInfo);
				}
			}
			response.setFieldWorkers(fieldWorkerInfoList);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved field workers");
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while retrieving field workers");
		}
		return response;
	}

}
