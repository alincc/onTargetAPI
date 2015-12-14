package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	private Integer userStatus;
	@JoinColumn(name = "discipline", referencedColumnName = "id")
	@ManyToOne
	private Discipline discipline;
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
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
	private Email email;

	public User() {
	}

	public User(Integer userId) {
		this.userId = userId;
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

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
