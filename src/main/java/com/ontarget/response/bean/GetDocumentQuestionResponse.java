package com.ontarget.response.bean;

import com.ontarget.bean.DocumentResponseDTO;
import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
public class GetDocumentQuestionResponse extends OnTargetResponse{

    public Long documentId;

    public List<DocumentResponseDTO> documentResponses;

}
