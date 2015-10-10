package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Data
public class ProjectFileTagBean implements Serializable {
	@NotNull
	private Integer projectFileId;
	private Long projectFileTagId;
	private Long parentFileTagId;
	@NotEmpty
	private String tag;
	@NotEmpty
	private String title;
	private float lattitude;
	private float longitude;
	@NotEmpty
	private String tagType;
	private String status;
	private Contact addedBy;
	private Date addedDate;

	@NotNull
	@Valid
	private List<ProjectFileTagAttributeBean> attributes;
}
