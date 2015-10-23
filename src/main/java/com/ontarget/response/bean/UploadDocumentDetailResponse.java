package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadedDocumentDetail;
import lombok.Data;

/**
 * Created by sanjeevghimire on 10/23/15.
 */
@Data
public class UploadDocumentDetailResponse extends OnTargetResponse{

    UploadedDocumentDetail documentDetail;
}
