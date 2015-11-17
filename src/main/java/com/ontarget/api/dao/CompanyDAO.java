package com.ontarget.api.dao;

import com.ontarget.bean.Company;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.request.bean.CompanyEditInfo;

import java.util.List;

/**
 * Created by Owner on 11/5/14.
 */
public interface CompanyDAO {

	public int addCompanyInfo(Company company, int userId) throws Exception;

	public boolean update(CompanyEditInfo company, int modifiedBy) throws Exception;

	public Company getCompany(int companyId) throws Exception;

	public java.util.Map<String, Object> getCompanyByUser(int userId) throws Exception;

	public List<Company> getCompanyList() throws Exception;

	public CompanyInfo getCompanyInfo(int companyId) throws Exception;
}
