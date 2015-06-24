package com.ontarget.dto;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.Email;

/**
 * Created by Owner on 11/22/14.
 */
public class UserProfileResponse extends OnTargetResponse {

    public UserProfileResponse() {
    }

    private Company company;

    private Contact contact;

    private Email email;

    private ContactPhone phone;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
