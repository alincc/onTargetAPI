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

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "project_file_tag")
public class ProjectFileTag implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_tag_id", nullable = false)
	private Long projectFileTagId;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
	@ManyToOne()
	private User createdBy;
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User modifiedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "tag_title", length = 50, nullable = false)
	private String tagTitle;
	@Column(name = "tag_type", length = 20, nullable = false)
	private String tagType;
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	@Column(name = "tag_file_path", length = 200)
	private String tagFilePath;
	@Column(name = "lattitude", nullable = false)
	private float lattitude;
	@Column(name = "longitude", nullable = false)
	private float longitude;
	@Column(name = "version_no", nullable = false)
	private Integer versionNo;
	@Column(name = "parent_file_tag_id")
	private Long parentFileTagId;
	@JoinColumn(name = "project_file_id", referencedColumnName = "project_file_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectFile projectFile;
	@OneToMany(mappedBy = "projectFileTag", fetch = FetchType.EAGER)
	private List<ProjectFileTagAttribute> projectFileTagAttributes;

	public ProjectFileTag() {
	}

	public ProjectFileTag(Long projectFileTagId) {
		super();
		this.projectFileTagId = projectFileTagId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileTagId != null ? projectFileTagId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileTag)) {
			return false;
		}
		ProjectFileTag other = (ProjectFileTag) object;
		if ((this.projectFileTagId == null && other.projectFileTagId != null)
				|| (this.projectFileTagId != null && !this.projectFileTagId.equals(other.projectFileTagId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileTag[projectFileTagId=" + projectFileTagId + "]";
	}

}
