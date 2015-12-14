package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
@Entity
@Table(name = "user_project_profile")
@Data
public class UserProjectProfile implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_project_profile_id", nullable = false)
    private Integer userProjectProfileId;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    @OneToOne()
    private Profile profile;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne()
    private User user;

    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @OneToOne()
    private Project project;

    @Column(name = "status")
    @Basic(optional = false)
    private String status;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @JoinColumn(name = "modified_by", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User modifiedBy;


}
