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
import com.ontarget.bean.DocumentAttachmentDTO;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.bean.DocumentSubmittalDTO;
import com.ontarget.bean.DocumentTemplateDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentAttachment;
import com.ontarget.request.bean.AddDocumentRequest;
import com.ontarget.request.bean.Assignee;
import com.ontarget.request.bean.DocumentGridKeyValue;
import com.ontarget.request.bean.DocumentKeyValue;
import com.ontarget.request.bean.UpdateDocumentRequest;
import com.ontarget.request.bean.UpdateDocumentStatus;

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

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request)
			throws Exception {

		DocumentDTO document = new DocumentDTO();

		List<Assignee> assignees = request.getAssignees();
		try {

			document.setDocumentTemplate(new DocumentTemplateDTO(request
					.getDocumentTemplateId()));
			document.setName(request.getDocumentName());
			document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
			document.setCreatedBy(request.getSubmittedBy());
			document.setModifiedBy(request.getSubmittedBy());
			document.setProjectId(request.getProjectId());
			document.setDueDate(request.getDueDate());
			document = documentDAO.insert(document);
			logger.info("document:: " + document);

			List<DocumentKeyValue> keyValues = request.getKeyValues();
			if (keyValues != null) {
				for (DocumentKeyValue keyValue : keyValues) {
					DocumentKeyValueDTO documentKeyValueDTO = new DocumentKeyValueDTO();
					documentKeyValueDTO.setDocument(document);
					documentKeyValueDTO.setKey(keyValue.getKey());
					documentKeyValueDTO.setValue(keyValue.getValue());
					documentKeyValueDTO.setCreatedBy(request.getSubmittedBy());
					documentKeyValueDTO.setModifiedBy(request.getSubmittedBy());
					documentKeyValueDAO.insert(documentKeyValueDTO);
				}
			}

			List<DocumentGridKeyValue> gridKeyValues = request
					.getGridKeyValues();
			if (gridKeyValues != null) {
				for (DocumentGridKeyValue gridKeyValue : gridKeyValues) {
					DocumentGridKeyValueDTO documentGridKeyValueDTO = new DocumentGridKeyValueDTO();
					documentGridKeyValueDTO.setDocument(document);
					documentGridKeyValueDTO.setKey(gridKeyValue.getKey());
					documentGridKeyValueDTO.setValue(gridKeyValue.getValue());
					documentGridKeyValueDTO.setGridId(gridKeyValue.getGridId());
					documentGridKeyValueDTO.setGridRowIndex(gridKeyValue
							.getGridRowIndex());
					documentGridKeyValueDTO.setCreatedBy(request
							.getSubmittedBy());
					documentGridKeyValueDTO.setModifiedBy(request
							.getSubmittedBy());
					documentGridKeyValueDAO.insert(documentGridKeyValueDTO);
				}
			}

			for (Assignee assignee : assignees) {
				DocumentSubmittalDTO submittal = new DocumentSubmittalDTO();
				submittal.setDocument(document);
				submittal.setAssignedTo(assignee.getUserId());
				submittal.setCreatedBy(request.getSubmittedBy());
				submittal.setModifiedBy(request.getSubmittedBy());
				documentSubmittalDAO.insert(submittal);
			}
		} catch (Throwable t) {
			logger.error("Unable to add document!", t);
			throw new Exception("Unable to create document!");
		}

		emailService.sendDocumentAssignmentEmails(document, assignees);

		AddDocumentResponse response = new AddDocumentResponse();
		response.setDocument(document);
		return response;
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public OnTargetResponse updateDocument(
			UpdateDocumentRequest updateDocumentRequest) throws Exception {
		try {
			int documentId = updateDocumentRequest.getDocumentId();

			boolean updated = documentDAO.updateDueDate(
					updateDocumentRequest.getDocumentId(),
					updateDocumentRequest.getDueDate(), ""
							+ updateDocumentRequest.getSubmittedBy());

			if (!updated) {
				throw new Exception("Error while updating due date.");
			}

			List<DocumentKeyValue> keyValues = updateDocumentRequest
					.getKeyValues();
			if (keyValues != null) {
				for (DocumentKeyValue keyValue : keyValues) {
					documentKeyValueDAO.updateValue(documentId,
							keyValue.getKey(), keyValue.getValue(),
							updateDocumentRequest.getSubmittedBy());
				}
			}

			List<DocumentGridKeyValue> gridKeyValues = updateDocumentRequest
					.getGridKeyValues();
			if (gridKeyValues != null) {
				for (DocumentGridKeyValue gridKeyValue : gridKeyValues) {

					documentGridKeyValueDAO.updateValue(documentId,
							gridKeyValue.getGridId(),
							gridKeyValue.getGridRowIndex(),
							gridKeyValue.getKey(), gridKeyValue.getValue(),
							updateDocumentRequest.getSubmittedBy());
				}
			}
			OnTargetResponse response = new OnTargetResponse(null,
					OnTargetConstant.SUCCESS,
					"Document data succefully updated.");
			return response;
		} catch (Throwable t) {
			logger.error("Unable to update document data", t);
			throw new Exception("Unable to update document data!");
		}
	}

	@Override
	public GetDocumentsResponse getDocuments(String userName, int projectId)
			throws Exception {
		if (userName == null || userName.trim().isEmpty()) {
			throw new Exception("Please specify the userName!");
		}
		try {
			List<DocumentDTO> submittals = documentDAO.getByCreatedBy(userName,
					projectId);

			for (DocumentDTO doc : submittals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc
						.getDocumentId()));
				List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO
						.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO
						.getByDocumentId(doc.getDocumentId());
				doc.setGridKeyValues(gridKeyValues);
			}

			List<DocumentDTO> approvals = documentDAO.getByAssigneeUsername(
					userName, projectId);
			logger.info("total approval " + approvals.size());
			// System.out.println("total approval "+approvals.size());
			for (DocumentDTO doc : approvals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc
						.getDocumentId()));
				List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO
						.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO
						.getByDocumentId(doc.getDocumentId());
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

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public OnTargetResponse updateStatus(UpdateDocumentStatus request)
			throws Exception {
		try {

			int documentId = request.getDocumentId();
			String newStatus = request.getNewStatus();
			int modifiedBy = request.getModifiedBy();
			boolean updated = documentDAO.updateStatus(documentId, newStatus,
					modifiedBy);
			OnTargetResponse response = new OnTargetResponse();
			if (updated) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Document status successfully updated!");
			}
			return response;
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			logger.error("Error while updating document status!", t);
			throw new Exception("Unable to update the document status!");
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public GetDocumentAttachmentsResponse getDocumentAttachments(int documentId)
			throws Exception {
		if (documentId == 0) {
			throw new Exception("Please provide a valid documentId!");
		}
		try {
			List<DocumentAttachmentDTO> attachments = documentAttachmentDAO
					.getByDocumentId(documentId);
			GetDocumentAttachmentsResponse response = new GetDocumentAttachmentsResponse();
			response.setResponseCode(OnTargetConstant.SUCCESS);
			response.setAttachments(attachments);
			return response;
		} catch (Throwable t) {
			logger.error("Error while getting document attachments!", t);
			throw new Exception("Unable to get the document attachments!");
		}
	}

	@Override
	public AddDocumentAttachmentResponse addDocumentAttachment(
			AddDocumentAttachment request) throws Exception {
		try {
			String filePath = request.getFilePath();
			int documentId = request.getDocumentId();
			int addedBy = request.getAddedBy();
			DocumentAttachmentDTO attachment = new DocumentAttachmentDTO();
			attachment.setDocument(new DocumentDTO(documentId));
			attachment.setFilePath(filePath);
			attachment.setAddedBy(addedBy);
			documentAttachmentDAO.insert(attachment);
			AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
			response.setDocumentAttachmentId(attachment
					.getDocumentAttachmentId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Document attachment succefully added.");
			return response;
		} catch (Throwable t) {
			logger.error("Unable to add document attachment", t);
			throw new Exception("Unable to add document attachment");
		}
	}

	@Override
	public GetDocumentResponse getDocument(int documentId) throws Exception {
		try {
			DocumentDTO document = documentDAO.read(documentId);
			document.setDocumentTemplate(documentTemplateDAO
					.getByDocumentId(documentId));

			List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO
					.getByDocumentId(documentId);
			document.setKeyValues(keyValues);

			List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO
					.getByDocumentId(documentId);
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
