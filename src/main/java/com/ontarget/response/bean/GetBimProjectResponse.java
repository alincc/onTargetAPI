package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectBimFileDTO;
import lombok.Data;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
@Data
public class GetBimProjectResponse extends OnTargetResponse{

    private ProjectBimFileDTO projectBimFileDTO;
}
