package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "project_file_tag_attribute")
public class ProjectFileTagAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_tag_attribute_id", nullable = false)
	private Long projectFileTagAttributeId;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "updated_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User modifiedBy;
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "attribute_key", length = 100)
	private String attributeKey;
	@Column(name = "attribute_value", length = 100)
	private String attributeValue;
	@JoinColumn(name = "project_file_tag_id", referencedColumnName = "project_file_tag_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectFileTag projectFileTag;

	public ProjectFileTagAttribute() {
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileTagAttributeId != null ? projectFileTagAttributeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileTagAttribute)) {
			return false;
		}
		ProjectFileTagAttribute other = (ProjectFileTagAttribute) object;
		if ((this.projectFileTagAttributeId == null && other.projectFileTagAttributeId != null)
				|| (this.projectFileTagAttributeId != null && !this.projectFileTagAttributeId.equals(other.projectFileTagAttributeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileTagAttribute[projectFileTagAttributeId=" + projectFileTagAttributeId + "]";
	}

}
