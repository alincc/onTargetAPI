package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.api.repository.ProjectFileCommentRepository;
import com.ontarget.api.repository.ProjectFileRepository;
import com.ontarget.bean.UploadDocument;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.ProjectFileCategory;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.entities.User;
import com.ontarget.request.bean.ProjectFileCommentRequest;

@Repository("uploadDocumentJpaDAOImpl")
public class UploadDocumentJpaDAOImpl implements UploadDocumentDAO {

	@Resource
	private ProjectFileRepository projectFileRepository;
	@Resource
	private ProjectFileCommentRepository projectFileCommentRepository;

	@Override
	public UploadedDocumentDetail saveUploadedDocsInfo(UploadDocument documentBean) throws Exception {
		ProjectFile projectFile = new ProjectFile();
		projectFile.setFileName(documentBean.getName());
		projectFile.setFileType(documentBean.getFileType());
		projectFile.setProject(new Project(documentBean.getProjectId()));
		projectFile.setDescription(documentBean.getDescription());
		projectFile.setProjectFileCategory(new ProjectFileCategory(documentBean.getCategoryId()));
		projectFile.setCreatedBy(new User(documentBean.getCreatedBy()));
		projectFile.setCreatedDate(new Date());
		projectFile.setStatus(OnTargetConstant.ProjectFileStatus.ACTIVE);
		projectFileRepository.save(projectFile);

        UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
        documentDetail.setFileId(projectFile.getProjectFileId());
        documentDetail.setName(projectFile.getFileName());
        documentDetail.setFileType(projectFile.getFileType());
        documentDetail.setCreatedBy(projectFile.getCreatedBy().getUserId());
        documentDetail.setCreatedDate(projectFile.getCreatedDate());
        documentDetail.setProjectFileCategoryId(projectFile.getProjectFileCategory());
        documentDetail.setDescription(projectFile.getDescription());

		return documentDetail;
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
                documentDetail.setProjectFileCategoryId(file.getProjectFileCategory());
                documentDetail.setDescription(file.getDescription());
				resultList.add(documentDetail);
			}
		}

		return resultList;

	}


    @Override
    public UploadedDocumentDetail updateProjectFile(UploadDocument documentBean) throws Exception {
        ProjectFile projectFile = projectFileRepository.findById(documentBean.getProjectFileId());
        projectFile.setDescription(documentBean.getDescription());
        projectFile.setFileName(documentBean.getName());
        projectFile.setProjectFileCategory(new ProjectFileCategory(documentBean.getCategoryId()));
        projectFile.setModifiedBy(new User(documentBean.getModifiedBy()));
        projectFile.setModifiedDate(new Date());
        projectFileRepository.save(projectFile);

        UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
        documentDetail.setFileId(projectFile.getProjectFileId());
        documentDetail.setName(projectFile.getFileName());
        documentDetail.setFileType(projectFile.getFileType());
        documentDetail.setCreatedBy(projectFile.getCreatedBy().getUserId());
        documentDetail.setCreatedDate(projectFile.getCreatedDate());
        documentDetail.setProjectFileCategoryId(projectFile.getProjectFileCategory());
        documentDetail.setDescription(projectFile.getDescription());

        return documentDetail;

    }

	@Override
	public boolean deleteProjectFile(Integer projectFileId, int userId) throws Exception {
		ProjectFile projectFile = projectFileRepository.findById(projectFileId);
		projectFile.setStatus(OnTargetConstant.ProjectFileStatus.DELETED);
		projectFile.setModifiedBy(new User(userId));
		projectFile.setModifiedDate(new Date());
		projectFileRepository.save(projectFile);
		return true;

	}

	@Override
	public List<ProjectFileComment> getCommentsByFileId(int projectFileId) {
		return projectFileCommentRepository.findCommentsByFileId(projectFileId);
	}

    @Override
    public UploadedDocumentDetail getFilesByProjectAndFileId(Integer projectId, Integer projectFileId) throws Exception {

        ProjectFile file = projectFileRepository.findByIdAndProjectId(projectId, projectFileId);
        UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
        documentDetail.setFileId(file.getProjectFileId());
        documentDetail.setName(file.getFileName());
        documentDetail.setFileType(file.getFileType());
        documentDetail.setCreatedBy(file.getCreatedBy().getUserId());
        documentDetail.setCreatedDate(file.getCreatedDate());
        documentDetail.setProjectFileCategoryId(file.getProjectFileCategory());
        documentDetail.setDescription(file.getDescription());

        return documentDetail;
    }

    @Override
	public boolean addComment(ProjectFileCommentRequest request) throws Exception {
		ProjectFileComment projectFileComment;
		if (request.getCommentId() != null) {
			projectFileComment = projectFileCommentRepository.findOne(request.getCommentId());
		} else {
			projectFileComment = new ProjectFileComment();
		}
		projectFileComment.setProjectFile(new ProjectFile(request.getProjectFileId()));
		projectFileComment.setComment(request.getComment());
		projectFileComment.setCommentedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		projectFileComment.setCommentedDate(new Date());
		projectFileComment.setCommentStatus(OnTargetConstant.ProjectFileCommentStatus.ACTIVE);
		projectFileCommentRepository.save(projectFileComment);
		return true;
	}

	@Override
	public boolean deleteComment(Integer commentId) throws Exception {
		ProjectFileComment projectFileComment = projectFileCommentRepository.findOne(commentId);
		projectFileComment.setCommentStatus(OnTargetConstant.ProjectFileCommentStatus.DELETED);
		projectFileCommentRepository.save(projectFileComment);
		return true;

	}

}
