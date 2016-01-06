package com.ontarget.request.bean;

import java.sql.Date;

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
@JsonPropertyOrder({ "projectId","projectParentId", "projectTypeId", "projectAddress", "companyId", "projectName",
		"projectImagePath", "projectDescription", "status", "startDate", "endDate", "unitOfMeasurement","projectAssetFolderName","projectTopicArn" })
public class ProjectDetailInfo {

	@JsonProperty("projectId")
	private Integer projectId;
	@NotNull
	@JsonProperty("projectParentId")
	private Integer projectParentId;
	@NotNull
	@JsonProperty("projectTypeId")
	private Integer projectTypeId;
	@NotNull
	@Valid
	@JsonProperty("projectAddress")
	private ProjectAddressInfo projectAddress;
	@NotNull
	@JsonProperty("companyId")
	private Integer companyId;
	@NotEmpty
	@JsonProperty("projectName")
	private String projectName;
	@JsonProperty("projectImagePath")
	private String projectImagePath;
	@NotEmpty
	@JsonProperty("projectDescription")
	private String projectDescription;
	@NotEmpty
	@JsonProperty("status")
	private String status;
	@NotNull
	@JsonProperty("startDate")
	private Date startDate;
	@NotNull
	@JsonProperty("endDate")
	private Date endDate;
	@NotEmpty
	@JsonProperty("unitOfMeasurement")
	private String unitOfMeasurement;

    @JsonProperty("projectAssetFolderName")
    private String projectAssetFolderName;

    @JsonProperty("projectTopicArn")
    private String projectTopicArn;

}