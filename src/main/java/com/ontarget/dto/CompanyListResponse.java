package com.ontarget.dto;

import com.ontarget.bean.Company;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sumit on 12/24/14.
 */
public class CompanyListResponse extends OnTargetResponse {

    private List<Company> companyList;

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }
}
