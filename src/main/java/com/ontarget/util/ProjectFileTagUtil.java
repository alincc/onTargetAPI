package com.ontarget.util;

import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;

public class ProjectFileTagUtil {

	public static ProjectFileTagBean getProjectFileTagBeanFromEntity(ProjectFileTag projectFileTag) {
		ProjectFileTagBean tagBean = new ProjectFileTagBean();
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

	public static ProjectFileTagAttributeBean getProjectFileTagAttributeBeanFromEntity(ProjectFileTagAttribute projectFileTagAttribute) {
		ProjectFileTagAttributeBean projectFileTagAttributeBean = new ProjectFileTagAttributeBean();
		projectFileTagAttributeBean.setProjectFileTagAttributeId(projectFileTagAttribute.getProjectFileTagAttributeId());
		projectFileTagAttributeBean.setKey(projectFileTagAttribute.getAttributeKey());
		projectFileTagAttributeBean.setValue(projectFileTagAttribute.getAttributeValue());
		return projectFileTagAttributeBean;
	}
}
