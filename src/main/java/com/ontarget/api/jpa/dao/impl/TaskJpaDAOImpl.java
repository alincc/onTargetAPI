package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.repository.ContactRepository;
import com.ontarget.api.repository.DependentTaskRepository;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.repository.TaskAssigneeRepository;
import com.ontarget.api.repository.TaskCommentRepository;
import com.ontarget.api.repository.TaskFieldWorkerRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskObj;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.bean.TaskStatusCount;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.ProjectTask;
import com.ontarget.entities.DependentTask;
import com.ontarget.entities.Email;
import com.ontarget.entities.FieldWorker;
import com.ontarget.entities.Phone;
import com.ontarget.entities.Project;
import com.ontarget.entities.TaskAssignee;
import com.ontarget.entities.TaskFieldWorker;
import com.ontarget.entities.TaskPercentageLog;
import com.ontarget.entities.User;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

@Repository("taskJpaDAOImpl")
public class TaskJpaDAOImpl implements TaskDAO {

	@Resource
	private ProjectTaskRepository projectTaskRepository;
	@Resource
	private TaskCommentRepository taskCommentRepository;
	@Resource
	private TaskAssigneeRepository taskAssigneeRepository;
	@Resource
	private DependentTaskRepository dependentTaskRepository;
	@Resource
	private TaskFieldWorkerRepository taskFieldWorkerRepository;
	@Resource
	private UserRepository userRepository;
	@Resource
	private ContactRepository contactRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addTask(Task task, int userId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = new com.ontarget.entities.ProjectTask();
		projectTask.setProject(new Project(task.getProjectId()));
		projectTask.setTitle(task.getTitle());
		projectTask.setDescription(task.getDescription());
		projectTask.setStatus(task.getStatus());
		projectTask.setSeverity(task.getSeverity());
		projectTask.setStartDate(task.getStartDate());
		projectTask.setEndDate(task.getEndDate());
		projectTask.setCreatedBy(new User(userId));
		projectTask.setCreatedDate(new Date());
		projectTask.setTaskPercentage(0);
		projectTaskRepository.save(projectTask);

		List<Integer> assignees = task.getAssignees();

		for (Integer assigneeId : assignees) {
			TaskAssignee taskAssignee = new TaskAssignee();
			taskAssignee.setProjectTask(projectTask);
			taskAssignee.setTaskAssignee(assigneeId);
			taskAssignee.setCreatedBy(new User(userId));
			taskAssignee.setStatus(OnTargetConstant.TaskAssigneeStatus.ASSIGNED);
			taskAssignee.setCreatedDate(new Date());
			taskAssigneeRepository.save(taskAssignee);
		}
		return projectTask.getProjectTaskId();
	}

	@Override
	public com.ontarget.entities.ProjectTask getProjectTaskById(int projectTaskId) {
		return projectTaskRepository.findByProjectTaskId(projectTaskId);
	}

	@Override
	public List<com.ontarget.entities.ProjectTask> getProjectTaskByProjectId(int projectId) {
		return projectTaskRepository.findUndeletedTasksByProject(projectId);
	}

	@Override
	public List<TaskInfo> getTask(int projectId) throws Exception {
		String hql = "SELECT p FROM ProjectTask p WHERE p.project.id = :projectId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectId", projectId);
		@SuppressWarnings("unchecked")
		List<com.ontarget.entities.ProjectTask> taskList = query.getResultList();

