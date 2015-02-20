package com.ontarget.util;

import java.util.ArrayList;
import java.util.List;

import com.ontarget.bean.AccidentReport;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.dto.AddDependentRequest;
import com.ontarget.dto.TaskBudgetRequest;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.request.bean.AccidentReportRequestBean;
import com.ontarget.request.bean.DependentTask;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.TaskBudget;
import com.ontarget.request.bean.TaskBudgetEstimate;
import com.ontarget.request.bean.UserInvitationRequestBean;

public class ConvertPOJOUtils {

	public static UserInvitationRequestDTO convertToUserInvitationDTO(
			UserInvitationRequestBean userInvitationRequest, String token) {
		UserInvitationRequestDTO userInvitationRequestDTO = new UserInvitationRequestDTO();
		userInvitationRequestDTO.setFirstName(userInvitationRequest
				.getFirstName());
		userInvitationRequestDTO.setLastName(userInvitationRequest
				.getLastName());
		userInvitationRequestDTO.setEmail(userInvitationRequest.getEmail());
		userInvitationRequestDTO.setMsg(userInvitationRequest.getMsg());
		userInvitationRequestDTO.setPhoneNumber(userInvitationRequest
				.getPhoneNumber());
		userInvitationRequestDTO.setToken(token);
		return userInvitationRequestDTO;
	}

	public static AddressDTO convertToAddressDTO(
			ProjectAddressInfo projectAddress) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress1(projectAddress.getAddress1());
		addressDTO.setAddress2(projectAddress.getAddress2());
		addressDTO.setCity(projectAddress.getCity());
		addressDTO.setState(projectAddress.getState());
		addressDTO.setZip(projectAddress.getZip());
		addressDTO.setCountry(projectAddress.getCountry());
		addressDTO.setAddressType(projectAddress.getAddressType());
		addressDTO.setAddressId(projectAddress.getAddressId());
		return addressDTO;
	}

	public static ProjectDTO convertToProjectDTO(ProjectDetailInfo project,
			AddressDTO addressDTO) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(project.getProjectId());
		projectDTO.setProjectParentId(project.getProjectParentId());
		projectDTO.setProjectTypeId(project.getProjectTypeId());
		projectDTO.setStartDate(project.getStartDate());
		projectDTO.setEndDate(project.getEndDate());
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setProjectDescription(project.getProjectDescription());
		projectDTO.setStatus(project.getStatus());
		projectDTO.setProjectAddress(addressDTO);
		return projectDTO;
	}

	public static AccidentReport convertToAccidentReport(
			AccidentReportRequestBean accidentReportRequestBean) {
		AccidentReport accidentReport = new AccidentReport();
		accidentReport.setAccidentReportId(accidentReportRequestBean
				.getAccidentReportId());
		accidentReport.setProjectId(accidentReportRequestBean.getProjectId());
		accidentReport.setBodyPartAffected(accidentReportRequestBean
				.getBodyPartAffected());
		accidentReport.setBriefOfAccident(accidentReportRequestBean
				.getBriefOfAccident());
		accidentReport.setCorrectionMeasuresPerformed(accidentReportRequestBean
				.getCorrectionMeasuresPerformed());
		accidentReport
				.setCorrectionMeasuresToBePerformed(accidentReportRequestBean
						.getCorrectionMeasuresToBePerformed());
		accidentReport.setDateInjuredLeftJob(accidentReportRequestBean
				.getDateInjuredLeftJob());
		accidentReport.setDateOfAccident(accidentReportRequestBean
				.getDateOfAccident());
		accidentReport.setDescription(accidentReportRequestBean
				.getDescription());
		accidentReport.setInjuredLeftJob(accidentReportRequestBean
				.getInjuredLeftJob());
		accidentReport.setInjuredVisitedDoctor(accidentReportRequestBean
				.getInjuredVisitedDoctor());
		accidentReport.setLocation(accidentReportRequestBean.getLocation());
		accidentReport.setPossiblePreventiveMeasures(accidentReportRequestBean
				.getPossiblePreventiveMeasures());
		accidentReport.setSeverity(accidentReportRequestBean.getSeverity());
		accidentReport.setSubmittedTo(accidentReportRequestBean
				.getSubmittedTo());
		accidentReport.setSupervisorName(accidentReportRequestBean
				.getSupervisorName());
		accidentReport.setTimeInjuredLeftJob(accidentReportRequestBean
				.getTimeInjuredLeftJob());
		accidentReport.setTimeOfAccident(accidentReportRequestBean
				.getTimeOfAccident());
		accidentReport.setUnsafeConditionsCorrected(accidentReportRequestBean
				.getUnsafeConditionsCorrected());
		accidentReport.setWitness(accidentReportRequestBean.getWitness());
		accidentReport.setWorkersCompensationFiled(accidentReportRequestBean
				.getWorkersCompensationFiled());
		return accidentReport;
	}

	public static AddDependentRequest convertToAddDependentRequest(
			DependentTaskRequest dependentTaskRequest) {
		DependentTask dependentTask = dependentTaskRequest.getDependentTask();

		AddDependentRequest addDependentRequest = new AddDependentRequest();
		DependentTaskDTO dependentTaskDTO = new DependentTaskDTO();
		dependentTaskDTO.setTaskId(dependentTask.getTaskId());
		dependentTaskDTO.setDependentTaskId(dependentTask.getDependentTaskId());
		dependentTaskDTO.setCategory_id(dependentTask.getCategoryId());
		dependentTaskDTO.setCreatedBy(dependentTaskRequest.getBaseRequest()
				.getLoggedInUserId());

		addDependentRequest.setDependentTask(dependentTaskDTO);

		return addDependentRequest;
	}

	public static TaskBudgetRequest convertToTaskBudgetRequest(
			TaskBudget taskBudget) {
		TaskBudgetRequest taskBudgetRequest = new TaskBudgetRequest();
		List<TaskEstimatedCost> costList = new ArrayList<TaskEstimatedCost>();

		List<TaskBudgetEstimate> taskEstimates = taskBudget
				.getTaskBudgetEstimates();

		for (TaskBudgetEstimate taskBudgetEstimate : taskEstimates) {
			TaskEstimatedCost taskEstimatedCost = new TaskEstimatedCost();
			taskEstimatedCost.setCost(taskBudgetEstimate.getCost());
			taskEstimatedCost.setCostType(taskBudgetEstimate.getCostType());
			taskEstimatedCost.setFromDate(taskBudgetEstimate.getFromDate());
			taskEstimatedCost.setToDate(taskBudgetEstimate.getToDate());
			taskEstimatedCost.setMonth(taskBudgetEstimate.getMonth());
			taskEstimatedCost.setYear(taskBudgetEstimate.getYear());
			taskEstimatedCost.setId(taskBudgetEstimate.getId());
			taskEstimatedCost.setCreatedBy(taskBudget.getBaseRequest()
					.getLoggedInUserId());
			taskEstimatedCost.setModifiedBy(taskBudget.getBaseRequest()
					.getLoggedInUserId());
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setProjectTaskId(taskBudgetEstimate.getTaskId());
			taskEstimatedCost.setTask(taskDTO);
			costList.add(taskEstimatedCost);
		}
		taskBudgetRequest.setCostList(costList);
		return taskBudgetRequest;

	}
}
