package com.ontarget.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDependentRequest;
import com.ontarget.dto.TaskBudgetRequest;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.request.bean.AccidentReportRequest;
import com.ontarget.request.bean.ActivityDetailInfo;
import com.ontarget.request.bean.DependentTask;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.TaskBudget;
import com.ontarget.request.bean.TaskBudgetEstimate;
import com.ontarget.request.bean.UserCompanyInfo;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInvitationRequest;
import com.ontarget.request.bean.UserSignupRequest;

public class ConvertPOJOUtils {

	public static UserInvitationRequestDTO convertToUserInvitationDTO(UserInvitationRequest userInvitationRequest, String token) {
		UserInvitationRequestDTO userInvitationRequestDTO = new UserInvitationRequestDTO();
		userInvitationRequestDTO.setFirstName(userInvitationRequest.getFirstName());
		userInvitationRequestDTO.setLastName(userInvitationRequest.getLastName());
		userInvitationRequestDTO.setEmail(userInvitationRequest.getEmail());
		userInvitationRequestDTO.setMsg(userInvitationRequest.getMsg());
		userInvitationRequestDTO.setPhoneNumber(userInvitationRequest.getPhoneNumber());
		userInvitationRequestDTO.setToken(token);
		userInvitationRequestDTO.setCompanyId(userInvitationRequest.getCompanyId());
		userInvitationRequestDTO.setCompanyName(userInvitationRequest.getCompanyName());
		userInvitationRequestDTO.setCompanyAddress1(userInvitationRequest.getCompanyAddress1());
		userInvitationRequestDTO.setCompanyAddress2(userInvitationRequest.getCompanyAddress2());
		userInvitationRequestDTO.setCompanyCity(userInvitationRequest.getCompanyCity());
		userInvitationRequestDTO.setCompanyState(userInvitationRequest.getCompanyState());
		userInvitationRequestDTO.setCompanyCountry(userInvitationRequest.getCompanyCountry());
		userInvitationRequestDTO.setCompanyZip(userInvitationRequest.getCompanyZip());
		userInvitationRequestDTO.setCompanyTypeId(userInvitationRequest.getCompanyTypeId());
		return userInvitationRequestDTO;
	}

	public static UserInvitationRequestDTO convertToUserInvitationDTO(InviteUserIntoProjectRequest userInvitationRequest, String token) {
		UserInvitationRequestDTO userInvitationRequestDTO = new UserInvitationRequestDTO();
		userInvitationRequestDTO.setFirstName(userInvitationRequest.getFirstName());
		userInvitationRequestDTO.setLastName(userInvitationRequest.getLastName());
		userInvitationRequestDTO.setEmail(userInvitationRequest.getEmail());
		userInvitationRequestDTO.setToken(token);
		userInvitationRequestDTO.setCompanyId(userInvitationRequest.getCompanyId());
		userInvitationRequestDTO.setCompanyName(userInvitationRequest.getCompanyName());
		userInvitationRequestDTO.setCompanyAddress1(userInvitationRequest.getCompanyAddress1());
		userInvitationRequestDTO.setCompanyAddress2(userInvitationRequest.getCompanyAddress2());
		userInvitationRequestDTO.setCompanyCity(userInvitationRequest.getCompanyCity());
		userInvitationRequestDTO.setCompanyState(userInvitationRequest.getCompanyState());
		userInvitationRequestDTO.setCompanyCountry(userInvitationRequest.getCompanyCountry());
		userInvitationRequestDTO.setCompanyZip(userInvitationRequest.getCompanyZip());
		userInvitationRequestDTO.setCompanyTypeId(userInvitationRequest.getCompanyTypeId());
		userInvitationRequestDTO.setCompanyLogoPath(userInvitationRequest.getCompanyLogoPath());
		userInvitationRequestDTO.setProjectId(userInvitationRequest.getProjectId());
		return userInvitationRequestDTO;
	}

