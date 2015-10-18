package com.ontarget.api.dao;

import com.ontarget.entities.Document;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.User;

public interface NotificationMessageDAO {
	User getUserById(Integer userId);

	com.ontarget.entities.ProjectTask getProjectTaskById(int projectTaskId);

	Project findProjectById(int projectId);
	
	ProjectFile findProjectFileById(int projectFileId);
	
	Document findDocumentById(int documentId);

}
