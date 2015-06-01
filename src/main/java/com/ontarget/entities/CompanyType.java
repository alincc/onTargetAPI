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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "company_type")
public class CompanyType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "company_type_id", nullable = false)
	private Integer companyTypeId;
	@Basic(optional = false)
	@Column(name = "company_type_name", nullable = false, length = 255)
	private String companyTypeName;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "created_by", length = 20)
	private String createdBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;
	@Column(name = "deleted_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;
	@Column(name = "delete_flag", columnDefinition = "TINYINT")
	private Short deleteFlag;
	@Column(name = "deleted_by", length = 20)
	private String deletedBy;
	@Basic(optional = false)
	@Column(name = "status", nullable = false, length = 10)
	private String status;
	@OneToMany(mappedBy = "companyType", fetch = FetchType.LAZY)
	private List<CompanyInfo> companyInfoList;

	public CompanyType() {
	}

	public CompanyType(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public CompanyType(Integer companyTypeId, String companyTypeName, String status) {
		this.companyTypeId = companyTypeId;
		this.companyTypeName = companyTypeName;
		this.status = status;
	}

	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Short getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CompanyInfo> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyInfo> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (companyTypeId != null ? companyTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CompanyType)) {
			return false;
		}
		CompanyType other = (CompanyType) object;
		if ((this.companyTypeId == null && other.companyTypeId != null)
				|| (this.companyTypeId != null && !this.companyTypeId.equals(other.companyTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.CompanyType[companyTypeId=" + companyTypeId + "]";
	}

}
