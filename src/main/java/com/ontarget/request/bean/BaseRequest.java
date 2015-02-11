package com.ontarget.request.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "loggedInUserId", "loggedInUserprojectId" })
public class BaseRequest {
	@JsonProperty("loggedInUserId")
	private Integer loggedInUserId;
	@JsonProperty("loggedInUserprojectId")
	private Integer loggedInUserprojectId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The loggedInUserId
	 */
	@JsonProperty("loggedInUserId")
	public Integer getLoggedInUserId() {
		return loggedInUserId;
	}

	/**
	 * 
	 * @param loggedInUserId
	 *            The loggedInUserId
	 */
	@JsonProperty("loggedInUserId")
	public void setLoggedInUserId(Integer loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	/**
	 * 
	 * @return The loggedInUserprojectId
	 */
	@JsonProperty("loggedInUserprojectId")
	public Integer getLoggedInUserprojectId() {
		return loggedInUserprojectId;
	}

	/**
	 * 
	 * @param loggedInUserprojectId
	 *            The loggedInUserprojectId
	 */
	@JsonProperty("loggedInUserprojectId")
	public void setLoggedInUserprojectId(Integer loggedInUserprojectId) {
		this.loggedInUserprojectId = loggedInUserprojectId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
