package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 9/18/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId","projectFileId" })
public class ProjectFileRequest {

    @NotNull
    @Valid
    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;
    @NotNull
    @JsonProperty("projectId")
    private Integer projectId;
    @NotNull
    @JsonProperty("projectFileId")
    private Integer projectFileId;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectFileId() {
        return projectFileId;
    }

    public void setProjectFileId(Integer projectFileId) {
        this.projectFileId = projectFileId;
    }
}
