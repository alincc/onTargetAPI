package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"baseRequest" , "projectBimFileId"})
public class GetBimProjectRequest {

    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("projectId")
    public Long projectBimFileId;


}
