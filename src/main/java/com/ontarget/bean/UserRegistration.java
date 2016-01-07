package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sumit on 12/1/14.
 */
@Data
public class UserRegistration implements Serializable {

	private String registrationToken;
	private int projectId ;
	private String firstName;
	private String email;
	private String lastName;
	private String status;
	private String discipline;
	private long tsCreate = Long.MIN_VALUE;

	private String password;
	private int userId;
    private String phoneNumber;
	private String companyName;
	private String companyAddress1;
	private String companyAddress2;
	private String companyCity;
	private String companyState;
	private String companyZip;
	private String companyCountry;
	private int companyTypeId;
	private String companyWebsite;
	private int companyId;
	private String companyLogoPath;
	private Integer invitedProjectId;

}
