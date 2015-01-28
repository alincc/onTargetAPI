package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

@Component
@Path("/documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentEndpointImpl implements DocumentEndpoint {
	
	private Logger logger = Logger.getLogger(DocumentServiceImpl.class);

	@Autowired
	private DocumentService documentService;

	/**
	 * API to add new document.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#addDocument(com.ontarget.dto.AddDocumentRequest)
	 */
	@PUT
	@Override
	public AddDocumentResponse addDocument(AddDocumentRequest request) {
		try {
//			System.out.println("documentService is " + documentService);
			AddDocumentResponse response = documentService.addDocument(request);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("sucessfully uploaded");
			return response;
		} catch (Throwable t) {
			logger.error("Error occurred while serving add document request!", t);
			AddDocumentResponse response = new AddDocumentResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}

	/**
	 * Updates the document data.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#updateDocumentData(com.ontarget.dto.UpdateDocumentDataRequest)
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
	 * Updates the status of the specified document to the provided status value.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#updateDocumentStatus(com.ontarget.dto.UpdateDocumentStatusRequest)
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
	 * This API returns all the documents submitted/assigned by/to the specified user.
	 * Parameter userName is required.
	 * 
	 * e.g. usage
	 * /documents?userName=jondoe
	 * this will return the documents (along with the data) that are submitted/assigned
	 * to/from jondoe.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#getDocuments(java.lang.String)
	 */
	@GET
	@Override
	public GetDocumentsResponse getDocuments(@QueryParam("userName") String userName, @QueryParam("projectId") long projectId) {
        System.out.println("doc called");
        try {
			GetDocumentsResponse response = documentService.getDocuments(userName, projectId);
			return response;
		} catch (Throwable t) {
			GetDocumentsResponse response = new GetDocumentsResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}
	
	/**
	 * This API returns the data for the document with the document id  as specified as the path parameter. 
	 * 
	 * e.g. usage
	 * /documents/123
	 * this will return the data for the document which id is 123.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#getDocument(java.lang.String)
	 */
	@GET
	@Path("/{documentId}")
	@Override
	public GetDocumentResponse getDocument(@PathParam("documentId") String documentId) {
		try {
			long docId = Long.parseLong(documentId);
			GetDocumentResponse response = documentService.getDocument(docId);
			return response;
		} catch (Throwable t) {
			String errMsg = t.getMessage();
			if(t instanceof NumberFormatException) {
				errMsg = "Invalid document ID specified as path parameter!";
			}
			GetDocumentResponse response = new GetDocumentResponse(OnTargetConstant.ERROR,
					errMsg);
			return response;
		}
	}

	/**
	 * Returns the attachments that belongs to the specified document.
	 * The document id is withing the URL.
	 * 
	 * e.g.
	 * 
	 * /1234/attachments
	 * this will return the attachments that belong to the document with id 1234.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#getDocumentAttachments(java.lang.Long)
	 */
	@GET
	@Path("/{documentId}/attachments")
	@Override
	public GetDocumentAttachmentsResponse getDocumentAttachments(@PathParam("documentId") Long documentId) {
		try {
			GetDocumentAttachmentsResponse response = documentService.getDocumentAttachments(documentId);
			return response;
		} catch (Throwable t) {
			GetDocumentAttachmentsResponse response = new GetDocumentAttachmentsResponse(OnTargetConstant.ERROR,
					t.getMessage());
			return response;
		}
	}

	/**
	 * Saves the specified document attachment file.
	 */
	/* (non-Javadoc)
	 * @see com.ontarget.api.rs.DocumentEndpoint#addDocumentAttachment(com.ontarget.dto.AddDocumentAttachmentRequest)
	 */
	@PUT
	@Path("/attachments")
	@Override
	public AddDocumentAttachmentResponse addDocumentAttachment(
			AddDocumentAttachmentRequest request) {
		try {
			AddDocumentAttachmentResponse response = documentService.addDocumentAttachment(request);
			return response;
		} catch (Throwable t) {
			AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(t.getMessage());
			return response;
		}
	}

	
}
