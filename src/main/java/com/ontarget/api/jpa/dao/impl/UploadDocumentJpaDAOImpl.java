package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.api.repository.ProjectFileRepository;
import com.ontarget.bean.UploadDocument;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.User;

@Repository("uploadDocumentJpaDAOImpl")
public class UploadDocumentJpaDAOImpl implements UploadDocumentDAO {

	@Resource
	private ProjectFileRepository projectFileRepository;

	@Override
	public UploadDocument saveUploadedDocsInfo(UploadDocument documentBean) throws Exception {

		ProjectFile projectFile = new ProjectFile();
		projectFile.setFileName(documentBean.getName());
		projectFile.setFileType(documentBean.getFileType());
		projectFile.setProject(new Project(documentBean.getProjectId()));
		projectFile.setCreatedBy(new User(documentBean.getCreatedBy()));
		projectFile.setCreatedDate(new Date());
		projectFileRepository.save(projectFile);

		documentBean.setProjectFileId(projectFile.getProjectFileId());
		return documentBean;
	}

	@Override
	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId) {
		List<UploadedDocumentDetail> resultList = new ArrayList<UploadedDocumentDetail>();

		List<ProjectFile> files = projectFileRepository.getProjectFilesByProjectId(projectId);

		if (files != null && !files.isEmpty()) {
			for (ProjectFile file : files) {
				UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
				documentDetail.setFileId(file.getProjectFileId());
				documentDetail.setName(file.getFileName());
				documentDetail.setFileType(file.getFileType());
				documentDetail.setCreatedBy(file.getCreatedBy().getUserId());
				documentDetail.setCreatedDate(file.getCreatedDate());
				resultList.add(documentDetail);
			}
		}

		return resultList;

	}

}
