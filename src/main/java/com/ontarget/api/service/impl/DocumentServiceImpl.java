package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ontarget.api.dao.*;
import com.ontarget.bean.*;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentResponse;
import com.ontarget.entities.DocumentSubmittal;
import com.ontarget.entities.User;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;
import com.ontarget.util.DateFormater;
import com.ontarget.util.DocumentUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.repository.DocumentRepository;
import com.ontarget.api.service.DocumentService;
import com.ontarget.api.service.EmailService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;

@Service
public class DocumentServiceImpl implements DocumentService {

	private Logger logger = Logger.getLogger(DocumentServiceImpl.class);

	@Autowired
	@Qualifier("documentTemplateJpaDAOImpl")
	private DocumentTemplateDAO documentTemplateDAO;

	@Autowired
	@Qualifier("documentJpaDAOImpl")
	private DocumentDAO documentDAO;

	@Autowired
	@Qualifier("documentKeyValueJpaDAOImpl")
	private DocumentKeyValueDAO documentKeyValueDAO;

	@Autowired
	@Qualifier("documentGridKeyValueJpaDAOImpl")
	private DocumentGridKeyValueDAO documentGridKeyValueDAO;

	@Autowired
	@Qualifier("documentSubmittalJpaDAOImpl")
	private DocumentSubmittalDAO documentSubmittalDAO;

	@Autowired
	private EmailService emailService;

	@Autowired
	@Qualifier("documentAttachmentJpaDAOImpl")
	private DocumentAttachmentDAO documentAttachmentDAO;

