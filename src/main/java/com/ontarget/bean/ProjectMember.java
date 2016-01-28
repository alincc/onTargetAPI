package com.ontarget.bean;

import com.ontarget.dto.ProfileDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by sumit on 11/24/14.
 */
@Data
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
	private ProfileDTO profile;

}
