package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "recentId", "userId" })
public class NotificationRequestBean {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("recentId")
	private Integer recentId;
	@JsonProperty("userId")
	private Integer userId;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("recentId")
	public Integer getRecentId() {
		return recentId;
	}

	@JsonProperty("recentId")
	public void setRecentId(Integer recentId) {
		this.recentId = recentId;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
