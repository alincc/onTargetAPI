package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 10/8/15.
 */
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "documentId", "filePath", "addedBy" })
public class DeleteDocumentAttachmentRequest {
    @NotNull
    @Valid
    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;
    @NotNull
    @JsonProperty("documentAttachmentId")
    private Long documentAttachmentId;
}