	public static Company convertToCompany(UserCompanyInfo userCompanyInfo) {
		Company company = new Company();
		company.setCompanyName(userCompanyInfo.getCompanyName());
		if (userCompanyInfo.getCompanyTypeId() != null) {
			company.setCompanyTypeId(userCompanyInfo.getCompanyTypeId());
		}
		company.setWebsite(userCompanyInfo.getWebsite());

		AddressDTO addressDTO = new AddressDTO();
		UserAddressInfo userAddressInfo = userCompanyInfo.getAddress();
		addressDTO.setAddress1(userAddressInfo.getAddress1());
		addressDTO.setAddress2(userAddressInfo.getAddress2());
		addressDTO.setAddressType(userAddressInfo.getAddressType());
		addressDTO.setCity(userAddressInfo.getCity());
		addressDTO.setCountry(userAddressInfo.getCountry());
		addressDTO.setState(userAddressInfo.getState());
		addressDTO.setZip(userAddressInfo.getZip());

		company.setAddress(addressDTO);

		return company;
	}

	public static Company convertToCompany(UserRegistration userRegistration) {
		Company company = new Company();
		company.setCompanyName(userRegistration.getCompanyName());
		if (userRegistration.getCompanyTypeId() != 0) {
			company.setCompanyTypeId(userRegistration.getCompanyTypeId());
		}
		company.setWebsite(userRegistration.getCompanyWebsite());
		company.setCompanyLogoPath(userRegistration.getCompanyLogoPath());

		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress1(userRegistration.getCompanyAddress1());
		addressDTO.setAddress2(userRegistration.getCompanyAddress2());
		addressDTO.setAddressType(OnTargetConstant.AddressType.COMPANY_ADDR);
		addressDTO.setCity(userRegistration.getCompanyCity());
		addressDTO.setCountry(userRegistration.getCompanyCountry());
		addressDTO.setState(userRegistration.getCompanyState());
		addressDTO.setZip(userRegistration.getCompanyZip());

		company.setAddress(addressDTO);

		return company;
	}

	public static Contact convertToContact(UserContactInfo userContactInfo) {
		Contact contact = new Contact();
		contact.setFirstName(userContactInfo.getFirstName());
		contact.setLastName(userContactInfo.getLastName());
		contact.setTitle(userContactInfo.getTitle());
		contact.setUserImagePath(userContactInfo.getUserImagePath());
		return contact;
	}

	public static Contact convertToContact(UserSignupRequest request) {
		Contact contact = new Contact();
		contact.setFirstName(request.getFirstName());
		contact.setLastName(request.getLastName());
		contact.setTitle(request.getTitle());
		contact.setUserImagePath(request.getUserImagePath());
		return contact;
	}

