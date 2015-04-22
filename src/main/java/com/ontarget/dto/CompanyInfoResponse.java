package com.ontarget.dto;

import com.ontarget.bean.Company;

public class CompanyInfoResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
