package com.ontarget.response.bean;


import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.TaskComment;
import lombok.Data;

/**
 * Created by sanjeevghimire on 12/2/15.
 */
@Data
public class TaskCommentResponse extends OnTargetResponse{

    public TaskComment taskComment;


}
