package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"baseRequest", "projectId","projectBimFileLocation,projectBimFileIFCLocation,projectBimFileJSONLocation,isIfcFileConversionComplete,name,description,projectBimFileId"})
public class SaveBIMRequest{

    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("projectId")
    private Long projectid;

    @JsonProperty("projectBimFileLocation")
    private String projectBimFileLocation;

    @JsonProperty("projectBimFileIFCLocation")
    private String projectBimFileIFCLocation;

    @JsonProperty("projectBimFileJSONLocation")
    private String projectBimFileJSONLocation;

    @JsonProperty("isIfcFileConversionComplete")
    private String isIfcFileConversionComplete;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("projectBimFileId")
    private int projectBimFileId;

}
