package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

import com.ontarget.dto.DocumentLink;
import com.ontarget.dto.TaskLink;

@Data
public class DocumentFileTagBean implements Serializable {
	@NotNull
	private Integer documentId;
	private Long projectFileTagId;
	private Long parentFileTagId;
	@NotEmpty
	private String title;
	private float lattitude;
	private float longitude;
	@NotEmpty
	private String tagType;
	private String tagFilePath;
	private String status;
	private Contact addedBy;
	private Date addedDate;

	@NotNull
	@Valid
	private List<DocumentFileTagAttributeBean> attributes;

	private List<CommentDTO> comment;

}
