package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 1/19/16.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class ProjectBimFileElementToTaskLinkRequest {

    @NotNull
    @Valid
    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("bimFileId")
    private Long bimFileId;

    @NotNull
    @JsonProperty("bimFileElementId")
    private Long bimFileElementId;

    @NotNull
    @JsonProperty("taskId")
    private Long taskId;

}
