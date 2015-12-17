package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import com.ontarget.api.repository.ProjectFilePageRepository;
import com.ontarget.bean.Contact;
import com.ontarget.dto.ProjectFilePageDTO;
import com.ontarget.entities.*;
import com.ontarget.util.ProjectFilePageUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.api.repository.ProjectFileCommentRepository;
import com.ontarget.api.repository.ProjectFileRepository;
import com.ontarget.bean.UploadDocument;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.ProjectFileCommentRequest;

@Repository("uploadDocumentJpaDAOImpl")
public class UploadDocumentJpaDAOImpl implements UploadDocumentDAO {

	@Resource
	private ProjectFileRepository projectFileRepository;
	@Resource
	private ProjectFileCommentRepository projectFileCommentRepository;
    @Resource
    ProjectFilePageRepository projectFilePageRepository;

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
        projectFile.setParentProjectFileId(documentBean.getParentProjectFileId());
        projectFile.setThumbnailImageName(documentBean.getThumbnailImageName());
        projectFile.setIsConversionComplete(documentBean.isConversionComplete() ? "Y" : "N");
        projectFile.setVersionNo(documentBean.getVersionNo());
        projectFile.setFilePath(documentBean.getFilePath());

		projectFileRepository.save(projectFile);

        UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
        documentDetail.setFileId(projectFile.getProjectFileId());
        documentDetail.setName(projectFile.getFileName());
        documentDetail.setFileType(projectFile.getFileType());
        documentDetail.setCreatedBy(projectFile.getCreatedBy().getUserId());
        documentDetail.setCreatedDate(projectFile.getCreatedDate());
        documentDetail.setProjectFileCategoryId(projectFile.getProjectFileCategory());
        documentDetail.setDescription(projectFile.getDescription());
        documentDetail.setParentProjectFileId(projectFile.getParentProjectFileId());
        documentDetail.setThumbnailImageName(projectFile.getThumbnailImageName());
        documentDetail.setVersionNo(projectFile.getVersionNo());
        documentDetail.setConversionComplete(projectFile.getIsConversionComplete().equals("Y") ? true : false);
        documentDetail.setFilePath(projectFile.getFilePath());

        /**
         * Also get all the pages if exists
         */

        List<ProjectFilePage> projectFilePages = projectFilePageRepository.findPagesByProjectFileId(documentBean.getProjectFileId());
        List<ProjectFilePageDTO> projectFilePageDTOs = new LinkedList<>();

        if(projectFilePages!=null && projectFilePages.size() > 0){
            for(ProjectFilePage projectFilePage : projectFilePages){
                projectFilePageDTOs.add(ProjectFilePageUtil.getDTOFromEntity(projectFilePage));
            }
        }
        documentDetail.setProjectFilePageDTOs(projectFilePageDTOs);



