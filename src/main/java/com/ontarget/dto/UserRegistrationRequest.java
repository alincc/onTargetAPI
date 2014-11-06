package com.ontarget.dto;

import java.io.Serializable;

/**
 * Created by Owner on 10/30/14.
 */
public class UserRegistrationRequest implements Serializable {

    private int registrationReqId;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;
    private String msg;
    private String status;

    public UserRegistrationRequest() {
    }

    public int getRegistrationReqId() {
        return registrationReqId;
    }
    public void setRegistrationReqId(int registrationReqId) {
        this.registrationReqId = registrationReqId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}