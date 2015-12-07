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
@JsonPropertyOrder({"baseRequest", "projectId","poid","projectBimFileLocation,projectBimFileIFCLocation,projectBimFileJSONLocation"})
public class SaveBIMRequest{

    @JsonProperty("baseRequest")
    private BaseRequest baseRequest;

    @NotNull
    @JsonProperty("projectId")
    public Long projectid;

    @JsonProperty("projectBimFileLocation")
    public String projectBimFileLocation;

    @JsonProperty("projectBimFileIFCLocation")
    public String projectBimFileIFCLocation;

    @JsonProperty("projectBimFileJSONLocation")
    public String projectBimFileJSONLocation;



}
