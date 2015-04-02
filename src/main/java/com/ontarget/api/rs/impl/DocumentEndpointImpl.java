package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.DocumentEndpoint;
import com.ontarget.api.service.DocumentService;
import com.ontarget.api.service.impl.DocumentServiceImpl;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentAttachment;
import com.ontarget.request.bean.AddDocumentRequest;
import com.ontarget.request.bean.DocumentDetail;
import com.ontarget.request.bean.UpdateDocumentRequest;
import com.ontarget.request.bean.UpdateDocumentStatus;
import com.ontarget.request.bean.UserDocument;

@Component
@Path("/documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentEndpointImpl implements DocumentEndpoint {

	private Logger logger = Logger.getLogger(DocumentServiceImpl.class);

	@Autowired
	private DocumentService documentService;

	@PUT
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request) {
		try {
			AddDocumentResponse response = documentService.addDocument(request);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("sucessfully uploaded");
			return response;
		} catch (Throwable t) {
			logger.error("Error occurred while serving add document request!",
					t);
			AddDocumentResponse response = new AddDocumentResponse(
					OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Override
	public OnTargetResponse updateDocumentData(UpdateDocumentRequest request) {
		try {
			OnTargetResponse response = documentService.updateDocument(request);
			return response;
		} catch (Throwable t) {
			OnTargetResponse response = new OnTargetResponse(
					OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Path("/status")
	@Override
	public OnTargetResponse updateDocumentStatus(UpdateDocumentStatus request) {
		try {
			OnTargetResponse response = documentService.updateStatus(request);
			return response;
		} catch (Throwable t) {
			logger.error("error", t);
			OnTargetResponse response = new OnTargetResponse(
					OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Path("getUserDocument")
	@Override
	public GetDocumentsResponse getDocuments(UserDocument userDocument) {
		try {
			GetDocumentsResponse response = documentService.getDocuments(
					userDocument.getBaseRequest().getLoggedInUserId(),
					userDocument.getProjectId());
			return response;
		} catch (Throwable t) {
			GetDocumentsResponse response = new GetDocumentsResponse(
					OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Path("/getDocument")
	@Override
	public GetDocumentResponse getDocument(DocumentDetail documentDetail) {
		try {
			GetDocumentResponse response = documentService
					.getDocument(documentDetail.getDcoumentId());
			return response;
		} catch (Throwable t) {
			String errMsg = t.getMessage();
			if (t instanceof NumberFormatException) {
				errMsg = "Invalid document ID specified as path parameter!";
			}
			GetDocumentResponse response = new GetDocumentResponse(
					OnTargetConstant.ERROR, errMsg);
			return response;
		}
	}

	@PUT
	@Path("/attachments")
	@Override
	public AddDocumentAttachmentResponse addDocumentAttachment(
			AddDocumentAttachment request) {
		try {
			AddDocumentAttachmentResponse response = documentService
					.addDocumentAttachment(request);
			return response;
		} catch (Throwable t) {
			AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(t.getMessage());
			return response;
		}
	}

}
