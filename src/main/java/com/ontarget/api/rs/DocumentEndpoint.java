package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.*;
import com.ontarget.request.bean.*;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
}
