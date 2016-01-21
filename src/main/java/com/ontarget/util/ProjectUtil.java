package com.ontarget.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.ProjectConfigDTO;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Address;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectConfiguration;
import com.ontarget.entities.ProjectType;

public class ProjectUtil {

	public static String getTypeForProject(Project parentProject) {
		if (parentProject == null) {
			return OnTargetConstant.ProjectInfoType.MAIN_PROJECT;
		} else if (parentProject.getType().equalsIgnoreCase(OnTargetConstant.ProjectInfoType.MAIN_PROJECT)) {
			return OnTargetConstant.ProjectInfoType.PROJECT;
		} else {
			return OnTargetConstant.ProjectInfoType.ACTIVITY;
		}
	}

	public static List<Project> convertMapToProjectList(List<Map<String, Object>> projectMapList) {
		List<Project> projects = new ArrayList<>();

		for (Map<String, Object> projectDetail : projectMapList) {
			Project project = new Project();
			project.setProjectId((Integer) projectDetail.get("project_id"));
			project.setProjectName((String) projectDetail.get("project_name"));
			project.setProjectDescription((String) projectDetail.get("project_description"));
			project.setProjectType(new ProjectType((Integer) projectDetail.get("project_type_id")));
			project.setProjectParentId((Integer) projectDetail.get("project_parent_id"));
			//project.setCompanyInfo(new CompanyInfo((Integer) projectDetail.get("company_id")));
			project.setProjectImagePath((String) projectDetail.get("project_image_path"));
			project.setProjectStartDate((Date) projectDetail.get("project_start_date"));
			project.setProjectEndDate((Date) projectDetail.get("project_end_date"));
			project.setProjectStatus((Integer) projectDetail.get("project_status"));
			project.setType((String) projectDetail.get("type"));
			project.setAddress(new Address((Integer) projectDetail.get("address_id")));
			projects.add(project);
		}
		return projects;
	}

	public static Project convertMapToProject(Map<String, Object> projectDetail) {
		Project project = new Project();
		project.setProjectId((Integer) projectDetail.get("project_id"));
		project.setProjectName((String) projectDetail.get("project_name"));
		project.setProjectDescription((String) projectDetail.get("project_description"));
		project.setProjectType(new ProjectType((Integer) projectDetail.get("project_type_id")));
		project.setProjectParentId((Integer) projectDetail.get("project_parent_id"));
		//project.setCompanyInfo(new CompanyInfo((Integer) projectDetail.get("company_id")));
		project.setProjectImagePath((String) projectDetail.get("project_image_path"));
		project.setProjectStartDate((Date) projectDetail.get("project_start_date"));
		project.setProjectEndDate((Date) projectDetail.get("project_end_date"));
		project.setProjectStatus((Integer) projectDetail.get("project_status"));
		project.setType((String) projectDetail.get("type"));
		project.setAddress(new Address((Integer) projectDetail.get("address_id")));
		project.setProjectAssetFolderName((String) projectDetail.get("project_asset_folder_name"));
		return project;
	}

	public static ProjectDTO convertToProjectDTO(Project projectDetail, ProjectTaskRepository projectTaskRepository) {
		ProjectDTO project = new ProjectDTO();
		project.setProjectId(projectDetail.getProjectId());
		project.setProjectName(projectDetail.getProjectName());
		project.setProjectDescription(projectDetail.getProjectDescription());
		project.setProjectTypeId(projectDetail.getProjectType().getProjectTypeId());
		project.setProjectParentId(projectDetail.getProjectParentId());
		//project.setCompanyId(projectDetail.getCompanyInfo().getCompanyId());
		project.setProjectImagePath(projectDetail.getProjectImagePath());
		project.setStartDate(projectDetail.getProjectStartDate());
		project.setEndDate(projectDetail.getProjectEndDate());
		project.setStatus(String.valueOf(projectDetail.getProjectStatus()));
		project.setType(projectDetail.getType());
		project.setProjectOwnerId(projectDetail.getProjectOwnerId());
		project.setProjectAssetFolderName(projectDetail.getProjectAssetFolderName());
        project.setProjectTopicArn(projectDetail.getProjectTopicArn());

		List<ProjectConfigDTO> projectConfigList = new ArrayList<>();
		List<ProjectConfiguration> projectConfigurations = projectDetail.getProjectConfigurationList();
		if (projectConfigurations != null && !projectConfigurations.isEmpty()) {
			for (ProjectConfiguration projectConfiguration : projectConfigurations) {
				ProjectConfigDTO projectConfigDTO = new ProjectConfigDTO();
				projectConfigDTO.setConfigKey(projectConfiguration.getConfigKey());
				projectConfigDTO.setConfigValue(projectConfiguration.getConfigValue());
				projectConfigList.add(projectConfigDTO);
			}
		}
		project.setProjectConfiguration(projectConfigList);

		if (projectDetail.getType().equalsIgnoreCase(OnTargetConstant.ProjectInfoType.ACTIVITY)) {
			BigDecimal percentageCompleteSum = projectTaskRepository.getActivityTotalPercentageComplete(project.getProjectId());
			BigInteger taskCount = projectTaskRepository.getActivityTaskCount(project.getProjectId());

			if (percentageCompleteSum == null || taskCount == null) {
				project.setPercentageComplete(0);
			} else {
				int percentageComplete = CalculatePercentageComplete.calculate(percentageCompleteSum.doubleValue(), taskCount.intValue());
				project.setPercentageComplete(percentageComplete);
			}
		} else if (projectDetail.getType().equalsIgnoreCase(OnTargetConstant.ProjectInfoType.PROJECT)) {
			BigDecimal percentageCompleteSum = projectTaskRepository.getProjectTotalPercentageComplete(project.getProjectId());
			BigInteger taskCount = projectTaskRepository.getProjectTaskCount(project.getProjectId());
			if (percentageCompleteSum == null || taskCount == null) {
				project.setPercentageComplete(0);
			} else {
				int percentageComplete = CalculatePercentageComplete.calculate(percentageCompleteSum.doubleValue(), taskCount.intValue());
				project.setPercentageComplete(percentageComplete);
			}
		}

		if (projectDetail.getAddress() != null) {
			AddressDTO address = new AddressDTO();
			address.setAddressId(projectDetail.getAddress().getAddressId());
			project.setProjectAddress(address);
		}
		return project;
	}

	public static ProjectDTO convertToProjectDTO(Map<String, Object> projectDetail) {
		ProjectDTO project = new ProjectDTO();
		project.setProjectId((Integer) projectDetail.get("project_id"));
		project.setProjectName((String) projectDetail.get("project_name"));
		project.setProjectDescription((String) projectDetail.get("project_description"));
		project.setProjectTypeId((Integer) projectDetail.get("project_type_id"));
		project.setProjectParentId((Integer) projectDetail.get("project_parent_id"));
		//project.setCompanyId((Integer) projectDetail.get("company_id"));
		project.setProjectImagePath((String) projectDetail.get("project_image_path"));
		project.setStartDate((Date) projectDetail.get("project_start_date"));
		project.setEndDate((Date) projectDetail.get("project_end_date"));
		project.setStatus((String) projectDetail.get("project_status"));
		project.setType((String) projectDetail.get("type"));
		AddressDTO address = new AddressDTO();
		address.setAddressId((Integer) projectDetail.get("address_id"));
		project.setProjectAddress(address);
		return project;
	}

}
