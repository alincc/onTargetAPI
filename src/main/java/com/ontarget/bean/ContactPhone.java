package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 12/9/14.
 */
public class ContactPhone implements Serializable{

    private int phoneId;
    private int areaCode;
    private String phoneNumber;
    private String phoneType;
    private String status;

    public ContactPhone() {
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContactPhone{" +
                "phoneId=" + phoneId +
                ", areaCode=" + areaCode +
                ", phoneNumber=" + phoneNumber +
                ", phoneType='" + phoneType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
