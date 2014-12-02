package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.DocumentEndpoint;
import com.ontarget.api.service.DocumentService;
import com.ontarget.api.service.impl.DocumentServiceImpl;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

@Component
@Path("/documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentEndpointImpl implements DocumentEndpoint {
	
	private Logger logger = Logger.getLogger(DocumentServiceImpl.class);

	@Autowired
	private DocumentService documentService;

	/**
	 * 
	 */
	@PUT
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request) {
		try {
			System.out.println("documentService is " + documentService);
			AddDocumentResponse response = documentService.addDocument(request);
			return response;
		} catch (Throwable t) {
			logger.error("Error occurred while serving add document request!", t);
			AddDocumentResponse response = new AddDocumentResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}

	/**
	 * 
	 */
	@POST
	@Override
	public OnTargetResponse updateDocumentData(UpdateDocumentDataRequest request) {
		try {
			OnTargetResponse response = documentService.updateDocument(request);
			return response;
		} catch (Throwable t) {
			OnTargetResponse response = new OnTargetResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}

	/**
	 * 
	 */
	@POST
	@Path("/status")
	@Override
	public OnTargetResponse updateDocumentStatus(
			UpdateDocumentStatusRequest request) {
		try {
			OnTargetResponse response = documentService.updateStatus(request);
			return response;
		} catch (Throwable t) {
			OnTargetResponse response = new OnTargetResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}

	/**
	 * 
	 */
	@GET
	@Override
	public GetDocumentsResponse getDocuments(@QueryParam("userName") String userName) {
		try {
			GetDocumentsResponse response = documentService.getDocuments(userName);
			return response;
		} catch (Throwable t) {
			GetDocumentsResponse response = new GetDocumentsResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}
}
