package com.ontarget.api.service;

import com.ontarget.bean.Company;

import java.util.List;

/**
 * Created by sumit on 12/24/14.
 */
public interface CompanyService {
    List<Company> getCompanyList() throws Exception;
}
