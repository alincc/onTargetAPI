package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectRequest;
import com.ontarget.dto.ProjectResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    @Override
    @Transactional(rollbackFor={Exception.class})
    public OnTargetResponse addProject(ProjectRequest request) throws Exception {
        logger.info("Adding new project " + request.getProject());

        //add project address first.
        Address projectAddress = request.getProject().getProjectAddress();
        projectAddress.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
        int addressId = addressDAO.addAddress(projectAddress);

        projectAddress.setAddressId(addressId);

        int userId=1;//request.getUser().getUserId();

        Map<String,Object> compMap = contactDAO.getContactDetail(userId);
        int companyId = (Integer)compMap.get("contact_company_id");

        Project project=request.getProject();
        project.setCompanyId(companyId);

        int projectId = projectDAO.addProject(project);

        OnTargetResponse response = new OnTargetResponse();
        if (projectId > 0) {
            response.setReturnMessage("Successfully created project.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } else {
            throw new Exception("Error while creating project");
        }

        return response;
    }

    @Override
    public ProjectResponse getProjectDetail(int projectId) throws Exception {
        Map<String, Object> projectDetail = projectDAO.getProject(projectId);

        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName((String) projectDetail.get("PROJECT_NAME"));
        project.setProjectDescription((String) projectDetail.get("PROJECT_DESCRIPTION"));
        project.setProjectTypeId((Integer) projectDetail.get("PROJECT_TYPE_ID"));
        project.setProjectParentId((Integer) projectDetail.get("PROJECT_PARENT_ID"));
        project.setCompanyId((Integer) projectDetail.get("COMPANY_ID"));

        //set project address
        Address projectAddress = addressDAO.getAddress(((Integer) projectDetail.get("ADDRESS_ID")).intValue());
        project.setProjectAddress(projectAddress);

        //get list of tasks.
        List<Task> tasks = taskDAO.getTask(projectId);
        project.setTaskList(tasks);

        ProjectResponse response = new ProjectResponse();
        response.setProject(project);
        return response;
    }

    @Override
    public ProjectListResponse getProjectsByCompany(Company company, User user) throws Exception {
        List<Map<String, Object>> projects = projectDAO.getProjectByCompany(company.getCompanyId(), user.getUserId());
        List<Project> projectList = new ArrayList<Project>();
        ProjectListResponse response = new ProjectListResponse();
        response.setProjects(projectList);

        if(projects == null || projects.size() == 0){
            return response;
        }

        for (Map<String, Object> projectDetail : projects) {
            Project project = new Project();
            project.setProjectId((Integer) projectDetail.get("PROJECT_ID"));
            project.setProjectName((String) projectDetail.get("PROJECT_NAME"));
            project.setProjectDescription((String) projectDetail.get("PROJECT_DESCRIPTION"));
            project.setProjectTypeId((Integer) projectDetail.get("PROJECT_TYPE_ID"));
            project.setProjectParentId((Integer) projectDetail.get("PROJECT_PARENT_ID"));
            project.setCompanyId((Integer) projectDetail.get("COMPANY_ID"));

            //set project address
            Address projectAddress = addressDAO.getAddress(((Integer) projectDetail.get("ADDRESS_ID")).intValue());
            project.setProjectAddress(projectAddress);

            //get list of tasks.
            List<Task> tasks = taskDAO.getTask(project.getProjectId());
            project.setTaskList(tasks);

            projectList.add(project);

        }
        return response;
    }


}
