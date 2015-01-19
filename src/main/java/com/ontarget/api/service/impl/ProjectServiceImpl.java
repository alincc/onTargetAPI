package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

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


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public OnTargetResponse addProject(ProjectRequest request) throws Exception {
        logger.info("Adding new project " + request.getProject());

        //add project address first.
        Address projectAddress = request.getProject().getProjectAddress();
        projectAddress.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
        int addressId = addressDAO.addAddress(projectAddress);

        projectAddress.setAddressId(addressId);

        int userId = request.getUser().getUserId();

        Map<String, Object> compMap = contactDAO.getContactDetail(userId);
        int companyId = (Integer) compMap.get("contact_company_id");

        Project project = request.getProject();
        project.setCompanyId(companyId);
        project.setProjectOwnerId(userId);

        int projectId = projectDAO.addProject(project);

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
            if(address == null){
                logger.info("address is null for project "+project);
            }
            else{
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
            Company company = companyDAO.getCompany(companyId);
            project.setCompany(company);
            //set project address
            Address projectAddress = addressDAO.getAddress(((Integer) projectDetail.get("ADDRESS_ID")).intValue());
            project.setProjectAddress(projectAddress);

            //get list of tasks.
            List<Task> tasks = taskDAO.getTask(project.getProjectId());
            project.setTaskList(tasks);

            //get all the comments in the tasks and assigned to.
            if (tasks != null && tasks.size() > 0) {
                for (Task task : tasks) {
                    List<TaskComment> comments = taskDAO.getTaskComments(task.getProjectTaskId());
                    task.setComments(comments);

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
                    if(assignees !=null && assignees.size() > 0){
                        for(Long id : assignees){
                            Contact contact = contactDAO.getContact(id);
                            User assignedToUser = new User();
                            assignedToUser.setContact(contact);
                            assignedToUser.setUserId((id.intValue()));
                            assignedUsers.add(assignedToUser);
                        }
                    }else {
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

}
