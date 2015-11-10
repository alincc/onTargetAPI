package com.ontarget.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ontarget.request.bean.BaseRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 11/10/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "modifiedBy",  "projectFileId","isConversioinComplete" })
public class UpdateIsConversionCompleteRequest {

    @NotNull
    @Valid
    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("projectFileId")
    private Integer projectFileId;

    @NotEmpty
    @JsonProperty("isConversioinComplete")
    private Boolean isConversioinComplete;


}
