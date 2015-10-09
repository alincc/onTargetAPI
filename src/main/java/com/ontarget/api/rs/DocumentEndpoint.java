package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.*;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;

import javax.ws.rs.*;

public interface DocumentEndpoint {

	public AddDocumentResponse addDocument(@Valid AddDocumentRequest request);

	public OnTargetResponse updateDocumentData(
			@Valid UpdateDocumentRequest request);

	public OnTargetResponse updateDocumentStatus(
			@Valid UpdateDocumentStatus request);

	public GetDocumentsResponse getDocuments(@Valid UserDocument userDocument);

	public GetDocumentResponse getDocument(@Valid DocumentDetail documentDetail);

	public OnTargetResponse addDocumentAttachment(
			@Valid AddDocumentAttachment request);

    public AddDocumentAttachmentResponse deleteDocumentAttachment(@Valid DeleteDocumentAttachmentRequest request);

    @POST
    @Path("/document/response")
    GetDocumentQuestionResponse getDocumentQuestionResponse(GetDocumentQuestionResponseRequest request);

    @POST
    @Path("/document/response/add")
    UpdateDocumentQuestionResponse addDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request);

    @POST
    @Path("/response/update")
    UpdateDocumentQuestionResponse updateDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request);

    @POST
    @Path("/response/delete")
    UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request);
}