		List<TaskInfo> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (com.ontarget.entities.ProjectTask taskObj : taskList) {
				TaskInfo task = new TaskInfo();
				task.setTitle(taskObj.getTitle());
				task.setDescription(taskObj.getDescription());
				task.setStatus(taskObj.getStatus());
				task.setSeverity(taskObj.getSeverity());
				task.setProjectTaskId(taskObj.getProjectTaskId());
				task.setStartDate(taskObj.getStartDate());
				task.setEndDate(taskObj.getEndDate());
				task.setStatus(taskObj.getStatus());
				task.setPercentageComplete(taskObj.getTaskPercentage().doubleValue());

				if (taskObj.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public List<TaskInfo> getAssignedTasksByProjectId(int projectId, int userId) throws Exception {
		String hql = "SELECT pt FROM ProjectTask pt JOIN pt.taskAssigneeList ta WHERE pt.project.id = :projectId and ta.taskAssignee = :assigneeId and pt.status != :status";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectId", projectId);
		query.setParameter("assigneeId", userId);
		query.setParameter("status", OnTargetConstant.TaskStatus.DELETED);
		@SuppressWarnings("unchecked")
		List<com.ontarget.entities.ProjectTask> taskList = query.getResultList();

		List<TaskInfo> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (com.ontarget.entities.ProjectTask taskObj : taskList) {
				TaskInfo task = new TaskInfo();
				task.setTitle(taskObj.getTitle());
				task.setDescription(taskObj.getDescription());
				task.setStatus(taskObj.getStatus());
				task.setSeverity(taskObj.getSeverity());
				task.setProjectTaskId(taskObj.getProjectTaskId());
				task.setStartDate(taskObj.getStartDate());
				task.setEndDate(taskObj.getEndDate());
				task.setStatus(taskObj.getStatus());
				task.setPercentageComplete(taskObj.getTaskPercentage().doubleValue());

				if (taskObj.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public List<TaskObj> getTaskObjList(int projectId) throws Exception {
		String hql = "SELECT p FROM ProjectTask p WHERE p.project.id = :projectId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectId", projectId);
		@SuppressWarnings("unchecked")
		List<com.ontarget.entities.ProjectTask> taskList = query.getResultList();

		List<TaskObj> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (com.ontarget.entities.ProjectTask taskObj : taskList) {
				TaskObj task = new TaskObj();
				task.setTitle(taskObj.getTitle());
				task.setDescription(taskObj.getDescription());
				task.setStatus(taskObj.getStatus());
				task.setSeverity(taskObj.getSeverity());
				task.setProjectTaskId(taskObj.getProjectTaskId());
				task.setStartDate(taskObj.getStartDate());
				task.setEndDate(taskObj.getEndDate());
				task.setStatus(taskObj.getStatus());
				task.setPercentageComplete(taskObj.getTaskPercentage());

				if (taskObj.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}
		return tasks;
	}
	
	

	@Override
	public List<ProjectTask> getTasksByActivityAndUser(int projectId, int userId) throws Exception {
		List<com.ontarget.entities.ProjectTask> taskList = projectTaskRepository.findUndeletedTasksByActivityAndUser(projectId, userId);

		List<ProjectTask> tasks = new ArrayList<>();
		Map<Integer, Contact> contactMap = new HashMap<>();
		if (taskList != null && !taskList.isEmpty()) {
			for (com.ontarget.entities.ProjectTask taskObj : taskList) {
				ProjectTask task = new ProjectTask();
				task.setTitle(taskObj.getTitle());
				task.setDescription(taskObj.getDescription());
				task.setStatus(taskObj.getStatus());
				task.setSeverity(taskObj.getSeverity());
				task.setProjectTaskId(taskObj.getProjectTaskId());
				task.setStartDate(taskObj.getStartDate());
				task.setEndDate(taskObj.getEndDate());
				task.setStatus(taskObj.getStatus());

				if (taskObj.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);

				List<TaskComment> comments = getTaskComments(task.getProjectTaskId());
				for (TaskComment comment : comments) {
					int commentedBy = comment.getCommentedBy();
					if (contactMap.containsKey(commentedBy)) {
						comment.setCommenterContact(contactMap.get(commentedBy));
					} else {
						Contact contact = getContact(commentedBy);
						contactMap.put(commentedBy, contact);
						comment.setCommenterContact(contact);
					}
				}
				task.setComments(comments);
				task.setPercentageComplete(taskObj.getTaskPercentage().doubleValue());

				Set<Integer> assignees = getTaskMembers(task.getProjectTaskId());
				List<UserDTO> assignedUsers = new ArrayList<>();
				task.setAssignee(assignedUsers);
				if (assignees != null && assignees.size() > 0) {
					for (Integer id : assignees) {
						Contact contact = getContact(id);
						UserDTO assignedToUser = new UserDTO();
						assignedToUser.setContact(contact);
						assignedToUser.setUserId((id.intValue()));
						assignedUsers.add(assignedToUser);
					}
				}
			}
		}

		return tasks;
	}

	@Override
	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception {
		List<TaskPercentage> taskPercentageList = new ArrayList<>();

		String hql = "select tpl from TaskPercentageLog tpl where tpl.projectTask.projectTaskId = :projectTaskId"
				+ " order by tpl.createdDate desc";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectTaskId", projectTaskId);
		@SuppressWarnings("unchecked")
		List<TaskPercentageLog> logs = query.getResultList();

		if (logs != null && !logs.isEmpty()) {
			for (TaskPercentageLog taskPercentageLog : logs) {

				TaskPercentage percentage = new TaskPercentage();
				percentage.setId(taskPercentageLog.getTaskPercentageLogId());
				percentage.setTaskPercentageComplete(taskPercentageLog.getPercentageComplete());
				percentage.setCreatedBy(String.valueOf(taskPercentageLog.getCreatedBy().getUserId()));

				int year = 0;
				int month = 0;
				if (percentage.getFromDate() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(percentage.getFromDate());
					year = cal.get(Calendar.YEAR);
					month = cal.get(Calendar.MONTH) + 1;
				}
				percentage.setMonth(month);
				percentage.setYear(year);

				taskPercentageList.add(percentage);
				return taskPercentageList;
			}
		}

		return taskPercentageList;
	}

	@Override
	public Contact getContact(int userId) throws Exception {
		User userObj = userRepository.findByUserId(userId);

		List<com.ontarget.entities.Contact> contactList = contactRepository.findByUserId(userId);

		if (contactList == null || contactList.isEmpty()) {
			throw new Exception("User " + userId + " does not exist");
		}

		com.ontarget.entities.Contact contactObj = contactList.get(0);
		Contact contact = new Contact();
		contact.setContactId(contactObj.getContactId());
		UserDTO user = new UserDTO();
		user.setUserId((int) userId);
		contact.setUser(user);
		contact.setFirstName(contactObj.getFirstName());
		contact.setLastName(contactObj.getLastName());
		contact.setTitle(contactObj.getTitle());
		contact.setUserImagePath(contactObj.getContactImage());

		List<Phone> phoneList = contactObj.getPhoneList();
		if (phoneList != null && !phoneList.isEmpty()) {
			Phone phone = phoneList.get(0);
			contact.setAreaCode(phone.getAreaCode());
			contact.setPhoneNumber(phone.getPhoneNumber());
		}

		List<Email> emailList = userObj.getEmailList();
		if (emailList != null && !emailList.isEmpty()) {
			Email email = emailList.get(0);
			contact.setEmail(email.getEmailAddress());
		}
		return contact;
	}

	@Override
	public List<TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK_COUNT_BY_STATUS,
				new Object[] { projectId,projectId });
		List<TaskStatusCount> taskCountByStatus = new ArrayList<>();

		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				TaskStatusCount count = new TaskStatusCount();
				count.setStatusType((String) taskMap.get("status_name"));
				count.setTaskCount((Long) taskMap.get("count"));
				taskCountByStatus.add(count);
			}
		}
		return taskCountByStatus;
	}

	@Override
	public boolean updateComment(TaskCommentRequest comment) throws Exception {
		com.ontarget.entities.TaskComment taskComment = taskCommentRepository.findByTaskCommentId(comment.getTaskCommentId());
		taskComment.setComment(comment.getComment());
		taskComment.setCommentedBy(new User(comment.getCommentedBy()));
		taskCommentRepository.save(taskComment);
		return true;
	}

	@Override
	public int addComment(TaskCommentRequest comment) throws Exception {
		com.ontarget.entities.TaskComment taskComment = new com.ontarget.entities.TaskComment();
		taskComment.setProjectTask(new com.ontarget.entities.ProjectTask(comment.getTaskId()));
		taskComment.setComment(comment.getComment());
		taskComment.setCommentedBy(new User(comment.getCommentedBy()));
		taskComment.setCommentedDate(new Date());
		taskComment.setCommentStatus("ACTIVE");
		entityManager.persist(taskComment);
		return taskComment.getTaskCommentId();
	}

	@Override
	public List<TaskComment> getTaskComments(int projectTaskId) throws Exception {
		String hql = "select t from TaskComment t where t.commentStatus='ACTIVE' and t.projectTask.projectTaskId = :projectTaskId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectTaskId", projectTaskId);
		@SuppressWarnings("unchecked")
		List<com.ontarget.entities.TaskComment> taskCommentList = query.getResultList();

		List<TaskComment> comments = new ArrayList<>();
		if (taskCommentList != null && taskCommentList.size() > 0) {
			for (com.ontarget.entities.TaskComment taskComment : taskCommentList) {
				TaskComment comment = new TaskComment();
				comment.setTaskCommentId(taskComment.getTaskCommentId());
				comment.setTaskId(projectTaskId);
				comment.setComment(taskComment.getComment());
				comment.setCommentedBy(taskComment.getCommentedBy().getUserId());
				comment.setCommentedDate(taskComment.getCommentedDate());
				comments.add(comment);
			}
		}
		return comments;
	}