        return documentDetail;
	}

	@Override
	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId) throws Exception{
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
                documentDetail.setParentProjectFileId(file.getParentProjectFileId());
                documentDetail.setThumbnailImageName(file.getThumbnailImageName());
                documentDetail.setVersionNo(file.getVersionNo());
                documentDetail.setConversionComplete(file.getIsConversionComplete().equals("Y") ? true : false);
                documentDetail.setFilePath(file.getFilePath());
                
                
                List<ProjectFile> versionedFiles=projectFileRepository.getProjectFileByParentProjectFileIdAndVersionNumSortedDescLimitOne(file.getProjectFileId(), new PageRequest(0, 100));
                List<UploadedDocumentDetail> versionedFileList = new LinkedList<>();
                documentDetail.setVersionProjectFiles(versionedFileList);
                if(versionedFiles!=null && versionedFiles.size() > 0) {
                    for (ProjectFile versionedFile : versionedFiles) {
                        UploadedDocumentDetail documentDetailV = new UploadedDocumentDetail();
                        documentDetailV.setFileId(versionedFile.getProjectFileId());
                        documentDetailV.setName(versionedFile.getFileName());
                        documentDetailV.setFileType(versionedFile.getFileType());
                        documentDetailV.setCreatedBy(versionedFile.getCreatedBy().getUserId());
                        documentDetailV.setCreatedDate(versionedFile.getCreatedDate());
                        documentDetailV.setProjectFileCategoryId(versionedFile.getProjectFileCategory());
                        documentDetailV.setDescription(versionedFile.getDescription());
                        documentDetailV.setParentProjectFileId(versionedFile.getParentProjectFileId());
                        documentDetailV.setThumbnailImageName(versionedFile.getThumbnailImageName());
                        documentDetailV.setVersionNo(versionedFile.getVersionNo());
                        documentDetailV.setConversionComplete(versionedFile.getIsConversionComplete().equals("Y") ? true : false);
                        documentDetailV.setFilePath(versionedFile.getFilePath());
                        versionedFileList.add(documentDetailV);
                    }
                }


                /**
                 * Also get all the pages if exists
                 */

                List<ProjectFilePage> projectFilePages = projectFilePageRepository.findPagesByProjectFileId(file.getProjectFileId());
                List<ProjectFilePageDTO> projectFilePageDTOs = new LinkedList<>();

                if(projectFilePages!=null && projectFilePages.size() > 0){
                    for(ProjectFilePage projectFilePage : projectFilePages){
                        projectFilePageDTOs.add(ProjectFilePageUtil.getDTOFromEntity(projectFilePage));
                    }
                }
                documentDetail.setProjectFilePageDTOs(projectFilePageDTOs);
                
                
                
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
        documentDetail.setParentProjectFileId(projectFile.getParentProjectFileId());
        documentDetail.setThumbnailImageName(projectFile.getThumbnailImageName());
        documentDetail.setVersionNo(projectFile.getVersionNo());
        documentDetail.setConversionComplete(projectFile.getIsConversionComplete().equals("Y") ? true : false);
        documentDetail.setFilePath(projectFile.getFilePath());

        /**
         * Also get all the pages if exists
         */

        List<ProjectFilePage> projectFilePages = projectFilePageRepository.findPagesByProjectFileId(documentBean.getProjectFileId());
        List<ProjectFilePageDTO> projectFilePageDTOs = new LinkedList<>();

        if(projectFilePages!=null && projectFilePages.size() > 0){
            for(ProjectFilePage projectFilePage : projectFilePages){
                projectFilePageDTOs.add(ProjectFilePageUtil.getDTOFromEntity(projectFilePage));
            }
        }
        documentDetail.setProjectFilePageDTOs(projectFilePageDTOs);


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

        documentDetail.setParentProjectFileId(file.getParentProjectFileId());
        documentDetail.setThumbnailImageName(file.getThumbnailImageName());
        documentDetail.setVersionNo(file.getVersionNo());
        documentDetail.setConversionComplete(file.getIsConversionComplete().equals("Y") ? true : false);
        documentDetail.setFilePath(file.getFilePath());

        List<ProjectFile> versionedFiles=projectFileRepository.getProjectFileByParentProjectFileIdAndVersionNumSortedDescLimitOne(file.getProjectFileId(), new PageRequest(0, 100));
        List<UploadedDocumentDetail> versionedFileList = new LinkedList<>();
        documentDetail.setVersionProjectFiles(versionedFileList);
        if(versionedFiles!=null && versionedFiles.size() > 0) {
            for (ProjectFile versionedFile : versionedFiles) {
                UploadedDocumentDetail documentDetailV = new UploadedDocumentDetail();
                documentDetailV.setFileId(versionedFile.getProjectFileId());
                documentDetailV.setName(versionedFile.getFileName());
                documentDetailV.setFileType(versionedFile.getFileType());
                documentDetailV.setCreatedBy(versionedFile.getCreatedBy().getUserId());
                documentDetailV.setCreatedDate(versionedFile.getCreatedDate());
                documentDetailV.setProjectFileCategoryId(versionedFile.getProjectFileCategory());
                documentDetailV.setDescription(versionedFile.getDescription());
                documentDetailV.setParentProjectFileId(versionedFile.getParentProjectFileId());
                documentDetailV.setThumbnailImageName(versionedFile.getThumbnailImageName());
                documentDetailV.setVersionNo(versionedFile.getVersionNo());
                documentDetailV.setConversionComplete(versionedFile.getIsConversionComplete().equals("Y") ? true : false);
                documentDetailV.setFilePath(versionedFile.getFilePath());
                versionedFileList.add(documentDetailV);
            }
        }

        /**
         * Also get all the pages if exists
         */

        List<ProjectFilePage> projectFilePages = projectFilePageRepository.findPagesByProjectFileId(file.getProjectFileId());
        List<ProjectFilePageDTO> projectFilePageDTOs = new LinkedList<>();

        if(projectFilePages!=null && projectFilePages.size() > 0){
            for(ProjectFilePage projectFilePage : projectFilePages){
                projectFilePageDTOs.add(ProjectFilePageUtil.getDTOFromEntity(projectFilePage));
            }
        }
        documentDetail.setProjectFilePageDTOs(projectFilePageDTOs);



        return documentDetail;
    }

    @Override
    public int getVersionNumberByParentProjectFileId(int parentProjectFileId) throws Exception {
        Pageable topOne = new PageRequest(0, 1);
        List<ProjectFile> projectFiles=projectFileRepository.getProjectFileByParentProjectFileIdAndVersionNumSortedDescLimitOne(parentProjectFileId,topOne);
        if(projectFiles!=null && projectFiles.size() > 0){
            return projectFiles.get(0).getVersionNo();
        }
        return 0;
    }

    @Override
    public boolean updateConversionComplete(Integer projectFileId, Integer loggedInUserId, String isConversionComplete) {
        ProjectFile projectFile = projectFileRepository.findById(projectFileId);
        projectFile.setIsConversionComplete(isConversionComplete);
        projectFile.setModifiedBy(new User(loggedInUserId));
        projectFile.setModifiedDate(new Date());
        projectFileRepository.save(projectFile);
        return projectFile.getIsConversionComplete().equals(isConversionComplete);
    }

    @Override
	public ProjectFileComment addComment(ProjectFileCommentRequest request) throws Exception {
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
		return projectFileComment;
	}

	@Override
	public boolean deleteComment(Integer commentId) throws Exception {
		ProjectFileComment projectFileComment = projectFileCommentRepository.findOne(commentId);
		projectFileComment.setCommentStatus(OnTargetConstant.ProjectFileCommentStatus.DELETED);
		projectFileCommentRepository.save(projectFileComment);
		return true;

	}

}
