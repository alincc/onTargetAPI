package com.ontarget.dto;

import lombok.Data;

import com.ontarget.bean.Contact;

@Data
public class DocumentLink {
	private Integer documentId;
	private Contact adddedBy;
}
