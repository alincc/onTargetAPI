package com.ontarget.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProjectFileTagAttributeBean implements Serializable {
	@NotEmpty
	private String key;
	@NotEmpty
	private String value;
	private Long projectFileTagAttributeId;

}
