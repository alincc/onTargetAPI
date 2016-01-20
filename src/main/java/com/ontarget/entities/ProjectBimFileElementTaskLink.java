package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by TRON on 1/18/2016.
 */

@Data
@Entity
@Table(name="project_bim_file_element_task_link")
public class ProjectBimFileElementTaskLink implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_bim_file_element_task_link_id", nullable = false)
    private long projectBimFileElementTaskLinkId;


    @JoinColumn(name = "project_bim_file_id", referencedColumnName = "project_bim_file_id", nullable = false)
    @ManyToOne(optional = false)
    private ProjectBimFile projectBimFile;

    @Column(name = "element_id", nullable = false)
    private long elementId;

    @JoinColumn(name = "task_id", referencedColumnName = "project_task_id", nullable = false)
    @ManyToOne(optional = false)
    private ProjectTask projectTask;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private  Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
    @ManyToOne()
    private User createdBy;

    @JoinColumn(name = "modified_by", referencedColumnName = "user_id")
    @ManyToOne()
    private User modifiedBy;

}
