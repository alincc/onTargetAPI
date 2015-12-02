package com.ontarget.response.bean;

import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

/**
 * Created by sanjeevghimire on 12/2/15.
 */
@Data
public class ProjectBimFileCommentResponse extends OnTargetResponse{

    public ProjectBIMFileCommentDTO projectBIMFileComment;
}
