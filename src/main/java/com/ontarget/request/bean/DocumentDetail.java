package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "dcoumentId" })
public class DocumentDetail {

	/**
* 
*/
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("dcoumentId")
	private Integer dcoumentId;

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
	 * @return The dcoumentId
	 */
	@JsonProperty("dcoumentId")
	public Integer getDcoumentId() {
		return dcoumentId;
	}

	/**
	 * 
	 * @param dcoumentId
	 *            The dcoumentId
	 */
	@JsonProperty("dcoumentId")
	public void setDcoumentId(Integer dcoumentId) {
		this.dcoumentId = dcoumentId;
	}

}
