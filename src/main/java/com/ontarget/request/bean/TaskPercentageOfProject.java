package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId" })
public class TaskPercentageOfProject {

	/**
* 
*/
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("projectId")
	private Integer projectId;
		
	/**
	 * 
	 * @return The baseRequest
	 */
	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	/**
	 * 
	 * @param baseRequest
	 *            The baseRequest
	 */
	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	/**
	 * 
	 * @return The projectId
	 */
	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * 
	 * @param projectId
	 *            The projectId
	 */
	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
