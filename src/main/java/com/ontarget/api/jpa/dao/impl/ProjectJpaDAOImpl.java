package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.repository.ProjectMemberRepository;
import com.ontarget.api.repository.ProjectRepository;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.bean.ProjectMember;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.Address;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.Phone;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.ProjectType;
import com.ontarget.entities.User;
import com.ontarget.util.ProjectUtil;

@Repository("projectJpaDAOImpl")
public class ProjectJpaDAOImpl implements ProjectDAO {
	@Resource
	private ProjectRepository projectRepository;
	@Resource
	private ProjectMemberRepository projectMemberRepository;
	@Resource
	private ProjectTaskRepository projectTaskRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addProject(ProjectDTO projectDTO, int userId) throws Exception {
		Project project = new Project();
		project.setProjectName(projectDTO.getProjectName());
		project.setProjectDescription(projectDTO.getProjectDescription());
		project.setProjectType(new ProjectType(projectDTO.getProjectTypeId()));
		project.setCompanyInfo(new CompanyInfo(projectDTO.getCompanyId()));
		project.setAddress(new Address(projectDTO.getProjectAddress().getAddressId()));
		project.setProjectStatus(projectDTO.getStatus());
		project.setProjectParentId(projectDTO.getProjectParentId());
		project.setProjectStartDate(projectDTO.getStartDate());
		project.setProjectEndDate(projectDTO.getEndDate());
		project.setCreatedBy(new User(userId));
		project.setCreatedDate(new Date());
		project.setProjectImagePath(projectDTO.getProjectImagePath());
		project.setProjectOwnerId(projectDTO.getProjectOwnerId());

		Project parentProject = null;
		if (project.getProjectParentId() != null && project.getProjectParentId() > 0) {
			parentProject = projectRepository.findByProjectId(project.getProjectParentId());
		}
		project.setType(ProjectUtil.getTypeForProject(parentProject));
		projectRepository.save(project);
		return project.getProjectId();
	}

	@Override
	public ProjectDTO getProject(int projectId) throws Exception {
		Project project = projectRepository.findByProjectId(projectId);

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(projectId);
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setProjectDescription(project.getProjectDescription());
		projectDTO.setProjectTypeId(project.getProjectType().getProjectTypeId());
		projectDTO.setProjectParentId(project.getProjectParentId());
		projectDTO.setCompanyId(project.getCompanyInfo().getCompanyId());
		projectDTO.setProjectOwnerId(project.getProjectOwnerId());
		projectDTO.setStartDate(project.getProjectStartDate());
		projectDTO.setEndDate(project.getProjectEndDate());

		return projectDTO;
	}

	@Override
	public Project findProjectById(int projectId) throws Exception {
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public ProjectInfo getProjectInfo(int projectId) throws Exception {
		Project project = projectRepository.findByProjectId(projectId);

		ProjectInfo projectDTO = new ProjectInfo();
		projectDTO.setProjectId(projectId);
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setProjectDescription(project.getProjectDescription());
		projectDTO.setProjectTypeId(project.getProjectType().getProjectTypeId());
		projectDTO.setProjectParentId(project.getProjectParentId());
		projectDTO.setCompanyId(project.getCompanyInfo().getCompanyId());
		projectDTO.setProjectOwnerId(project.getProjectOwnerId());
		projectDTO.setStartDate(project.getProjectStartDate());
		projectDTO.setEndDate(project.getProjectEndDate());
		projectDTO.setType(project.getType());

		return projectDTO;
	}

	@Override
	public ProjectDTO getProjectAndSubProjects(int projectId) throws Exception {
		ProjectDTO projectDTO = new ProjectDTO();

		Map<Integer, List<ProjectDTO>> projectToSubProject = new HashMap<>();

		List<ProjectTask> projectTaskList = projectTaskRepository.findAll();

		for (ProjectTask projectTask : projectTaskList) {
			Project project = projectTask.getProject();
			projectDTO.setProjectId(project.getProjectId());
			projectDTO.setProjectName(project.getProjectName());
			projectDTO.setProjectDescription(project.getProjectDescription());
			projectDTO.setProjectTypeId(project.getProjectType().getProjectTypeId());
			projectDTO.setProjectParentId(project.getProjectParentId());
			projectDTO.setCompanyId(project.getCompanyInfo().getCompanyId());

			if (project.getProjectParentId() == 0 && projectToSubProject.get(projectId) == null) {
				List<ProjectDTO> subProjects = new ArrayList<>();
				subProjects.add(projectDTO);
				projectToSubProject.put(projectId, subProjects);
			}
		}

		return projectDTO;
	}

	@Override
	public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception {
		return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_COMPANY, new Object[] { companyId, userId });
	}

	@Override
	public boolean updateProject(ProjectDTO projectDTO, int updatingUserId) throws Exception {
		Project project = projectRepository.findByProjectId(projectDTO.getProjectId());
		project.setProjectName(projectDTO.getProjectName());
		project.setProjectDescription(projectDTO.getProjectDescription());
		project.setProjectType(new ProjectType(projectDTO.getProjectTypeId()));
		project.setProjectStatus(projectDTO.getStatus());
		project.setProjectParentId(projectDTO.getProjectParentId());
		project.setProjectStartDate(projectDTO.getStartDate());
		project.setProjectEndDate(projectDTO.getEndDate());
		project.setModifiedBy(new User(updatingUserId));
		project.setModifiedDate(new Date());
		projectRepository.save(project);
		return true;
	}

