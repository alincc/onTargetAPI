package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId", "name", "fileType", "createdBy", "modifiedBy", "categoryId", "description", "projectFileId","parentProjectFileId","isConversionComplete","thumbnailImageName" })
public class UploadDocumentRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotEmpty
	@JsonProperty("name")
	private String name;
	@NotEmpty
	@JsonProperty("fileType")
	private String fileType;
	@NotNull
	@JsonProperty("createdBy")
	private Integer createdBy;
	@NotNull
	@JsonProperty("modifiedBy")
	private Integer modifiedBy;
	@NotNull
	@JsonProperty("categoryId")
	private Integer categoryId;

    @NotEmpty
	@JsonProperty("filePath")
	private String filePath;


    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("projectFileId")
    private Integer projectFileId;

    @NotNull
    @JsonProperty("parentProjectFileId")
    private Integer parentProjectFileId;

    @NotNull
    @JsonProperty("isConversionComplete")
    private Boolean isConversionComplete;

    @NotEmpty
    @JsonProperty("thumbnailImageName")
    private String thumbnailImageName;

}
