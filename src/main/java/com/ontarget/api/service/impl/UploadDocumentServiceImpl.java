package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.api.repository.ProjectFileCategoryRepository;
import com.ontarget.api.service.UploadDocumentService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UploadDocument;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.ProjectFileCategory;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.response.bean.ProjectFileCategoryListResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;
import com.ontarget.response.bean.ProjectFileCommentResponse;

@Service
public class UploadDocumentServiceImpl implements UploadDocumentService {

	private Logger logger = Logger.getLogger(UploadDocumentServiceImpl.class);

	@Autowired
	@Qualifier("uploadDocumentJpaDAOImpl")
	private UploadDocumentDAO uploadDocumentDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Autowired
	private ProjectFileCategoryRepository projectFileCategoryRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean saveUploadedDocsInfo(UploadDocumentRequest documentInfo) throws Exception {
		logger.info("service call initiated for document upload");
		UploadDocument documentBean = new UploadDocument(documentInfo);
		documentBean = uploadDocumentDAO.saveUploadedDocsInfo(documentBean);

		if (documentBean.getProjectFileId() >= 1) {
			logger.info("Information saved successfully");
			return Boolean.TRUE;
		}
		logger.info("failed to save information");
		return Boolean.FALSE;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception {
		logger.info("service call initiated to fetch uploaded file for project id" + projectId);
		List<UploadedDocumentDetail> resultList = uploadDocumentDAO.getFilesByProjectId(projectId);
		Map<Integer, Contact> contactMap = new HashMap<>();
		for (UploadedDocumentDetail detail : resultList) {
			int createdBy = detail.getCreatedBy();
			if (contactMap.containsKey(createdBy)) {
				detail.setCreatedByContact(contactMap.get(createdBy));
			} else {
				Contact c = contactDAO.getContact(createdBy);
				contactMap.put(createdBy, c);
				detail.setCreatedByContact(c);
			}
		}

		return resultList;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse deleteProjectFile(Integer projectFileId,int userId) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		boolean success = uploadDocumentDAO.deleteProjectFile(projectFileId,userId);
		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Project file deleted successfully");
		} else {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Project file delete request failed");
		}
		return response;
	}

	@Override
	public ProjectFileCommentListResponse getCommentList(Integer projectFileId) throws Exception {
		ProjectFileCommentListResponse response = new ProjectFileCommentListResponse();
		List<ProjectFileComment> commentList = uploadDocumentDAO.getCommentsByFileId(projectFileId);

		List<ProjectFileCommentResponse> commentResponse = new ArrayList<ProjectFileCommentResponse>();

		Map<Integer, Contact> contactMap = new HashMap<>();

		commentList.forEach(comment -> {
			ProjectFileCommentResponse commentObj = new ProjectFileCommentResponse();
			commentObj.setProjectFileCommentId(comment.getProjectFileCommentId());
			commentObj.setComment(comment.getComment());
			commentObj.setCommentedBy(comment.getCommentedBy().getUserId());
			commentObj.setCommentedDate(new Date());
			int commentedBy = comment.getCommentedBy().getUserId();

			if (contactMap.containsKey(commentedBy)) {
				commentObj.setCommenterContact(contactMap.get(commentedBy));
			} else {
				try {
					Contact contact = taskDAO.getContact(commentedBy);
					contactMap.put(commentedBy, contact);
					commentObj.setCommenterContact(contact);
				} catch (Exception e) {
				}
			}
			commentResponse.add(commentObj);

		});
		response.setComments(commentResponse);
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setReturnMessage("Successfully retrieved project file comments");

		return response;
	}

	@Override
	public ProjectFileCategoryListResponse getProjectFileCategories() throws Exception {
		ProjectFileCategoryListResponse response = new ProjectFileCategoryListResponse();

		List<ProjectFileCategory> categoryList = projectFileCategoryRepository.findByActive("Y");
		List<com.ontarget.response.bean.ProjectFileCategory> categories = new ArrayList<>();

		categoryList.forEach(category -> {
			if (category.getActive().equalsIgnoreCase("Y")) {
				com.ontarget.response.bean.ProjectFileCategory projectFileCategory = new com.ontarget.response.bean.ProjectFileCategory();
				projectFileCategory.setName(category.getName());
				projectFileCategory.setId(category.getProjectFileCategoryId());
				categories.add(projectFileCategory);
			}
		});

		response.setCategories(categories);
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setReturnMessage("Successfully retrieved project category list");
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addUpdateComment(ProjectFileCommentRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		boolean success = uploadDocumentDAO.addComment(request);
		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			if (request.getCommentId() != null) {
				response.setReturnMessage("Comment updated successfully");
			} else {
				response.setReturnMessage("Comment added successfully");
			}
		} else {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Add/Update comment request failed");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse deleteComment(Integer commentId) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		boolean success = uploadDocumentDAO.deleteComment(commentId);
		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Comment deleted successfully");
		} else {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Delete comment request failed");
		}
		return response;
	}

}