	public static AddressDTO convertToAddressDTO(ProjectAddressInfo projectAddress) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress1(projectAddress.getAddress1());
		addressDTO.setAddress2(projectAddress.getAddress2());
		addressDTO.setCity(projectAddress.getCity());
		addressDTO.setState(projectAddress.getState());
		addressDTO.setZip(projectAddress.getZip());
		addressDTO.setCountry(projectAddress.getCountry());
		if (projectAddress.getAddressId() != null) {
			addressDTO.setAddressId(projectAddress.getAddressId());
		}
		return addressDTO;
	}

	public static ProjectDTO convertToProjectDTO(ProjectDetailInfo project, AddressDTO addressDTO) {
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
		projectDTO.setUnitOfMeasurement(project.getUnitOfMeasurement());
		projectDTO.setProjectImagePath(project.getProjectImagePath());
		projectDTO.setProjectAssetFolderName(project.getProjectAssetFolderName());
		return projectDTO;
	}

	public static ProjectDTO convertActivityToProjectDTO(ActivityDetailInfo project) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(project.getProjectId());
		projectDTO.setProjectParentId(project.getProjectParentId());
		projectDTO.setProjectTypeId(project.getProjectTypeId());
		projectDTO.setStartDate(project.getStartDate());
		projectDTO.setEndDate(project.getEndDate());
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setProjectDescription(project.getProjectDescription());
		projectDTO.setStatus(project.getStatus());
		return projectDTO;
	}

	public static ProjectDTO setMainProject(CompanyInfo company) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectParentId(0);
		projectDTO.setProjectTypeId(1);
		projectDTO.setStartDate(new Date());
		projectDTO.setEndDate(DateFormater.addMonths(new Date(), 200));
		projectDTO.setProjectName(company.getCompanyName() + "'s Project");
		projectDTO.setProjectDescription(company.getCompanyName() + "'s Project");
		return projectDTO;
	}

	public static AccidentReport convertToAccidentReport(AccidentReportRequest accidentReportRequestBean) {
		AccidentReport accidentReport = new AccidentReport();
		accidentReport.setProjectId(accidentReportRequestBean.getProjectId());
		accidentReport.setBodyPartAffected(accidentReportRequestBean.getBodyPartAffected());
		accidentReport.setBriefOfAccident(accidentReportRequestBean.getBriefOfAccident());
		accidentReport.setCorrectionMeasuresPerformed(accidentReportRequestBean.getCorrectionMeasuresPerformed());
		accidentReport.setCorrectionMeasuresToBePerformed(accidentReportRequestBean.getCorrectionMeasuresToBePerformed());
		accidentReport.setDateInjuredLeftJob(accidentReportRequestBean.getDateInjuredLeftJob());
		accidentReport.setDateOfAccident(accidentReportRequestBean.getDateOfAccident());
		accidentReport.setDescription(accidentReportRequestBean.getDescription());
		accidentReport.setInjuredLeftJob(accidentReportRequestBean.getInjuredLeftJob());
		accidentReport.setInjuredVisitedDoctor(accidentReportRequestBean.getInjuredVisitedDoctor());
		accidentReport.setLocation(accidentReportRequestBean.getLocation());
		accidentReport.setPossiblePreventiveMeasures(accidentReportRequestBean.getPossiblePreventiveMeasures());
		accidentReport.setSeverity(accidentReportRequestBean.getSeverity());
		accidentReport.setSubmittedTo(accidentReportRequestBean.getSubmittedTo());
		accidentReport.setSupervisorName(accidentReportRequestBean.getSupervisorName());
		accidentReport.setTimeInjuredLeftJob(accidentReportRequestBean.getTimeInjuredLeftJob());
		accidentReport.setTimeOfAccident(accidentReportRequestBean.getTimeOfAccident());
		accidentReport.setUnsafeConditionsCorrected(accidentReportRequestBean.getUnsafeConditionsCorrected());
		accidentReport.setWitness(accidentReportRequestBean.getWitness());
		accidentReport.setWorkersCompensationFiled(accidentReportRequestBean.getWorkersCompensationFiled());
		return accidentReport;
	}

	public static AddDependentRequest convertToAddDependentRequest(DependentTaskRequest dependentTaskRequest) {
		DependentTask dependentTask = dependentTaskRequest.getDependentTask();

		AddDependentRequest addDependentRequest = new AddDependentRequest();
		DependentTaskDTO dependentTaskDTO = new DependentTaskDTO();
		if (dependentTask.getTaskId() != null) {
			dependentTaskDTO.setTaskId(dependentTask.getTaskId());
		}
		if (dependentTask.getDependentTaskId() != null) {
			dependentTaskDTO.setDependentTaskId(dependentTask.getDependentTaskId());
		}
		if (dependentTask.getCategoryId() != null) {
			dependentTaskDTO.setCategory_id(dependentTask.getCategoryId());
		}
		dependentTaskDTO.setCreatedBy(dependentTaskRequest.getBaseRequest().getLoggedInUserId());

		addDependentRequest.setDependentTask(dependentTaskDTO);

		return addDependentRequest;
	}

	public static TaskBudgetRequest convertToTaskBudgetRequest(TaskBudget taskBudget) {
		TaskBudgetRequest taskBudgetRequest = new TaskBudgetRequest();

		List<TaskEstimatedCost> costList = new ArrayList<TaskEstimatedCost>();

		List<TaskBudgetEstimate> taskEstimates = taskBudget.getTaskBudgetEstimates();

		for (TaskBudgetEstimate taskBudgetEstimate : taskEstimates) {
			TaskEstimatedCost taskEstimatedCost = new TaskEstimatedCost();
			taskEstimatedCost.setCost(taskBudgetEstimate.getCost());
			taskEstimatedCost.setCostType(taskBudgetEstimate.getCostType());
			taskEstimatedCost.setFromDate(taskBudgetEstimate.getFromDate());
			taskEstimatedCost.setToDate(taskBudgetEstimate.getToDate());
			taskEstimatedCost.setId(taskBudgetEstimate.getId());
			taskEstimatedCost.setCreatedBy(taskBudget.getBaseRequest().getLoggedInUserId());
			taskEstimatedCost.setModifiedBy(taskBudget.getBaseRequest().getLoggedInUserId());
			taskEstimatedCost.setTaskId(taskBudgetEstimate.getTaskId());
			costList.add(taskEstimatedCost);
		}
		taskBudgetRequest.setCostList(costList);
		return taskBudgetRequest;

	}
}
