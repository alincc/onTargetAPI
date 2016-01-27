package com.ontarget.bean;

import com.ontarget.dto.ProfileDTO;

import java.io.Serializable;

/**
 * Created by sumit on 11/24/14.
 */
public class ProjectMember implements Serializable {
	private long projectMemberId;
	private long projectId;
	private long userId;
	private String companyName;
	private String companyAddress;
	private String discipline;
	private String memberStatus;
	private Contact contact;
	private ContactPhone phone;
	private ProfileDTO profileDto;


	public ProjectMember() {
	}

	public long getProjectMemberId() {
		return projectMemberId;
	}

	public void setProjectMemberId(long projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public ContactPhone getPhone() {
		return phone;
	}

	public void setPhone(ContactPhone phone) {
		this.phone = phone;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

}
