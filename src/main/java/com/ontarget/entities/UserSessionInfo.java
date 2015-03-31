package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_session_info")
public class UserSessionInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_session_info_id", nullable = false)
	private Integer userSessionInfoId;
	@Basic(optional = false)
	@Column(name = "login_token", nullable = false, length = 255)
	private String loginToken;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "expire_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expireDate;
	@Basic(optional = false)
	@Column(name = "is_expired", nullable = false, length = 2)
	private String isExpired;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;

	public UserSessionInfo() {
	}

	public UserSessionInfo(Integer userSessionInfoId) {
		this.userSessionInfoId = userSessionInfoId;
	}

	public UserSessionInfo(Integer userSessionInfoId, String loginToken,
			Date createdDate, String isExpired) {
		this.userSessionInfoId = userSessionInfoId;
		this.loginToken = loginToken;
		this.createdDate = createdDate;
		this.isExpired = isExpired;
	}

	public Integer getUserSessionInfoId() {
		return userSessionInfoId;
	}

	public void setUserSessionInfoId(Integer userSessionInfoId) {
		this.userSessionInfoId = userSessionInfoId;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userSessionInfoId != null ? userSessionInfoId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserSessionInfo)) {
			return false;
		}
		UserSessionInfo other = (UserSessionInfo) object;
		if ((this.userSessionInfoId == null && other.userSessionInfoId != null)
				|| (this.userSessionInfoId != null && !this.userSessionInfoId
						.equals(other.userSessionInfoId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserSessionInfo[userSessionInfoId="
				+ userSessionInfoId + "]";
	}

}