	@Override
	public boolean updateTask(Task task, int userId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(task.getProjectTaskId());
		projectTask.setTitle(task.getTitle());
		projectTask.setDescription(task.getDescription());
		projectTask.setStatus(task.getStatus());
		projectTask.setStartDate(task.getStartDate());
		projectTask.setEndDate(task.getEndDate());
		projectTask.setSeverity(task.getSeverity());
		projectTask.setModifiedBy(new User(userId));
		projectTask.setModifiedDate(new Date());
		projectTaskRepository.save(projectTask);
		return true;
	}

	@Override
	public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(taskId);
		projectTask.setStatus(taskStatus);
		projectTask.setModifiedBy(new User(userId));
		projectTask.setModifiedDate(new Date());
		projectTaskRepository.save(projectTask);
		return true;
	}

	@Override
	public Set<Integer> getTaskMembers(int taskId) throws Exception {
		String hql = "select t from TaskAssignee t where t.projectTask.projectTaskId = :projectTaskId and t.status !="
				+ OnTargetConstant.TaskAssigneeStatus.DELETED;
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectTaskId", taskId);
		@SuppressWarnings("unchecked")
		List<TaskAssignee> assignees = query.getResultList();

		Set<Integer> users = new HashSet<>();
		if (assignees != null && !assignees.isEmpty()) {
			for (TaskAssignee assignee : assignees) {
				users.add(assignee.getTaskAssignee());
			}
		}
		return new HashSet<Integer>(users);
	}

	@Override
	public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteAllTaskAssignedUsers(int taskId) throws Exception {
		String hql = "delete from TaskAssignee t where t.projectTask.projectTaskId = :projectTaskId";

		Query query = entityManager.createQuery(hql);
		query.setParameter("projectTaskId", taskId);
		query.executeUpdate();
		return true;
	}

	@Override
	public List<Integer> assignTaskToUser(int taskId, int userId, List<Integer> assignees) throws Exception {

		List<TaskAssignee> taskAssigneeList = taskAssigneeRepository.getAllTaskAssigneeByTaskId(taskId);

		List<Integer> alreadyAssigned = new ArrayList<Integer>();

		List<Integer> newAssigneeList = new ArrayList<Integer>();

		if (taskAssigneeList != null && !taskAssigneeList.isEmpty()) {
			for (TaskAssignee assignee : taskAssigneeList) {
				if (!assignees.contains(assignee.getTaskAssignee())) {
					assignee.setStatus(OnTargetConstant.TaskAssigneeStatus.DELETED);
				} else {
					if (assignee.getStatus().equals(OnTargetConstant.TaskAssigneeStatus.DELETED)) {
						newAssigneeList.add(assignee.getTaskAssignee());
					}
					assignee.setStatus(OnTargetConstant.TaskAssigneeStatus.ASSIGNED);
				}
				assignee.setModifiedBy(new User(userId));
				assignee.setModifiedDate(new Date());
				taskAssigneeRepository.save(assignee);
				alreadyAssigned.add(assignee.getTaskAssignee());
			}
		}
		for (Integer assigneeId : assignees) {
			if (!alreadyAssigned.contains(assigneeId)) {
				TaskAssignee taskAssignee = new TaskAssignee();
				taskAssignee.setProjectTask(new com.ontarget.entities.ProjectTask(taskId));
				taskAssignee.setTaskAssignee(assigneeId);
				taskAssignee.setCreatedBy(new User(userId));
				taskAssignee.setStatus(OnTargetConstant.TaskAssigneeStatus.ASSIGNED);
				taskAssignee.setCreatedDate(new Date());
				taskAssigneeRepository.save(taskAssignee);
				newAssigneeList.add(taskAssignee.getTaskAssignee());
			}
		}
		return newAssigneeList;
	}

	@Override
	public boolean updateTaskAssignee(int taskId, int userId, int assigningUser) throws Exception {
		TaskAssignee taskAssignee = taskAssigneeRepository.findByTaskAssigneeId(taskId);
		taskAssignee.setTaskAssignee(userId);
		taskAssignee.setModifiedBy(new User(assigningUser));
		taskAssignee.setModifiedDate(new Date());
		taskAssigneeRepository.save(taskAssignee);
		return true;
	}

	@Override
	public boolean assignTaskToFieldworker(int taskId, int userId, List<Integer> fieldWorkerIds) throws Exception {

		List<TaskFieldWorker> taskFieldworkers = taskFieldWorkerRepository.getAllFieldworkersByTaskId(taskId);
		List<Integer> alreadyAssigned = new ArrayList<Integer>();
		if (taskFieldworkers != null && !taskFieldworkers.isEmpty()) {
			for (TaskFieldWorker taskFieldWorker : taskFieldworkers) {

				if (!fieldWorkerIds.contains(taskFieldWorker.getFieldWorker().getId())) {
					taskFieldWorker.setStatus(OnTargetConstant.TaskFieldWorkerStatus.DELETED);
				} else {
					taskFieldWorker.setStatus(OnTargetConstant.TaskFieldWorkerStatus.ASSIGNED);
				}

				taskFieldWorker.setModifiedBy(new User(userId));
				taskFieldWorker.setModifiedDate(new Date());
				taskFieldWorkerRepository.save(taskFieldWorker);
				alreadyAssigned.add(taskFieldWorker.getFieldWorker().getId());
			}

		}
		for (Integer fieldworkerId : fieldWorkerIds) {
			if (!alreadyAssigned.contains(fieldworkerId)) {
				TaskFieldWorker taskFieldworker = new TaskFieldWorker();
				taskFieldworker.setProjectTask(new com.ontarget.entities.ProjectTask(taskId));
				taskFieldworker.setFieldWorker(new FieldWorker(fieldworkerId));
				taskFieldworker.setCreatedBy(new User(userId));
				taskFieldworker.setCreatedDate(new Date());
				taskFieldworker.setStatus(OnTargetConstant.TaskFieldWorkerStatus.ASSIGNED);
				taskFieldWorkerRepository.save(taskFieldworker);
			}
		}
		return true;
	}

	@Override
	public Integer getAssignedUser(int taskId) throws Exception {
		TaskAssignee taskAssignee = taskAssigneeRepository.findByTaskAssigneeId(taskId);
		return (int) taskAssignee.getTaskAssignee();
	}

	@Override
	public ProjectTask getTaskDetail(int taskId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(taskId);
		ProjectTask task = new ProjectTask();

		task.setProjectTaskId(projectTask.getProjectTaskId());
		task.setTitle(projectTask.getTitle());
		task.setStatus(projectTask.getStatus());
		task.setStartDate(projectTask.getStartDate());
		task.setEndDate(projectTask.getEndDate());
		task.setDescription(projectTask.getDescription());
		task.setSeverity(projectTask.getSeverity());

		return task;
	}

	@Override
	public ProjectTaskInfo getTaskInfo(int taskId) throws Exception {

		ProjectTaskInfo task = new ProjectTaskInfo();

		com.ontarget.entities.ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(taskId);

		task.setProjectTaskId(projectTask.getProjectTaskId());
		task.setTitle(projectTask.getTitle());
		task.setProjectId(projectTask.getProject().getProjectId());
		task.setStatus(projectTask.getStatus());
		task.setStartDate(projectTask.getStartDate());
		task.setEndDate(projectTask.getEndDate());
		task.setDescription(projectTask.getDescription());
		task.setSeverity(projectTask.getSeverity());
		task.setCreatorId(projectTask.getCreatedBy().getUserId());
		return task;
	}

	@Override
	public List<ProjectTask> getChildTasks(int taskId) throws Exception {

		List<com.ontarget.entities.ProjectTask> taskList = projectTaskRepository.getAllTaskByParentTaskId(taskId);

		List<ProjectTask> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (com.ontarget.entities.ProjectTask projTask : taskList) {
				ProjectTask task = new ProjectTask();
				task.setTitle(projTask.getTitle());
				task.setDescription(projTask.getDescription());
				task.setStatus(projTask.getStatus());
				task.setSeverity(projTask.getSeverity());
				task.setProjectTaskId(projTask.getProjectTaskId());
				task.setStartDate(projTask.getStartDate());
				task.setEndDate(projTask.getEndDate());
				task.setStatus(projTask.getStatus());

				if (projTask.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public List<ProjectTask> getDependentTasks(int taskId) throws Exception {
		List<ProjectTask> tasks = new LinkedList<>();

		List<com.ontarget.entities.ProjectTask> dependentTasks = projectTaskRepository.getAllDependentTaskByTaskId(taskId);

		if (dependentTasks != null && !dependentTasks.isEmpty()) {
			for (com.ontarget.entities.ProjectTask projectTask : dependentTasks) {
				ProjectTask task = new ProjectTask();
				task.setProjectTaskId(projectTask.getProjectTaskId());
				task.setTitle(projectTask.getTitle());
				task.setStatus(projectTask.getStatus());
				task.setStartDate(projectTask.getStartDate());
				task.setEndDate(projectTask.getEndDate());
				task.setDescription(projectTask.getDescription());
				task.setSeverity(projectTask.getSeverity());
				tasks.add(task);
			}
		}
		return tasks;
	}

	@Override
	public List<ProjectTask> getUserTasks(int userId) throws Exception {
		List<com.ontarget.entities.ProjectTask> assigneeTasks = projectTaskRepository.getAllTaskByAssignee((long) userId);
		List<ProjectTask> tasks = new LinkedList<>();

		if (assigneeTasks != null && !assigneeTasks.isEmpty()) {
			for (com.ontarget.entities.ProjectTask projectTask : assigneeTasks) {
				ProjectTask task = new ProjectTask();
				task.setProjectTaskId(projectTask.getProjectTaskId());
				task.setTitle(projectTask.getTitle());
				task.setStatus(projectTask.getStatus());
				task.setStartDate(projectTask.getStartDate());
				task.setEndDate(projectTask.getEndDate());
				task.setDescription(projectTask.getDescription());
				task.setSeverity(projectTask.getSeverity());
				tasks.add(task);
			}
		}

		return tasks;

	}

	@Override
	public int addDependentTask(DependentTaskDTO dependentTaskDTO) throws Exception {
		DependentTask dependentTask = new DependentTask();
		dependentTask.setProjectTask(new com.ontarget.entities.ProjectTask(dependentTaskDTO.getTaskId()));
		dependentTask.setDependentTaskId(dependentTaskDTO.getDependentTaskId());
		dependentTask.setCategoryId(dependentTaskDTO.getCategory_id());
		dependentTask.setCreatedBy(dependentTaskDTO.getCreatedBy());
		dependentTaskRepository.save(dependentTask);
		return dependentTask.getDependentTaskId();
	}

	@Override
	public List<TaskInfo> getTask(int projectId, int completed) throws Exception {
		List<com.ontarget.entities.ProjectTask> assigneeTasks = projectTaskRepository.getTasksByProjectIdAndStatus(projectId, projectId,
				String.valueOf(completed));
		List<TaskInfo> tasks = new LinkedList<>();

		if (assigneeTasks != null && !assigneeTasks.isEmpty()) {
			for (com.ontarget.entities.ProjectTask projectTask : assigneeTasks) {
				TaskInfo task = new TaskInfo();
				task.setProjectTaskId(projectTask.getProjectTaskId());
				task.setTitle(projectTask.getTitle());
				task.setStatus(projectTask.getStatus());
				task.setStartDate(projectTask.getStartDate());
				task.setEndDate(projectTask.getEndDate());
				task.setDescription(projectTask.getDescription());
				task.setSeverity(projectTask.getSeverity());
				if (projectTask.getStatus().equalsIgnoreCase("0")) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public boolean deleteTask(int taskId, int userId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(taskId);
		projectTask.setStatus(OnTargetConstant.TaskStatus.DELETED);
		projectTask.setModifiedBy(new User(userId));
		projectTask.setModifiedDate(new Date());
		projectTaskRepository.save(projectTask);
		return true;
	}

	@Override
	public List<TaskFieldWorker> getTaskFieldWorkersByTask(int taskId) throws Exception {
		return taskFieldWorkerRepository.getAllFieldworkersByTaskId(taskId);
	}

}
