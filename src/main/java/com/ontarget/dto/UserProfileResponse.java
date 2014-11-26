package com.ontarget.dto;

import com.ontarget.bean.Company;

/**
 * Created by Owner on 11/22/14.
 */
public class UserProfileResponse extends OnTargetResponse {

    public UserProfileResponse() {
    }

    private Company company;


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
