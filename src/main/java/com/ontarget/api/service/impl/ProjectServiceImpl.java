package com.ontarget.api.service.impl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

=======
import com.ontarget.api.dao.*;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
>>>>>>> origin/ontarget.phase4
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.util.ConvertPOJOUtils;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

<<<<<<< HEAD
	private Logger logger = Logger.getLogger(ProjectServiceImpl.class);
=======
    private Logger logger = Logger.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private UserRegistrationDAO userRegistrationDAO;

    @Autowired
    private TaskPercentageDAO taskPercentageDAO;


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public OnTargetResponse addProject(ProjectRequest request) throws Exception {
        logger.info("Adding new project " + request.getProject());
>>>>>>> origin/ontarget.phase4

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private AddressDAO addressDAO;

<<<<<<< HEAD
	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private ContactDAO contactDAO;
=======
        int userId = request.getUser().getUserId();

        int companyId = request.getProject().getCompanyId();
        if (request.getProject().getProjectParentId() == 0) {
            Map<String, Object> compMap = contactDAO.getContactDetail(userId);
            companyId = (Integer) compMap.get("contact_company_id");
        }

        Project project = request.getProject();
        project.setCompanyId(companyId);
        project.setProjectOwnerId(userId);

        int projectId = projectDAO.addProject(project, userId);

        //add the user to project member;
        int projectMemberId = 0;
        if (OnTargetConstant.AccountStatus.ACCT_NEW.equals(request.getUser().getAccountStatus())) {
            projectMemberId = projectDAO.addProjectMember(projectId, userId);
            if (projectMemberId < 0) {
                throw new Exception("Error while adding the new member: " + userId);
            }


        }

        //activate the account if accountStatus of user is ACCT_NEW
        if (OnTargetConstant.AccountStatus.ACCT_NEW.equals(request.getUser().getAccountStatus())) {
            int updated = userRegistrationDAO.activateAccount(userId);
            if (updated == 0) {
                throw new Exception("Error while activating account");
            }
        }

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
    @Transactional(rollbackFor = {Exception.class})
    public OnTargetResponse updateProject(ProjectRequest request) throws Exception {
        logger.info("Updating project " + request.getProject());

        //add project address first.
        Address projectAddress = request.getProject().getProjectAddress();
        projectAddress.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
        int addressId = projectAddress.getAddressId();

        boolean updated = addressDAO.updateAddress(projectAddress);
        if (!updated) {
            throw new Exception("Error while updating address");
        }

        Project project = request.getProject();
        boolean updatedPr = projectDAO.updateProject(project, request.getUser().getUserId());

        OnTargetResponse response = new OnTargetResponse();
        if (updatedPr) {
            response.setReturnMessage("Successfully updated project.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } else {
            throw new Exception("Error while updating project");
        }

        return response;
    }

    public Project getProject(long projectId) throws Exception {
        Project project = projectDAO.getProject((int) projectId);
//        setProjectLevel(project, 1);
        return project;
    }

    public Project getProjectTree(long projectId) throws Exception {
        Project project = projectDAO.getProject((int) projectId);
        setProjectLevel(project, 1);
        return project;
    }

    @Override
    public ProjectResponse getProjectDetail(long projectId) throws Exception {
        Project project = getProjectTree(projectId);

        ProjectResponse response = new ProjectResponse();
        response.setProject(project);

        project.setCompany(companyDAO.getCompany(project.getCompanyId()));
        if (project.getProjectId() > 0) {

            //set project address
            Address address = project.getProjectAddress();
            if (address == null) {
                logger.info("address is null for project " + project);
            } else {
                Address projectAddress = addressDAO.getAddress(address.getAddressId());
                project.setProjectAddress(projectAddress);
            }

            //get list of tasks.
            List<Task> tasks = taskDAO.getTask(projectId);
            project.setTaskList(tasks);
        }

        response.setProject(project);
        return response;
    }

    public List<Project> setProjectLevel(Project project, int level) throws Exception {
        List<Project> projects = projectDAO.getChildProjects(project.getProjectId());
        if (level < 20 && projects != null && !projects.isEmpty()) {
            level++;
            for (Project p : projects) {
                setProjectLevel(p, level);
            }
        }

        project.setProjects(projects);
        return projects;
    }

    @Override
    public ProjectMemberListResponse getProjectMembers(long projectId) throws Exception {
        List<ProjectMember> projectMembers = projectDAO.getProjectMembers(projectId);
        Map<Long, Contact> contactMap = new HashMap<>();
        for (ProjectMember member : projectMembers) {
            long userId = member.getUserId();
            if (contactMap.containsKey(userId)) {
                member.setContact(contactMap.get(userId));
            } else {
                Contact contact = contactDAO.getContact(userId);
                contactMap.put(userId, contact);
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
        List<Project> projectList = new ArrayList<Project>();
        response.setProjects(projectList);

        if (projects == null || projects.size() == 0) {
            return response;
        }
        Project parentProject = new Project();

        for (Map<String, Object> projectDetail : projects) {

            int parentProjectId = (Integer) projectDetail.get("PROJECT_PARENT_ID");
            Project project = new Project();
            project.setProjectId((Integer) projectDetail.get("PROJECT_ID"));
            project.setProjectName((String) projectDetail.get("PROJECT_NAME"));
            project.setProjectDescription((String) projectDetail.get("PROJECT_DESCRIPTION"));
            project.setProjectTypeId((Integer) projectDetail.get("PROJECT_TYPE_ID"));
            project.setProjectParentId((Integer) projectDetail.get("PROJECT_PARENT_ID"));
            Integer companyId = (Integer) projectDetail.get("COMPANY_ID");
            project.setCompanyId(companyId);
            project.setProjectImagePath((String) projectDetail.get("project_image_path"));
            project.setStartDate((Date) projectDetail.get("project_start_date"));
            project.setEndDate((Date) projectDetail.get("project_end_date"));
            project.setStatus((String) projectDetail.get("project_status"));
            Company company = companyDAO.getCompany(companyId);
            project.setCompany(company);

            //set project address
            Address projectAddress = addressDAO.getAddress(((Integer) projectDetail.get("ADDRESS_ID")).intValue());
            project.setProjectAddress(projectAddress);

            //get list of tasks.
            List<Task> tasks = taskDAO.getTask(project.getProjectId());
            project.setTaskList(tasks);
            Map<Integer, Contact> contactMap = new HashMap<>(); //
            //get all the comments in the tasks and assigned to.
            if (tasks != null && tasks.size() > 0) {
                for (Task task : tasks) {
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


                    //getting task percentage latest.
                    List<TaskPercentage> taskPercentageList = taskPercentageDAO.getTaskPercentageByTask(task.getProjectTaskId());
                    if(taskPercentageList!=null && taskPercentageList.size() > 0) {
                        task.setPercentageComplete(taskPercentageList.get(0).getTaskPercentageComplete());
                    }


//                    //get task assigned to
//                    Long assignedUserId = taskDAO.getAssignedUser(task.getProjectTaskId());
//                    logger.debug("Getting contact detail for task assignee: " + assignedUserId);
//                    if (assignedUserId > 0) {
//                        Contact contact = contactDAO.getContact(assignedUserId);
//                        User assignedToUser = new User();
//                        assignedToUser.setContact(contact);
//                        task.setAssignedTo(assignedToUser);
//                    }

                    Set<Long> assignees = taskDAO.getTaskMembers(task.getProjectTaskId());

                    List<User> assignedUsers = new ArrayList<>();
                    task.setAssignee(assignedUsers);
                    if (assignees != null && assignees.size() > 0) {
                        for (Long id : assignees) {
                            Contact contact = contactDAO.getContact(id);
                            User assignedToUser = new User();
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
                List<Project> subProjects = parentProject.getProjects();
                if (subProjects == null || subProjects.isEmpty()) {
                    subProjects = new ArrayList<>();
                    parentProject.setProjects(subProjects);
                }
                subProjects.add(project);
            }


        }
        return response;
    }
>>>>>>> origin/ontarget.phase4

	@Autowired
	private CompanyDAO companyDAO;

	@Autowired
	private UserRegistrationDAO userRegistrationDAO;

	@Autowired
	private TaskPercentageDAO taskPercentageDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addProject(ProjectRequest request) throws Exception {
		logger.info("Adding new project " + request.getProject());

		ProjectAddressInfo projectAdd = request.getProject()
				.getProjectAddress();

		AddressDTO addressDTO = ConvertPOJOUtils
				.convertToAddressDTO(projectAdd);

		addressDTO.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
		int addressId = addressDAO.addAddress(addressDTO);
		addressDTO.setAddressId(addressId);

		int userId = request.getUserId();

		int companyId = request.getProject().getCompanyId();
		if (request.getProject().getProjectParentId() == null
				|| request.getProject().getProjectParentId() == 0) {
			Map<String, Object> compMap = contactDAO.getContactDetail(userId);
			companyId = (Integer) compMap.get("contact_company_id");
		}

		ProjectDetailInfo projectObj = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertToProjectDTO(
				projectObj, addressDTO);

		projectDTO.setCompanyId(companyId);
		projectDTO.setProjectOwnerId(userId);

		int projectId = projectDAO.addProject(projectDTO, userId);

		// add the user to project member;
		int projectMemberId = 0;
		if (OnTargetConstant.AccountStatus.ACCT_NEW.equals(request
				.getAccountStatus())) {
			projectMemberId = projectDAO.addProjectMember(projectId, userId);
			if (projectMemberId < 0) {
				throw new Exception("Error while adding the new member: "
						+ userId);
			}

		}

		// activate the account if accountStatus of user is ACCT_NEW
		if (OnTargetConstant.AccountStatus.ACCT_NEW.equals(request
				.getAccountStatus())) {
			int updated = userRegistrationDAO.activateAccount(userId);
			if (updated == 0) {
				throw new Exception("Error while activating account");
			}
		}

		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			response.setReturnMessage("Successfully created project.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			throw new Exception("Error while creating project: projectId: "
					+ projectId);
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse updateProject(ProjectRequest request)
			throws Exception {
		logger.info("Updating project " + request.getProject());

		// add project address first.
		ProjectAddressInfo projectAddress = request.getProject()
				.getProjectAddress();

		AddressDTO addressDTO = ConvertPOJOUtils
				.convertToAddressDTO(projectAddress);
		addressDTO.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);

		boolean updated = addressDAO.updateAddress(addressDTO);
		if (!updated) {
			throw new Exception("Error while updating address");
		}

		ProjectDetailInfo project = request.getProject();
		ProjectDTO projectDTO = ConvertPOJOUtils.convertToProjectDTO(project,
				addressDTO);
		boolean updatedPr = projectDAO.updateProject(projectDTO,
				request.getUserId());

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
					AddressDTO projectAddress = addressDAO.getAddress(address
							.getAddressId());
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

	public List<ProjectInfo> setProjectLevel(ProjectInfo project, int level)
			throws Exception {
		List<ProjectInfo> projects = projectDAO.getChildProjects(project
				.getProjectId());
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
	public ProjectMemberListResponse getProjectMembers(int projectId)
			throws Exception {
		List<ProjectMember> projectMembers = projectDAO
				.getProjectMembers(projectId);
		Map<Long, Contact> contactMap = new HashMap<>();
		for (ProjectMember member : projectMembers) {
			long userId = member.getUserId();
			if (contactMap.containsKey(userId)) {
				member.setContact(contactMap.get(userId));
			} else {
				Contact contact = contactDAO.getContact(userId);
				contactMap.put(userId, contact);
				member.setContact(contact);
			}
		}
		ProjectMemberListResponse response = new ProjectMemberListResponse();
		response.setProjectId(projectId);

		response.setProjectMemberList(projectMembers);
		return response;
	}

	@Override
	public ProjectListResponse getProjectsByCompany(int companyId, int userId)
			throws Exception {
		List<Map<String, Object>> projects = projectDAO.getProjectByCompany(
				companyId, userId);
		return this.getProjectResponse(projects);
	}

	public List<Company> getCompanyByProject(int projectId) throws Exception {
		return projectDAO.getCompanyByProject(projectId);
	}

	@Override
	public ProjectListResponse getProjectsByUser(int userId) throws Exception {
		List<Map<String, Object>> projects = projectDAO
				.getProjectByUser(userId);
		return this.getProjectResponse(projects);
	}

	private ProjectListResponse getProjectResponse(
			List<Map<String, Object>> projects) throws Exception {
		ProjectListResponse response = new ProjectListResponse();
		List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		response.setProjects(projectList);

		if (projects == null || projects.size() == 0) {
			return response;
		}
		ProjectDTO parentProject = new ProjectDTO();

		for (Map<String, Object> projectDetail : projects) {

			int parentProjectId = (Integer) projectDetail
					.get("PROJECT_PARENT_ID");
			ProjectDTO project = new ProjectDTO();
			project.setProjectId((Integer) projectDetail.get("PROJECT_ID"));
			project.setProjectName((String) projectDetail.get("PROJECT_NAME"));
			project.setProjectDescription((String) projectDetail
					.get("PROJECT_DESCRIPTION"));
			project.setProjectTypeId((Integer) projectDetail
					.get("PROJECT_TYPE_ID"));
			project.setProjectParentId((Integer) projectDetail
					.get("PROJECT_PARENT_ID"));
			Integer companyId = (Integer) projectDetail.get("COMPANY_ID");
			project.setCompanyId(companyId);
			project.setProjectImagePath((String) projectDetail
					.get("project_image_path"));
			project.setStartDate((Date) projectDetail.get("project_start_date"));
			project.setEndDate((Date) projectDetail.get("project_end_date"));
			project.setStatus((String) projectDetail.get("project_status"));

			Company company = companyDAO.getCompany(companyId);
			project.setCompany(company);

			AddressDTO projectAddress = addressDAO
					.getAddress(((Integer) projectDetail.get("ADDRESS_ID"))
							.intValue());
			project.setProjectAddress(projectAddress);

			List<TaskInfo> tasks = taskDAO.getTask(project.getProjectId());
			project.setTaskList(tasks);
			Map<Integer, Contact> contactMap = new HashMap<>(); //
			// get all the comments in the tasks and assigned to.
			if (tasks != null && tasks.size() > 0) {
				for (TaskInfo task : tasks) {
					List<TaskComment> comments = taskDAO.getTaskComments(task
							.getProjectTaskId());
					for (TaskComment comment : comments) {
						int commentedBy = comment.getCommentedBy();
						if (contactMap.containsKey(commentedBy)) {
							comment.setCommenterContact(contactMap
									.get(commentedBy));
						} else {
							Contact contact = contactDAO
									.getContact(commentedBy);
							contactMap.put(commentedBy, contact);
							comment.setCommenterContact(contact);
						}
					}
					task.setComments(comments);
					List<TaskPercentage> taskPercentageList = taskPercentageDAO
							.getTaskPercentageByTask(task.getProjectTaskId());
					if (taskPercentageList != null
							&& taskPercentageList.size() > 0) {
						task.setPercentageComplete(taskPercentageList.get(0)
								.getTaskPercentageComplete());
					}

					Set<Integer> assignees = taskDAO.getTaskMembers(task
							.getProjectTaskId());
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
}
