package com.ontarget.request.bean;

import javax.annotation.Generated;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class AssignUserToProjectRequest {
	@NotEmpty
	private String token;
}
