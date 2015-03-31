package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_name" }) })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	@Column(name = "user_name", length = 50)
	private String userName;
	@Column(name = "password", columnDefinition = "TEXT")
	private String password;
	@Column(name = "salt", columnDefinition = "TEXT")
	private String salt;
	@Column(name = "user_status", length = 2)
	private String userStatus;
	@Basic(optional = false)
	@Column(name = "discipline", nullable = false)
	private long discipline;
	@Column(name = "number_of_login")
	private Integer numberOfLogin;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "account_status", length = 45)
	private String accountStatus;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Contact> contactList;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserSessionInfo> userSessionInfoList;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<ProjectMember> projectMemberList;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<DocumentSubmittal> documentSubmittalList;
	@JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
	@ManyToOne
	private UserType userType;

	public User() {
	}

	public User(Integer userId) {
		this.userId = userId;
	}

	public User(Integer userId, String password, String salt, long discipline) {
		this.userId = userId;
		this.password = password;
		this.salt = salt;
		this.discipline = discipline;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public long getDiscipline() {
		return discipline;
	}

	public void setDiscipline(long discipline) {
		this.discipline = discipline;
	}

	public Integer getNumberOfLogin() {
		return numberOfLogin;
	}

	public void setNumberOfLogin(Integer numberOfLogin) {
		this.numberOfLogin = numberOfLogin;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<UserSessionInfo> getUserSessionInfoList() {
		return userSessionInfoList;
	}

	public void setUserSessionInfoList(List<UserSessionInfo> userSessionInfoList) {
		this.userSessionInfoList = userSessionInfoList;
	}

	public List<ProjectMember> getProjectMemberList() {
		return projectMemberList;
	}

	public void setProjectMemberList(List<ProjectMember> projectMemberList) {
		this.projectMemberList = projectMemberList;
	}

	public List<DocumentSubmittal> getDocumentSubmittalList() {
		return documentSubmittalList;
	}

	public void setDocumentSubmittalList(List<DocumentSubmittal> documentSubmittalList) {
		this.documentSubmittalList = documentSubmittalList;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.User[userId=" + userId + "]";
	}

}
