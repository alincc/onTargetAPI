package com.ontarget.dto;

import java.io.Serializable;

/**
 * Created by TRON on 1/20/2016.
 */
public class ProjectBimFileElementTaskLinkDTO implements Serializable {

    private long projectBimFileElementTaskLinkId;
    private ProjectBimFile projectBimFile;
    private long elementId;
    private ProjectTask projectTask;
    private  Date createdDate;
    private Date modifiedDate;
    private String status;
    private User createdBy;
    private User modifiedBy;

}
