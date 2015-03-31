package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "forgot_password_request")
public class ForgotPasswordRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic(optional = false)
    @Column(name = "forgot_password_token", nullable = false, length = 64)
    private String forgotPasswordToken;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 10)
    private String status;
    @Basic(optional = false)
    @Column(name = "ts_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsCreate;
    @Basic(optional = false)
    @Column(name = "ts_expiry", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsExpiry;

    public ForgotPasswordRequest() {
    }

    public ForgotPasswordRequest(Long id) {
        this.id = id;
    }

    public ForgotPasswordRequest(Long id, long userId, String forgotPasswordToken, String status, Date tsCreate, Date tsExpiry) {
        this.id = id;
        this.userId = userId;
        this.forgotPasswordToken = forgotPasswordToken;
        this.status = status;
        this.tsCreate = tsCreate;
        this.tsExpiry = tsExpiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getForgotPasswordToken() {
        return forgotPasswordToken;
    }

    public void setForgotPasswordToken(String forgotPasswordToken) {
        this.forgotPasswordToken = forgotPasswordToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTsCreate() {
        return tsCreate;
    }

    public void setTsCreate(Date tsCreate) {
        this.tsCreate = tsCreate;
    }

    public Date getTsExpiry() {
        return tsExpiry;
    }

    public void setTsExpiry(Date tsExpiry) {
        this.tsExpiry = tsExpiry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForgotPasswordRequest)) {
            return false;
        }
        ForgotPasswordRequest other = (ForgotPasswordRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ontarget.entities.ForgotPasswordRequest[id=" + id + "]";
    }

}
