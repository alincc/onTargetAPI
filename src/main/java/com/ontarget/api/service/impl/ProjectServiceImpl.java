package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AddressDAO;
import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.dao.UserRegistrationDAO;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.bean.ProjectMember;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskObj;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectMemberListResponse;
import com.ontarget.dto.ProjectResponse;
import com.ontarget.dto.UserProjectListResponse;
import com.ontarget.entities.Project;
import com.ontarget.request.bean.ActivityDetailInfo;
import com.ontarget.request.bean.ActivityRequest;
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.util.ConvertPOJOUtils;
import com.ontarget.util.ProjectUtil;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	private Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Autowired
	@Qualifier("addressJpaDAOImpl")
	private AddressDAO addressDAO;

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	@Qualifier("companyJpaDAOImpl")
	private CompanyDAO companyDAO;

	@Autowired
	@Qualifier("userRegistrationJpaDAOImpl")
	private UserRegistrationDAO userRegistrationDAO;

	@Autowired
	@Qualifier("taskPercentageJpaDAOImpl")
	private TaskPercentageDAO taskPercentageDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addProject(ProjectRequest request) throws Exception {
		logger.info("Adding new project " + request.getProject());

		ProjectAddressInfo projectAdd = request.getProject().getProjectAddress();

		AddressDTO addressDTO = ConvertPOJOUtils.convertToAddressDTO(projectAdd);

		addressDTO.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
		int addressId = addressDAO.addAddress(addressDTO);
		addressDTO.setAddressId(addressId);

		int userId = request.getUserId();

		ProjectDetailInfo projectObj = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertToProjectDTO(projectObj, addressDTO);

		int companyId = request.getProject().getCompanyId();
		if (request.getProject().getProjectParentId() == null || request.getProject().getProjectParentId() == 0) {
			Map<String, Object> compMap = contactDAO.getContactDetail(userId);
			companyId = (Integer) compMap.get("contact_company_id");
		}

		projectDTO.setCompanyId(companyId);
		projectDTO.setProjectOwnerId(userId);

		int projectId = projectDAO.addProject(projectDTO, userId);

		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			response.setReturnMessage("Successfully created project.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			throw new Exception("Error while creating project: projectId: " + projectId);
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse updateProject(ProjectRequest request) throws Exception {
		logger.info("Updating project " + request.getProject());

		ProjectAddressInfo projectAddress = request.getProject().getProjectAddress();

		AddressDTO addressDTO = ConvertPOJOUtils.convertToAddressDTO(projectAddress);
		addressDTO.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);

		boolean updated = addressDAO.updateAddress(addressDTO);
		if (!updated) {
			throw new Exception("Error while updating address");
		}

		ProjectDetailInfo project = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertToProjectDTO(project, addressDTO);
		boolean updatedPr = projectDAO.updateProject(projectDTO, request.getUserId());

		OnTargetResponse response = new OnTargetResponse();
		if (updatedPr) {
			response.setReturnMessage("Successfully updated project.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			throw new Exception("Error while updating project");
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addActivity(ActivityRequest request) throws Exception {
		logger.info("Adding new activity " + request.getProject());

		int userId = request.getUserId();

		ActivityDetailInfo projectObj = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertActivityToProjectDTO(projectObj);

		int companyId = request.getProject().getCompanyId();
		if (request.getProject().getProjectParentId() == null || request.getProject().getProjectParentId() == 0) {
			Map<String, Object> compMap = contactDAO.getContactDetail(userId);
			companyId = (Integer) compMap.get("contact_company_id");
		}

		projectDTO.setCompanyId(companyId);
		projectDTO.setProjectOwnerId(userId);

		int projectId = projectDAO.addActivity(projectDTO, userId);

		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			response.setReturnMessage("Successfully created activity.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			throw new Exception("Error while creating activity: activityId: " + projectId);
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse updateActivity(ActivityRequest request) throws Exception {
		logger.info("Updating activity " + request.getProject());

		ActivityDetailInfo project = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertActivityToProjectDTO(project);
		boolean updatedPr = projectDAO.updateActivity(projectDTO, request.getUserId());

		OnTargetResponse response = new OnTargetResponse();
		if (updatedPr) {
			response.setReturnMessage("Successfully updated activity.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			throw new Exception("Error while updating activity");
		}

		return response;
	}

	@Override
	public ProjectInfo getProject(int projectId) throws Exception {
		ProjectInfo project = projectDAO.getProjectInfo(projectId);
		setProjectLevel(project, 1);
		return project;
	}

	@Override
	public ProjectInfo getProjectTree(int projectId) throws Exception {
		ProjectInfo project = projectDAO.getProjectInfo(projectId);
		setProjectLevel(project, 1);
		return project;
	}

	@Override
	public ProjectResponse getProjectDetail(int projectId) {
		try {
			ProjectInfo project = getProjectTree(projectId);

			ProjectResponse response = new ProjectResponse();
			response.setProject(project);

			project.setCompany(companyDAO.getCompany(project.getCompanyId()));
			if (project.getProjectId() > 0) {
				AddressDTO address = project.getProjectAddress();
				if (address == null) {
					logger.info("address is null for project " + project);
				} else {
					AddressDTO projectAddress = addressDAO.getAddress(address.getAddressId());
					project.setProjectAddress(projectAddress);
				}
				List<TaskObj> tasks = taskDAO.getTaskObjList(projectId);
				project.setTaskList(tasks);
			}
			response.setProject(project);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error: " + e);
			return null;
		}
	}

	public List<ProjectInfo> setProjectLevel(ProjectInfo project, int level) throws Exception {
		List<ProjectInfo> projects = projectDAO.getChildProjects(project.getProjectId());
		if (level < 20 && projects != null && !projects.isEmpty()) {
			level++;
			for (ProjectInfo p : projects) {
				setProjectLevel(p, level);
			}
		}
		project.setProjects(projects);
		return projects;
	}

	@Override
	public ProjectMemberListResponse getProjectMembers(int projectId) throws Exception {
		List<ProjectMember> projectMembers = projectDAO.getProjectMembers(projectId);
		Map<Long, Contact> contactMap = new HashMap<>();
		for (ProjectMember member : projectMembers) {
			int userId = (int) member.getUserId();
			if (contactMap.containsKey(userId)) {
				member.setContact(contactMap.get(userId));
			} else {
				Contact contact = contactDAO.getContact(userId);
				contactMap.put((long) userId, contact);
				member.setContact(contact);
			}
		}
		ProjectMemberListResponse response = new ProjectMemberListResponse();
		response.setProjectId(projectId);

		response.setProjectMemberList(projectMembers);
		return response;
	}

	@Override
	public ProjectListResponse getProjectsByCompany(int companyId, int userId) throws Exception {
		List<Map<String, Object>> projects = projectDAO.getProjectByCompany(companyId, userId);
		return this.getProjectResponse(projects);
	}

	public List<Company> getCompanyByProject(int projectId) throws Exception {
		return projectDAO.getCompanyByProject(projectId);
	}

	@Override
	public ProjectListResponse getProjectsByUser(int userId) throws Exception {
		List<Map<String, Object>> projects = projectDAO.getProjectByUser(userId);
		return this.getProjectResponse(projects);
	}

	private ProjectListResponse getProjectResponse(List<Map<String, Object>> projects) throws Exception {
		ProjectListResponse response = new ProjectListResponse();
		List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		response.setProjects(projectList);

		if (projects == null || projects.size() == 0) {
			return response;
		}
		ProjectDTO parentProject = new ProjectDTO();

		for (Map<String, Object> projectDetail : projects) {

			int parentProjectId = (Integer) projectDetail.get("project_parent_id");

			ProjectDTO project = new ProjectDTO();
			project.setProjectId((Integer) projectDetail.get("project_id"));
			project.setProjectName((String) projectDetail.get("project_name"));
			project.setProjectDescription((String) projectDetail.get("project_description"));
			project.setProjectTypeId((Integer) projectDetail.get("project_type_id"));
			project.setProjectParentId((Integer) projectDetail.get("project_parent_id"));
			project.setCompanyId((Integer) projectDetail.get("company_id"));
			project.setProjectImagePath((String) projectDetail.get("project_image_path"));
			project.setStartDate((Date) projectDetail.get("project_start_date"));
			project.setEndDate((Date) projectDetail.get("project_end_date"));
			project.setStatus((String) projectDetail.get("project_status"));
			project.setType((String) projectDetail.get("type"));

			Company company = companyDAO.getCompany(project.getCompanyId());
			project.setCompany(company);

			AddressDTO projectAddress = addressDAO.getAddress(((Integer) projectDetail.get("address_id")).intValue());
			project.setProjectAddress(projectAddress);

			List<TaskInfo> tasks = taskDAO.getTask(project.getProjectId());
			project.setTaskList(tasks);
			Map<Integer, Contact> contactMap = new HashMap<>(); //
			// get all the comments in the tasks and assigned to.
			if (tasks != null && tasks.size() > 0) {
				for (TaskInfo task : tasks) {
					List<TaskComment> comments = taskDAO.getTaskComments(task.getProjectTaskId());
					for (TaskComment comment : comments) {
						int commentedBy = comment.getCommentedBy();
						if (contactMap.containsKey(commentedBy)) {
							comment.setCommenterContact(contactMap.get(commentedBy));
						} else {
							Contact contact = contactDAO.getContact(commentedBy);
							contactMap.put(commentedBy, contact);
							comment.setCommenterContact(contact);
						}
					}
					task.setComments(comments);
					List<TaskPercentage> taskPercentageList = taskPercentageDAO.getTaskPercentageByTask(task.getProjectTaskId());
					if (taskPercentageList != null && taskPercentageList.size() > 0) {
						task.setPercentageComplete(taskPercentageList.get(0).getTaskPercentageComplete());
					}

					Set<Integer> assignees = taskDAO.getTaskMembers(task.getProjectTaskId());
					List<UserDTO> assignedUsers = new ArrayList<>();
					task.setAssignee(assignedUsers);
					if (assignees != null && assignees.size() > 0) {
						for (Integer id : assignees) {
							Contact contact = contactDAO.getContact(id);
							UserDTO assignedToUser = new UserDTO();
							assignedToUser.setContact(contact);
							assignedToUser.setUserId((id.intValue()));
							assignedUsers.add(assignedToUser);
						}
					} else {
						logger.info("task is unassigned");
					}

				}
			}

			if (parentProjectId == 0) {
				parentProject = project;
				projectList.add(parentProject);
			} else {
				List<ProjectDTO> subProjects = parentProject.getProjects();
				if (subProjects == null || subProjects.isEmpty()) {
					subProjects = new ArrayList<>();
					parentProject.setProjects(subProjects);
				}
				subProjects.add(project);
			}

		}
		return response;
	}

	@Override
	public UserProjectListResponse getUserAssociatedProjectDetails(int userId) throws Exception {

		UserProjectListResponse response = new UserProjectListResponse();

		List<Project> projectList = projectDAO.getAlllAssociatedProjectsByUser(userId);
		List<ProjectDTO> projectDTOList = convertedProjectList(projectList, userId);
		response.setProjects(projectDTOList);

		for (ProjectDTO projectDTO : projectDTOList) {

			setSubProjects(projectDTO, userId, 1);
		}
		response.setResponseCode("SUCC");
		return response;

	}

	@Override
	public ProjectListResponse getUserProjectDetails(int userId) throws Exception {
		Project mainProject = projectDAO.getMainProjectByUser(userId);

		if (mainProject != null) {
			ProjectDTO project = ProjectUtil.convertToProjectDTO(mainProject);
			Company company = companyDAO.getCompany(project.getCompanyId());
			project.setCompany(company);

			return this.getUserProjectResponse(project, userId);
		} else {
			ProjectListResponse response = new ProjectListResponse();
			response.setResponseCode("PNF");
			return response;
		}
	}

	private ProjectListResponse getUserProjectResponse(ProjectDTO project, int userId) throws Exception {
		ProjectListResponse response = new ProjectListResponse();
		project.setTaskList(new ArrayList<>());
		response.setMainProject(project);

		setSubProjects(project, userId, 1);
		response.setResponseCode("SUCC");
		return response;
	}

	public void setSubProjects(ProjectDTO projectDTO, int userId, int level) throws Exception {
		List<Project> childProjects = projectDAO.getUndeletedProjectsByParentId(projectDTO.getProjectId());
		List<ProjectDTO> projectDTOList = convertedProjectList(childProjects, userId);

		if (level < 3 && projectDTOList != null && !projectDTOList.isEmpty()) {
			level++;
			for (ProjectDTO p : projectDTOList) {
				p.setTaskList(new ArrayList<>());
				getProjectTasks(userId, p);
				setSubProjects(p, userId, level);
			}
		}

		projectDTO.setProjects(projectDTOList);
	}

	private List<ProjectDTO> convertedProjectList(List<Project> projects, int userId) throws Exception {
		List<ProjectDTO> projectDTOList = new ArrayList<>();

		if (projects != null && !projects.isEmpty()) {
			for (Project proj : projects) {
				ProjectDTO project = ProjectUtil.convertToProjectDTO(proj);

				Company company = companyDAO.getCompany(project.getCompanyId());
				project.setCompany(company);
				if (!project.getType().equalsIgnoreCase(OnTargetConstant.ProjectInfoType.ACTIVITY)) {
					AddressDTO projectAddress = addressDAO.getAddress(project.getProjectAddress().getAddressId());
					project.setProjectAddress(projectAddress);
				}

				projectDTOList.add(project);
			}
		}
		return projectDTOList;
	}

	private ProjectDTO getProjectTasks(int userId, ProjectDTO project) throws Exception {
		if (project.getType().equalsIgnoreCase(OnTargetConstant.ProjectInfoType.ACTIVITY)) {
			List<TaskInfo> tasks = taskDAO.getAssignedTasksByProjectId(project.getProjectId(), userId);
			project.setTaskList(tasks);
			logger.info("task list for project id: " + project.getProjectId() + " , user id: " + userId + ", list: " + tasks);

			Map<Integer, Contact> contactMap = new HashMap<>(); //
			// get all the comments in the tasks and assigned to.
			if (tasks != null && tasks.size() > 0) {
				for (TaskInfo task : tasks) {
					List<TaskComment> comments = taskDAO.getTaskComments(task.getProjectTaskId());
					for (TaskComment comment : comments) {
						int commentedBy = comment.getCommentedBy();
						if (contactMap.containsKey(commentedBy)) {
							comment.setCommenterContact(contactMap.get(commentedBy));
						} else {
							Contact contact = contactDAO.getContact(commentedBy);
							contactMap.put(commentedBy, contact);
							comment.setCommenterContact(contact);
						}
					}
					task.setComments(comments);
					List<TaskPercentage> taskPercentageList = taskPercentageDAO.getTaskPercentageByTask(task.getProjectTaskId());
					if (taskPercentageList != null && taskPercentageList.size() > 0) {
						task.setPercentageComplete(taskPercentageList.get(0).getTaskPercentageComplete());
					}

					Set<Integer> assignees = taskDAO.getTaskMembers(task.getProjectTaskId());
					List<UserDTO> assignedUsers = new ArrayList<>();
					task.setAssignee(assignedUsers);
					if (assignees != null && assignees.size() > 0) {
						for (Integer id : assignees) {
							Contact contact = contactDAO.getContact(id);
							UserDTO assignedToUser = new UserDTO();
							assignedToUser.setContact(contact);
							assignedToUser.setUserId((id.intValue()));
							assignedUsers.add(assignedToUser);
						}
					} else {
						logger.info("task is unassigned");
					}

				}
			}
		}
		return project;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean deleteProject(int projectId, int userId) {
		try {
			return projectDAO.deleteProject(projectId, userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error: " + e);
			return false;
		}
	}

}