	@Autowired
	@Qualifier("documentResponseJpaDAOImpl")
	private DocumentResponseDAO documentResponseDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	private DocumentRepository documentRepository;

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request) throws Exception {

		DocumentDTO document = new DocumentDTO();

		List<Assignee> assignees = request.getAssignees();
		try {
			document.setDocumentTemplate(new DocumentTemplateDTO(request.getDocumentTemplateId()));
			document.setName(request.getDocumentName());
			document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
			document.setCreatedBy(request.getSubmittedBy());
			document.setModifiedBy(request.getSubmittedBy());
			document.setProjectId(request.getProjectId());
			document.setDueDate(request.getDueDate());
			document = documentDAO.insert(document);
			logger.info("added document with id:: " + document);

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

			List<DocumentGridKeyValue> gridKeyValues = request.getGridKeyValues();
			if (gridKeyValues != null) {
				for (DocumentGridKeyValue gridKeyValue : gridKeyValues) {
					DocumentGridKeyValueDTO documentGridKeyValueDTO = new DocumentGridKeyValueDTO();
					documentGridKeyValueDTO.setDocument(document);
					documentGridKeyValueDTO.setKey(gridKeyValue.getKey());
					documentGridKeyValueDTO.setValue(gridKeyValue.getValue());
					documentGridKeyValueDTO.setGridId(gridKeyValue.getGridId());
					documentGridKeyValueDTO.setGridRowIndex(gridKeyValue.getGridRowIndex());
					documentGridKeyValueDTO.setCreatedBy(request.getSubmittedBy());
					documentGridKeyValueDTO.setModifiedBy(request.getSubmittedBy());
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

				Contact creator = contactDAO.getContact(request.getSubmittedBy());

				Contact contact = contactDAO.getContact(assignee.getUserId());

				if (contact != null && (contact.getEmail() != null && contact.getEmail().trim().length() > 0)) {
					// emailService.sendDocumentSubmittalEmail(document.getName(), contact.getEmail(), contact.getFirstName(), contact.getLastName(), creator.getFirstName(), creator.getLastName(), DateFormater.convertToString(new java.util.Date(document.getDueDate().getTime()), "yyyy-MM-dd"));
				}
			}
		} catch (Throwable t) {
			logger.error("Unable to add document!", t);
			throw new Exception("Unable to create document!");
		}

		// emailService.sendDocumentAssignmentEmails(document, assignees);

		AddDocumentResponse response = new AddDocumentResponse();
		response.setDocument(document);
		return response;
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public OnTargetResponse updateDocument(UpdateDocumentRequest updateDocumentRequest) throws Exception {
		try {
			int documentId = updateDocumentRequest.getDocumentId();

			boolean updated = documentDAO.updateDueDate(updateDocumentRequest.getDocumentId(), updateDocumentRequest.getDueDate(), ""
					+ updateDocumentRequest.getSubmittedBy());

			if (!updated) {
				throw new Exception("Error while updating due date.");
			}

			List<DocumentKeyValue> keyValues = updateDocumentRequest.getKeyValues();
			if (keyValues != null) {
				List<String> usedKeys = new ArrayList<String>();
				for (DocumentKeyValue keyValue : keyValues) {
					usedKeys.add(keyValue.getKey());
					documentKeyValueDAO.updateValue(documentId, keyValue.getKey(), keyValue.getValue(),
							updateDocumentRequest.getSubmittedBy());
				}
				documentKeyValueDAO.deleteDocumentKeyValue(documentId, usedKeys);
			}

			List<DocumentGridKeyValue> gridKeyValues = updateDocumentRequest.getGridKeyValues();
			if (gridKeyValues != null) {
				List<String> usedKeys = new ArrayList<String>();
				for (DocumentGridKeyValue gridKeyValue : gridKeyValues) {

					usedKeys.add(gridKeyValue.getKey());

					documentGridKeyValueDAO.updateValue(documentId, gridKeyValue.getGridId(), gridKeyValue.getGridRowIndex(),
							gridKeyValue.getKey(), gridKeyValue.getValue(), updateDocumentRequest.getSubmittedBy());
				}
				documentGridKeyValueDAO.deleteDocumentGridKeyValue(documentId, usedKeys);
			}
			OnTargetResponse response = new OnTargetResponse(null, OnTargetConstant.SUCCESS, "Document data succefully updated.");
			return response;
		} catch (Throwable t) {
			logger.error("Unable to update document data", t);
			throw new Exception("Unable to update document data!");
		}
	}

	@Override
	public GetDocumentsResponse getDocuments(Integer userId, int projectId) throws Exception {
		if (userId == null) {
			throw new Exception("Please specify the user!");
		}
		try {
			List<DocumentDTO> submittals = documentDAO.getByCreatedBy(userId, projectId);

			for (DocumentDTO doc : submittals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc.getDocumentId()));
				List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setGridKeyValues(gridKeyValues);

				List<DocumentSubmittal> documentSubmittalList = documentSubmittalDAO.getDocumentSubmittalByDocumentId(doc.getDocumentId());
				List<UserDTO> documentSubmittalDTOs = new LinkedList<>();
				doc.setSubmittedTo(documentSubmittalDTOs);
				for (DocumentSubmittal documentSubmittal : documentSubmittalList) {
					// get submitted to
					Contact submittedTo = contactDAO.getContact(documentSubmittal.getUser().getUserId());
					UserDTO submittedToUser = new UserDTO();
					submittedToUser.setContact(submittedTo);
					documentSubmittalDTOs.add(submittedToUser);

				}

				// get submitted to
				if (doc.getModifiedBy() > 0) {
					Contact modifiedBy = contactDAO.getContact(doc.getModifiedBy());
					UserDTO modifiedByUser = new UserDTO();
					modifiedByUser.setContact(modifiedBy);
					doc.setModifiedByUser(modifiedByUser);

				}

			}

			List<DocumentDTO> approvals = documentDAO.getByAssigneeUsername(userId, projectId);
			logger.info("total approval " + approvals.size());
			for (DocumentDTO doc : approvals) {
				doc.setDocumentTemplate(documentTemplateDAO.getByDocumentId(doc.getDocumentId()));
				List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setKeyValues(keyValues);
				List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(doc.getDocumentId());
				doc.setGridKeyValues(gridKeyValues);

				List<DocumentSubmittal> documentSubmittalList = documentSubmittalDAO.getDocumentSubmittalByDocumentId(doc.getDocumentId());
				List<UserDTO> documentSubmittalDTOs = new LinkedList<>();
				doc.setSubmittedTo(documentSubmittalDTOs);
				for (DocumentSubmittal documentSubmittal : documentSubmittalList) {
					// get submitted to
					Contact submittedTo = contactDAO.getContact(documentSubmittal.getUser().getUserId());
					UserDTO submittedToUser = new UserDTO();
					submittedToUser.setContact(submittedTo);
					documentSubmittalDTOs.add(submittedToUser);

				}

				// get submitted to
				if (doc.getModifiedBy() > 0) {
					Contact modifiedBy = contactDAO.getContact(doc.getModifiedBy());
					UserDTO modifiedByUser = new UserDTO();
					modifiedByUser.setContact(modifiedBy);
					doc.setModifiedByUser(modifiedByUser);

				}

			}

			GetDocumentsResponse response = new GetDocumentsResponse();
			response.setSubmittals(submittals);
			response.setApprovals(approvals);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Success");

			return response;
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error("Error while getting the documents!", t);
			throw new Exception("Unable to the documents!");
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public OnTargetResponse updateStatus(UpdateDocumentStatus request) throws Exception {
		try {
			int documentId = request.getDocumentId();
			logger.info("updating status for document id: " + documentId);
			String newStatus = request.getNewStatus();
			int modifiedBy = request.getModifiedBy();
			boolean updated = documentDAO.updateStatus(documentId, newStatus, modifiedBy);
			OnTargetResponse response = new OnTargetResponse();
			if (updated) {
				Document document = documentRepository.findByDocumentId(documentId);

				// send status update notification to all the assignee
				List<DocumentSubmittal> documentSubmittalList = documentSubmittalDAO.getDocumentSubmittalByDocumentId(documentId);

				logger.debug("document submittal list: " + documentSubmittalList);

				Contact modifier = contactDAO.getContact(modifiedBy);

				for (DocumentSubmittal assignee : documentSubmittalList) {
					Contact contact = contactDAO.getContact(assignee.getUser().getUserId());

					if (contact != null && (contact.getEmail() != null && contact.getEmail().trim().length() > 0)) {

						emailService.sendDocumentStatusUpdateEmail(document.getName(), document.getStatus(), contact.getFirstName(),
								contact.getLastName(), contact.getEmail(), modifier.getFirstName(), modifier.getLastName(), document
										.getCreatedBy().getContactList().get(0).getFirstName());
					}
				}

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

	@Override
	public GetDocumentAttachmentsResponse getDocumentAttachments(int documentId) throws Exception {
		if (documentId == 0) {
			throw new Exception("Please provide a valid documentId!");
		}
		try {
			List<DocumentAttachmentDTO> attachments = documentAttachmentDAO.getByDocumentId(documentId);
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
	public GetDocumentQuestionResponse getDocumentQuestionsResponses(GetDocumentQuestionResponseRequest request) throws Exception {
		logger.debug("Getting list for responses for document id: " + request.getDocumentId());
		GetDocumentQuestionResponse response = new GetDocumentQuestionResponse();
		List<DocumentResponse> documentResponses = documentResponseDAO.findDocumentReponseByDocumentId(request.getDocumentId());

		List<DocumentResponseDTO> documentResponseDTOs = new LinkedList<>();
		for (DocumentResponse documentResponse : documentResponses) {
			DocumentResponseDTO documentResponseDTO = DocumentUtil.getDocumentResponseDTOFromDocumentResponseEntity(documentResponse);
			documentResponseDTOs.add(documentResponseDTO);
			// get responsed by user detail
			UserDTO userDTO = documentResponseDTO.getResponsedBy();
			Contact contact = contactDAO.getContact(userDTO.getUserId());
			userDTO.setContact(contact);

			// get modified by user detail
		}

		if (documentResponses != null) {
			response.setDocumentId(request.getDocumentId().longValue());
			response.setDocumentResponses(documentResponseDTOs);
			response.setReturnMessage("Successfully retrieved document responses");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UpdateDocumentQuestionResponse updateDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception {
		logger.debug("updating response for document response id: " + request.getDocumentResponseId());

		if (request.getResponse() == null) {
			throw new Exception("Response text cannot  be null");
		}
		DocumentResponse documentResponse = new DocumentResponse();
		documentResponse.setResponse(request.getResponse());
		logger.debug("user id: " + request.getBaseRequest().getLoggedInUserId());
		documentResponse.setResponseModifiedBY(new User(request.getBaseRequest().getLoggedInUserId()));
		documentResponse.setResponseModifiedDate(new Date());
		documentResponse.setDocumentResponseId(request.getDocumentResponseId());

		documentResponse = documentResponseDAO.update(documentResponse);
		DocumentResponseDTO documentResponseDTO = DocumentUtil.getDocumentResponseDTOFromDocumentResponseEntity(documentResponse);
		Contact contact = contactDAO.getContact(documentResponseDTO.getResponsedBy().getUserId());
		documentResponseDTO.getResponsedBy().setContact(contact);
		UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
		if (documentResponse != null) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully updated document response");
			response.setResponse(documentResponseDTO);
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UpdateDocumentQuestionResponse saveDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception {
		logger.debug("saving new response for document  id: " + request.getDocumentId());

		if (request.getDocumentId() == null) {
			throw new Exception("document id cannot  be null");
		}
		DocumentResponse documentResponse = new DocumentResponse();
		documentResponse.setResponse(request.getResponse());
		documentResponse.setResponseBy(new User(request.getBaseRequest().getLoggedInUserId()));
		documentResponse.setResponseDate(new Date());
		Document document = new Document();
		document.setDocumentId(request.getDocumentId());
		documentResponse.setDocument(document);
		documentResponse.setStatus(OnTargetConstant.GenericStatus.ACTIVE);

		documentResponse = documentResponseDAO.save(documentResponse);

		DocumentResponseDTO documentResponseDTO = DocumentUtil.getDocumentResponseDTOFromDocumentResponseEntity(documentResponse);
		Contact contact = contactDAO.getContact(documentResponseDTO.getResponsedBy().getUserId());
		documentResponseDTO.getResponsedBy().setContact(contact);

		UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
		if (documentResponse != null) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully saved document response");
			response.setResponse(documentResponseDTO);
		}

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception {
		logger.debug("deleting response for document response id: " + request.getDocumentResponseId());
		DocumentResponse documentResponse = new DocumentResponse();
		documentResponse.setResponseModifiedBY(new User(request.getBaseRequest().getLoggedInUserId()));
		documentResponse.setResponseModifiedDate(new Date());
		documentResponse.setDocumentResponseId(request.getDocumentResponseId());

		documentResponse = documentResponseDAO.delete(documentResponse);
		UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
		if (documentResponse != null) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully deleted document response");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public AddDocumentAttachmentResponse addDocumentAttachment(AddDocumentAttachment request) throws Exception {
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
			response.setDocumentAttachmentId(attachment.getDocumentAttachmentId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Document attachment succefully added.");
			return response;
		} catch (Throwable t) {
			logger.error("Unable to add document attachment", t);
			throw new Exception("Unable to add document attachment");
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public AddDocumentAttachmentResponse deleteDocumentAttachment(DeleteDocumentAttachmentRequest request) throws Exception {
		try {
			AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
			if (documentAttachmentDAO.delete(request.getDocumentAttachmentId(), request.getBaseRequest().getLoggedInUserId())) {
				response.setDocumentAttachmentId(request.getDocumentAttachmentId().intValue());
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Document attachment succefully deleted.");
			}
			return response;
		} catch (Throwable t) {
			logger.error("Unable to add document attachment", t);
			throw new Exception("Unable to delete document attachment");
		}
	}

	@Override
	public GetDocumentResponse getDocument(int documentId) throws Exception {
		try {
			DocumentDTO document = documentDAO.read(documentId);
			document.setDocumentTemplate(documentTemplateDAO.getByDocumentId(documentId));

			List<DocumentKeyValueDTO> keyValues = documentKeyValueDAO.getByDocumentId(documentId);
			document.setKeyValues(keyValues);

			List<DocumentGridKeyValueDTO> gridKeyValues = documentGridKeyValueDAO.getByDocumentId(documentId);
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
