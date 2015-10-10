package com.ontarget.response.bean;

import com.ontarget.bean.DocumentResponseDTO;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.DocumentResponse;
import lombok.Data;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
public class UpdateDocumentQuestionResponse extends OnTargetResponse{

    public DocumentResponseDTO response;
}
