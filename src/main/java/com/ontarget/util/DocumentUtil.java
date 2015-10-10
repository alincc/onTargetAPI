package com.ontarget.util;

import com.ontarget.bean.DocumentResponseDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.DocumentResponse;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public class DocumentUtil {


    /**
     * Get DocumentResponseDTO from DocumentResponse entity
     * @param documentResponse
     * @return
     */
    public static DocumentResponseDTO getDocumentResponseDTOFromDocumentResponseEntity(DocumentResponse documentResponse){
        DocumentResponseDTO documentResponseDTO=new DocumentResponseDTO();
        documentResponseDTO.setDocumentResponseId(documentResponse.getDocumentResponseId());
        documentResponseDTO.setResponse(documentResponse.getResponse());
        documentResponseDTO.setStatus(documentResponse.getStatus());
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(documentResponse.getResponseBy().getUserId());
        documentResponseDTO.setResponsedBy(userDTO);
        documentResponseDTO.setResponsedDate(documentResponse.getResponseDate());
        return documentResponseDTO;
    }


}