	@Override
	public List<ProjectMember> getProjectMembers(int projectId) throws Exception {
		List<ProjectMember> projectMemberList = new LinkedList<ProjectMember>();

		String hql = "select pm from ProjectMember pm join pm.user u join u.contactList c "
				+ " join pm.project p join c.phoneList ph where p.projectId = :projectId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectId", projectId);

		@SuppressWarnings("unchecked")
		List<com.ontarget.entities.ProjectMember> members = query.getResultList();

		if (members != null && !members.isEmpty()) {
			for (com.ontarget.entities.ProjectMember member : members) {
				ProjectMember projectMember = new ProjectMember();
				projectMember.setMemberStatus(member.getMemberStatus());
				projectMember.setProjectId(projectId);
				projectMember.setProjectMemberId(member.getProjectMemberId());
				projectMember.setUserId(member.getUser().getUserId());

				Contact contact = new Contact();
				ContactPhone contactPhone = new ContactPhone();

				if (member.getUser().getContactList() != null && !member.getUser().getContactList().isEmpty()) {
					com.ontarget.entities.Contact contactInfo = member.getUser().getContactList().get(0);

					contact.setFirstName(contactInfo.getFirstName());
					contact.setLastName(contactInfo.getLastName());

					UserDTO user = new UserDTO();
					user.setUserId(member.getUser().getUserId());
					contact.setUser(user);

					if (contactInfo.getPhoneList() != null && !contactInfo.getPhoneList().isEmpty()) {
						Phone phone = contactInfo.getPhoneList().get(0);
						contactPhone.setAreaCode(phone.getAreaCode());
						contactPhone.setPhoneNumber(phone.getPhoneNumber());
						contactPhone.setPhoneType(phone.getPhoneType());
					}
				}

				projectMember.setContact(contact);
				projectMember.setPhone(contactPhone);

				projectMemberList.add(projectMember);
			}
		}

		return projectMemberList;
	}

	@Override
	public int addProjectMember(int projectId, int userId) {
		com.ontarget.entities.ProjectMember projectMember = new com.ontarget.entities.ProjectMember();
		projectMember.setProject(new Project(projectId));
		projectMember.setMemberStatus(OnTargetConstant.MemberStatus.ACTIVE);
		projectMember.setUser(new User(userId));
		projectMemberRepository.save(projectMember);
		if (projectMember.getProjectMemberId() != null) {
			return projectMember.getProjectMemberId();
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> getProjectByUser(int userId) {
		return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_USER, new Object[] { userId });
	}

	@Override
	public Project getMainProjectByUser(int userId) {
		return projectRepository.getUserMainProject(userId);
	}

	@Override
	public List<Project> getUndeletedProjectsByParentId(Integer parentProjectId) {
		return projectRepository.findUndeletedProjectsByProjectParentId(parentProjectId);
	}

	@Override
	public List<ProjectInfo> getChildProjects(int projectId) throws Exception {
		List<ProjectInfo> projects = new LinkedList<>();
		List<Project> projectList = projectRepository.findByProjectParentId(projectId);

		for (Project proj : projectList) {
			ProjectInfo project = new ProjectInfo();

			project.setProjectId(proj.getProjectId());
			project.setProjectName(proj.getProjectName());
			project.setProjectDescription(proj.getProjectDescription());
			project.setProjectParentId(proj.getProjectParentId());
			project.setCompanyId(proj.getCompanyInfo().getCompanyId());
			project.setProjectOwnerId(proj.getProjectOwnerId());

			project.setStartDate(proj.getProjectStartDate());
			project.setEndDate(proj.getProjectEndDate());
			project.setType(proj.getType());
			projects.add(project);
		}

		return projects;
	}

	@Override
	public List<Company> getCompanyByProject(int projectId) throws Exception {
		String hql = "select ci from Project p join p.companyInfo ci where p.projectId = :projectId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectId", projectId);

		@SuppressWarnings("unchecked")
		List<CompanyInfo> companyInfoList = query.getResultList();

		List<Company> companies = new ArrayList<>();
		if (companyInfoList != null && !companyInfoList.isEmpty()) {
			for (CompanyInfo companyInfo : companyInfoList) {
				Company company = new Company();
				company.setCompanyId(companyInfo.getCompanyId());
				company.setCompanyName(companyInfo.getCompanyName());
				company.setWebsite(companyInfo.getWebsite());
				company.setCompanyTypeId(companyInfo.getCompanyType().getCompanyTypeId());

				AddressDTO address = new AddressDTO();
				address.setAddress1(companyInfo.getAddress1());
				address.setAddress2(companyInfo.getAddress2());
				address.setCity(companyInfo.getCity());
				address.setCountry(companyInfo.getCountry());
				address.setState(companyInfo.getState());
				address.setZip(companyInfo.getZipcode());

				company.setAddress(address);
				companies.add(company);
			}
		}

		return companies;
	}

	@Override
	public boolean deleteProject(int projectId, int userId) throws Exception {
		Project project = projectRepository.findByProjectId(projectId);
		project.setProjectStatus(OnTargetConstant.PROJECT_STATUS.DELETED);
		project.setModifiedBy(new User(userId));
		project.setModifiedDate(new Date());
		projectRepository.save(project);
		return true;
	}

}
