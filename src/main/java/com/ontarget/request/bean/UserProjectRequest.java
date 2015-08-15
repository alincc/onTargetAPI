package com.ontarget.request.bean;

import javax.validation.constraints.NotNull;

public class UserProjectRequest {

	@NotNull
	private Integer userId;
	@NotNull
	private Integer companyId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
