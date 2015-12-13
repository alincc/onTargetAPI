package com.ontarget.bean;

import java.io.Serializable;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Data
public class DocumentFileTagAttributeBean implements Serializable {
	@NotEmpty
	private String key;
	@NotEmpty
	private String value;
	private Long projectFileTagAttributeId;

}
