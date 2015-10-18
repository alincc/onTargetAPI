package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Data
@Entity
@Table(name = "project_bim_file")
public class ProjectBimFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_bim_file_id", nullable = false)
	private Integer projectBimFileId;

	@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
	@ManyToOne(optional = false)
	private Project project;

	@Column(name = "bim_poid")
	private BigInteger bimPoid;

	@Column(name = "bim_thumb_file_loc")
	private String bimThumbnailFileLocation;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;

	@Basic(optional = false)
	@Column(name = "status", nullable = false, length = 10)
	private String status;

	public ProjectBimFile() {
		super();
	}

	public ProjectBimFile(Integer projectBimFileId) {
		super();
		this.projectBimFileId = projectBimFileId;
	}

}
