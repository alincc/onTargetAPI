package com.ontarget.api.dao;

import com.ontarget.bean.Company;

/**
 * Created by Owner on 11/5/14.
 */
public interface CompanyDAO {

    public int addCompanyInfo(Company company) throws Exception;

    public Company getCompany(int companyId) throws Exception;

}
