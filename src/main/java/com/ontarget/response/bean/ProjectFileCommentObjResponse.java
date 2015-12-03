package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectFileComment;
import lombok.Data;

/**
 * Created by sanjeevghimire on 12/2/15.
 */
@Data
public class ProjectFileCommentObjResponse extends OnTargetResponse{

    private ProjectFileCommentResponse comment;
}
