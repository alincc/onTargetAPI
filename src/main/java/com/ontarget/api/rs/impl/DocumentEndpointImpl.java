package com.ontarget.api.rs.impl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.ontarget.dto.*;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.DocumentStatsResponse;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.DocumentEndpoint;
import com.ontarget.api.service.DocumentService;
import com.ontarget.api.service.impl.DocumentServiceImpl;
import com.ontarget.constant.OnTargetConstant;

@Component
@Path("/document")
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
			logger.error("Error occurred while serving add document request!", t);
			AddDocumentResponse response = new AddDocumentResponse(OnTargetConstant.ERROR, t.getMessage());
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
			OnTargetResponse response = new OnTargetResponse(OnTargetConstant.ERROR, t.getMessage());
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
			OnTargetResponse response = new OnTargetResponse(OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Path("/getUserDocument")
	@Override
	public GetDocumentsResponse getDocuments(UserDocument userDocument) {
		try {
			GetDocumentsResponse response = documentService.getDocuments(userDocument.getBaseRequest().getLoggedInUserId(),
					userDocument.getProjectId());
			return response;
		} catch (Throwable t) {
			GetDocumentsResponse response = new GetDocumentsResponse(OnTargetConstant.ERROR, t.getMessage());
			return response;
		}
	}

	@POST
	@Path("/getDocument")
	@Override
	public GetDocumentResponse getDocument(DocumentDetail documentDetail) {
		try {
			GetDocumentResponse response = documentService.getDocument(documentDetail.getDcoumentId());
			return response;
		} catch (Throwable t) {
			String errMsg = t.getMessage();
			if (t instanceof NumberFormatException) {
				errMsg = "Invalid document ID specified as path parameter!";
			}
			GetDocumentResponse response = new GetDocumentResponse(OnTargetConstant.ERROR, errMsg);
			return response;
		}
	}

	@PUT
	@Path("/attachment/save")
	@Override
	public AddDocumentAttachmentResponse addDocumentAttachment(AddDocumentAttachment request) {
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

    @PUT
    @Path("/attachment/delete")
    @Override
    public AddDocumentAttachmentResponse deleteDocumentAttachment(DeleteDocumentAttachmentRequest request) {
        try {
            AddDocumentAttachmentResponse response = documentService.deleteDocumentAttachment(request);
            return response;
        } catch (Throwable t) {
            AddDocumentAttachmentResponse response = new AddDocumentAttachmentResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage(t.getMessage());
            return response;
        }
    }

    @POST
    @Path("/response")
    @Override
    public GetDocumentQuestionResponse getDocumentQuestionResponse(GetDocumentQuestionResponseRequest request) {
        try {
            GetDocumentQuestionResponse response =  documentService.getDocumentQuestionsResponses(request);
            return response;
        } catch (Throwable t) {
            GetDocumentQuestionResponse response = new GetDocumentQuestionResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage(t.getMessage());
            return response;
        }
    }

    @PUT
    @Path("/response/save")
    @Override
    public UpdateDocumentQuestionResponse addDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) {
        try {
            return documentService.saveDocumentQuestionResponse(request);
        } catch (Throwable t) {
            UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage(t.getMessage());
            return response;
        }
    }

    @POST
    @Path("/response/update")
    @Override
    public UpdateDocumentQuestionResponse updateDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) {
        try {
            return documentService.updateDocumentQuestionResponse(request);
        } catch (Throwable t) {
            UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage(t.getMessage());
            return response;
        }
    }

    @POST
    @Path("/response/delete")
    @Override
    public UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) {
        try {
            return documentService.deleteDocumentQuestionResponse(request);
        } catch (Throwable t) {
            UpdateDocumentQuestionResponse response = new UpdateDocumentQuestionResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage(t.getMessage());
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
    @POST
    @Path("/attachment/getAll")
    @Override
    public GetDocumentAttachmentsResponse getDocumentAttachments(GetDocumentAttachmentRequest request) {
        try {
            GetDocumentAttachmentsResponse response = documentService.getDocumentAttachments(request.getDocumentId());
            return response;
        } catch (Throwable t) {
            GetDocumentAttachmentsResponse response = new GetDocumentAttachmentsResponse(OnTargetConstant.ERROR,
                    t.getMessage());
            return response;
        }
    }


    @POST
    @Path("/getDocumentStats")
    @Override
    public DocumentStatsResponse getDocumentAttachments(DocumentStatsRequest request) {
        try {
           return documentService.getDocumentStatisticsByProject(request.getBaseRequest().getLoggedInUserProjectId());
        } catch (Exception e) {
            logger.error("Error while getting document statistics",e);
            DocumentStatsResponse response = new DocumentStatsResponse();
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while getting document statistics");
            return response;
        }
    }


}
