package com.ontarget.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sanjeevghimire on 1/21/16.
 */
@Data
public class ProjectBimElementToTaskLinkDTO implements Serializable {

    private Integer projectBimFileId;
    private Integer projectTaskId;
    private Long bimElelmentId;

}
