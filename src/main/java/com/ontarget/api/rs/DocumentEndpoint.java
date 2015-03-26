package com.ontarget.api.rs;

import javax.validation.Valid;

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

import javax.ws.rs.GET;
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
}
