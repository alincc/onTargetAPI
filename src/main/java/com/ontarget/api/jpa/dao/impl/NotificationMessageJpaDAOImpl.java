package com.ontarget.api.jpa.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.NotificationMessageDAO;
import com.ontarget.api.repository.DocumentRepository;
import com.ontarget.api.repository.ProjectFileRepository;
import com.ontarget.api.repository.ProjectRepository;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.entities.Document;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.User;

@Repository("notificationMessageJpaDAOImpl")
public class NotificationMessageJpaDAOImpl implements NotificationMessageDAO {

	private Logger logger = Logger.getLogger(NotificationMessageJpaDAOImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectFileRepository projectFileRepository;
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public User getUserById(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public com.ontarget.entities.ProjectTask getProjectTaskById(int projectTaskId) {
		return projectTaskRepository.findByProjectTaskId(projectTaskId);
	}

	@Override
	public Project findProjectById(int projectId) {
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public ProjectFile findProjectFileById(int projectFileId) {
		return projectFileRepository.findById(projectFileId);
	}

	@Override
	public Document findDocumentById(int documentId) {
		return documentRepository.findByDocumentId(documentId);
	}

}
