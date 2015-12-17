package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ontarget.dto.ProjectFilePageDTO;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"baseRequest","projectFilePage","projectFileId"})
@Data
public class ProjectFilePageRequest {

    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @JsonProperty("projectFilePage")
    @NotNull
    private ProjectFilePageDTO projectFilePage;

    @JsonProperty("projectFileId")
    @NotNull
    private Long projectFileId;

}
