package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.dto.OnTargetResponse;

@Data
public class DocumentFileTagResponse extends OnTargetResponse {
	private List<DocumentFileTagBean> tags;
}
