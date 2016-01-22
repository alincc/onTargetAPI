package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectBimElementToTaskLinkDTO;
import lombok.Data;

/**
 * Created by sanjeevghimire on 1/19/16.
 */
@Data
public class ProjectBimFileElementTaskLinkResponse extends OnTargetResponse{

   private ProjectBimElementToTaskLinkDTO projectBimElementToTaskLinkDTO;


}
