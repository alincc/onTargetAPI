package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectBimFile;
import lombok.Data;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Data
public class SaveBIMResponse extends OnTargetResponse {

    private ProjectBimFile projectBimFile;

}
