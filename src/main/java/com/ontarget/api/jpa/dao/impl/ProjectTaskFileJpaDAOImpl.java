package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectTaskFileDAO;
import com.ontarget.api.repository.ProjectTaskFilesRepository;
import com.ontarget.bean.FileAttachment;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.ProjectTaskFiles;
import com.ontarget.entities.User;

@Repository("projectTaskFileJpaDAOImpl")
public class ProjectTaskFileJpaDAOImpl implements ProjectTaskFileDAO {
	@Resource
	private ProjectTaskFilesRepository projectTaskFilesRepository;

	@Override
	public long saveTaskFile(int taskId, String fileName, int owner, String location) throws Exception {

		ProjectTaskFiles projectTaskFiles = new ProjectTaskFiles();
		projectTaskFiles.setFileName(fileName);
		projectTaskFiles.setCreatedBy(owner);
		projectTaskFiles.setLocation(location);
		projectTaskFiles.setProjectTask(new ProjectTask(taskId));
		projectTaskFiles.setStatus(OnTargetConstant.ProjectTaskFileStatus.ACTIVE);
		projectTaskFilesRepository.save(projectTaskFiles);

		return projectTaskFiles.getTaskFileId();
	}

	@Override
	public List<FileAttachment> getTaskAttachments(int taskId) throws Exception {
		List<ProjectTaskFiles> projectTaskFiles = projectTaskFilesRepository.getProjectTaskFilesByTaskId(taskId);

		List<FileAttachment> attachments = new ArrayList<>();
		if (projectTaskFiles != null && projectTaskFiles.size() > 0) {
			for (ProjectTaskFiles projectTaskFile : projectTaskFiles) {
				FileAttachment attachment = new FileAttachment();
				attachment.setTaskFileId(projectTaskFile.getTaskFileId());
				attachment.setFileName(projectTaskFile.getFileName());
				attachment.setLocation(projectTaskFile.getLocation());
				attachment.setTaskId(projectTaskFile.getProjectTask().getProjectTaskId());
				attachment.setUserId(projectTaskFile.getCreatedBy());
				attachments.add(attachment);
			}
		}

		return attachments;
	}

	@Override
	public boolean deleteTaskAttachment(Integer taskFileId, int userId) throws Exception {
		ProjectTaskFiles projectTaskFiles = projectTaskFilesRepository.findByTaskFileId(taskFileId);
		projectTaskFiles.setStatus(OnTargetConstant.ProjectFileStatus.DELETED);
		projectTaskFiles.setModifiedBy(new User(userId));
		projectTaskFiles.setModifiedDate(new Date());
		projectTaskFilesRepository.save(projectTaskFiles);
		return true;

	}
}
