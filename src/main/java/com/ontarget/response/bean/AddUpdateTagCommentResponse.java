package com.ontarget.response.bean;

import com.ontarget.bean.CommentDTO;
import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

/**
 * Created by sanjeevghimire on 10/21/15.
 */
@Data
public class AddUpdateTagCommentResponse extends OnTargetResponse {

    public CommentDTO commentDTO;
}
