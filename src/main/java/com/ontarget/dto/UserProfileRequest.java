package com.ontarget.dto;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.User;

import java.io.Serializable;

/**
 * Created by Owner on 11/4/14.
 */
public class UserProfileRequest implements Serializable{

    private Contact contact;
    private Company company;
    private User user;

    public UserProfileRequest() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfileRequest{" +
                "contact=" + contact +
                ", company=" + company +
                ", user=" + user +
                '}';
    }
}
