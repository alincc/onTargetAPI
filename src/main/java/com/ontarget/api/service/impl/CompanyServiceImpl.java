package com.ontarget.api.service.impl;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumit on 12/24/14.
 */
@Service
public class CompanyServiceImpl implements com.ontarget.api.service.CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<Company> getCompanyList() throws Exception {
        return companyDAO.getCompanyList();
    }
}
