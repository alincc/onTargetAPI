package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectBimFileDTO;
import com.ontarget.entities.ProjectBimFile;
import lombok.Data;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Data
public class GetBIMResponse extends OnTargetResponse{

    public Long projectId;
    public List<ProjectBimFileDTO> bimProjects;

}
