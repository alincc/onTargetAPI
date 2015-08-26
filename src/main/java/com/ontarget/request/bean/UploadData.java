package com.ontarget.request.bean;

import lombok.Data;

@Data
public class UploadData {
	private String name;
	private String description;
	private String license;
	private String svnURL;
	private String homepage;
}
