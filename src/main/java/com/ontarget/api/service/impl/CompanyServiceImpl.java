package com.ontarget.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.bean.Company;
import com.ontarget.request.bean.CompanyInfoRequest;

/**
 * Created by sumit on 12/24/14.
 */
@Service
public class CompanyServiceImpl implements com.ontarget.api.service.CompanyService {

	@Autowired
	@Qualifier("companyJpaDAOImpl")
	private CompanyDAO companyDAO;

	@Override
	public List<Company> getCompanyList() throws Exception {
		return companyDAO.getCompanyList();
	}
	
	public Company getCompanyInfo(CompanyInfoRequest request) throws Exception{
		return companyDAO.getCompany(request.getCompanyId());
	}
}
