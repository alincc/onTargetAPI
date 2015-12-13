package com.ontarget.util;

import com.ontarget.bean.DocumentFileTagAttributeBean;
import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;

public class DocumentFileTagUtil {

	public static DocumentFileTagBean getDocumentFileTagBeanFromEntity(ProjectFileTag projectFileTag) {
		DocumentFileTagBean tagBean = new DocumentFileTagBean();
		tagBean.setProjectFileTagId(projectFileTag.getProjectFileTagId());
		tagBean.setTagType(projectFileTag.getTagType());
		tagBean.setTitle(projectFileTag.getTagTitle());
		tagBean.setTagFilePath(projectFileTag.getTagFilePath());
		tagBean.setLattitude(projectFileTag.getLattitude());
		tagBean.setLongitude(projectFileTag.getLongitude());
		tagBean.setStatus(projectFileTag.getStatus());
		tagBean.setParentFileTagId(projectFileTag.getParentFileTagId());
		tagBean.setAddedDate(projectFileTag.getCreatedDate());
		return tagBean;
	}

	public static DocumentFileTagAttributeBean getDocumentFileTagAttributeBeanFromEntity(ProjectFileTagAttribute projectFileTagAttribute) {
		DocumentFileTagAttributeBean projectFileTagAttributeBean = new DocumentFileTagAttributeBean();
		projectFileTagAttributeBean.setProjectFileTagAttributeId(projectFileTagAttribute.getProjectFileTagAttributeId());
		projectFileTagAttributeBean.setKey(projectFileTagAttribute.getAttributeKey());
		projectFileTagAttributeBean.setValue(projectFileTagAttribute.getAttributeValue());
		return projectFileTagAttributeBean;
	}

}
