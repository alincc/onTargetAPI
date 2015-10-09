package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"baseRequest" , "documentId"})
public class GetDocumentQuestionResponseRequest {

    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("documentId")
    public Integer documentId;

}
