package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.DocumentAttachmentDAO;
import com.ontarget.api.dao.DocumentDAO;
import com.ontarget.api.dao.DocumentGridKeyValueDAO;
import com.ontarget.api.dao.DocumentKeyValueDAO;
import com.ontarget.api.dao.DocumentSubmittalDAO;
import com.ontarget.api.dao.DocumentTemplateDAO;
import com.ontarget.api.service.DocumentService;
import com.ontarget.api.service.EmailService;
import com.ontarget.bean.Document;
import com.ontarget.bean.DocumentAttachment;
import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.DocumentSubmittal;
import com.ontarget.bean.DocumentTemplate;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentRequest;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	private Logger logger = Logger.getLogger(DocumentServiceImpl.class);
	
	@Autowired
	private DocumentTemplateDAO documentTemplateDAO;
	
	@Autowired
	private DocumentDAO documentDAO;
	
	@Autowired
	private DocumentKeyValueDAO documentKeyValueDAO;
	
	@Autowired
	private DocumentGridKeyValueDAO documentGridKeyValueDAO;
	
	@Autowired
	private DocumentSubmittalDAO documentSubmittalDAO;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private DocumentAttachmentDAO documentAttachmentDAO;
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request) throws Exception {
		Document document = new Document();
		List<User> assignees = request.getAssignees();
		try {
			document.setDocumentTemplate(new DocumentTemplate(request.getDocumentTemplateId()));
			document.setName(request.getDocumentName());
			document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
			document.setCreatedBy(request.getSubmitter().getUserId());
			document.setModifiedBy(request.getSubmitter().getUserId());
            document.setProjectId(request.getProjectId());
			document = documentDAO.insert(document);
			
			List<DocumentKeyValue> keyValues = request.getKeyValues();
			if(keyValues != null) {
				for(DocumentKeyValue keyValue : keyValues) {
					keyValue.setDocument(document);
					keyValue.setCreatedBy(request.getSubmitter().getUserId());
					keyValue.setModifiedBy(request.getSubmitter().getUserId());
					documentKeyValueDAO.insert(keyValue);
				}
			}
			
			List<DocumentGridKeyValue> gridKeyValues = request.getGridKeyValues();
			if(gridKeyValues != null) {
				for(DocumentGridKeyValue gridKeyValue : gridKeyValues) {
					gridKeyValue.setDocument(document);
					gridKeyValue.setCreatedBy(request.getSubmitter().getUserId());
					gridKeyValue.setModifiedBy(request.getSubmitter().getUserId());
					documentGridKeyValueDAO.insert(gridKeyValue);
				}
			}
			
			for(User assignee : assignees) {
				DocumentSubmittal submittal = new DocumentSubmittal();
				submittal.setDocument(document);
				submittal.setAssignee(assignee);
				submittal.setCreatedBy(request.getSubmitter().getUserId());
				submittal.setModifiedBy(request.getSubmitter().getUserId());
				documentSubmittalDAO.insert(submittal);
			}
		} catch(Throwable t) {
//			t.printStackTrace();
			logger.error("Unable to add document!", t);
			throw new Exception("Unable to create document!");
		}
		
		emailService.sendDocumentAssignmentEmails(document, assignees);
				
		AddDocumentResponse response = new AddDocumentResponse();
		response.setDocument(document);
		return response;
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public OnTargetResponse updateDocument(UpdateDocumentDataRequest request) throws Exception {
		try {
			long documentId = request.getDocumentId();
			User user = request.getUser();
			
			List<DocumentKeyValue> keyValues = request.getKeyValues();
			if(keyValues != null) {
				for(DocumentKeyValue keyValue : keyValues) {
					documentKeyValueDAO.updateValue(documentId, keyValue.getKey(), keyValue.getValue(), user.getUsername());
				}
			}
			
			List<DocumentGridKeyValue> gridKeyValues = request.getGridKeyValues();
			if(gridKeyValues != null) {
				for(DocumentGridKeyValue gridKeyValue : gridKeyValues) {
					
					documentGridKeyValueDAO.updateValue(documentId, gridKeyValue.getGridId(), 
							gridKeyValue.getGridRowIndex(), gridKeyValue.getKey(), gridKeyValue.getValue(), user.getUsername());
				}
			}
			OnTargetResponse response = new OnTargetResponse(null, OnTargetConstant.SUCCESS,
					"Document data succefully updated.");
			return response;
		} catch(Throwable t) {
			logger.error("Unable to update document data", t);
			throw new Exception("Unable to update document data!");
		}
	}

	@Override
	public GetDocumentsResponse getDocuments(String userName, long projectId) throws Exception {
//        logger.info("get doc called");
		if(userName == null || userName.trim().isEmpty()) {
			throw new Exception("Please specify the userName!");
		}
		try {
			List<Document> submittals = documentDAO.getByCreatedBy(userName, projectId);
			
			for(Document doc : submittals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc.getDocumentId()));
				List<DocumentKeyValue> keyValues = documentKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValue> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setGridKeyValues(gridKeyValues);
			}
			
			List<Document> approvals = documentDAO.getByAssigneeUsername(userName, projectId);
			logger.info ("total approval "+approvals.size());
//            System.out.println("total approval "+approvals.size());
			for(Document doc : approvals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc.getDocumentId()));
				List<DocumentKeyValue> keyValues = documentKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValue> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setGridKeyValues(gridKeyValues);
			}
			
			GetDocumentsResponse response = new GetDocumentsResponse();
			response.setSubmittals(submittals);
			response.setApprovals(approvals);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Success");
			
			return response;
		} catch (Throwable t) {
			logger.error("Error while getting the documents!", t);
			throw new Exception("Unable to the documents!");
		}
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public OnTargetResponse updateStatus(UpdateDocumentStatusRequest request) throws Exception {
		try {
			Long documentId = request.getDocumentId();
			String newStatus = request.getNewStatus();
			User updater = request.getUpdater();
			boolean updated = documentDAO.updateStatus(documentId, newStatus, updater.getUsername());
			OnTargetResponse response = new OnTargetResponse();
			if(updated) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Document status successfully updated!");
			}
			return response;
		} catch(Throwable t) {
			logger.error("Error while updating document status!", t);
			throw new Exception("Unable to update the document status!");
		}
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public GetDocumentAttachmentsResponse getDocumentAttachments(Long documentId)  throws Exception {
		if(documentId == null) {
			throw new Exception("Please provide a valid documentId!");
		}
		try {
			List<DocumentAttachment> attachments = documentAttachmentDAO.getByDocumentId(documentId);
			GetDocumentAttachmentsResponse response = new GetDocumentAttachmentsResponse();
			response.setResponseCode(OnTargetConstant.SUCCESS);
			response.setAttachments(attachments);
			return response;
		} catch(Throwable t) {
			logger.error("Error while getting document attachments!", t);
			throw new Exception("Unable to get the document attachments!");
		}
	}

	@Override
	public AddDocumentAttachmentResponse addDocumentAttachment(
			AddDocumentAttachmentRequest request) throws Exception {
		try {
			String filePath = request.getFilePath();
			Long documentId = request.getDocumentId();
			User user = request.getUser();
			DocumentAttachment attachment = new DocumentAttachment();
			attachment.setDocument(new Document(documentId));
			attachment.setFilePath(filePath);
			attachment.setCreatedBy(user.getUserId());
			attachment.setModifiedBy(user.getUserId());
			documentAttachmentDAO.insert(attachment);
			AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
			response.setDocumentAttachmentId(attachment.getDocumentAttachmentId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Document attachment succefully added.");
			return response;
		} catch(Throwable t) {
			logger.error("Unable to add document attachment", t);
			throw new Exception("Unable to add document attachment!");
		}
	}

	@Override
	public GetDocumentResponse getDocument(long documentId) throws Exception {
		try {		
			Document document = documentDAO.read(documentId);
			document.setDocumentTemplate(documentTemplateDAO.getByDocumentId(documentId));
			
			List<DocumentKeyValue> keyValues = documentKeyValueDAO.getByDocumentId(documentId);
			document.setKeyValues(keyValues);
			
			List<DocumentGridKeyValue> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(documentId);
			document.setGridKeyValues(gridKeyValues);
			
			GetDocumentResponse response = new GetDocumentResponse();
			response.setDocument(document);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Success");
			
			return response;
		} catch (Throwable t) {
			logger.error("Error while getting the documents!", t);
			throw new Exception("Unable to the documents!");
		}
	}

}
