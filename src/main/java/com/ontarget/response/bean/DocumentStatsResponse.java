package com.ontarget.response.bean;

import com.ontarget.bean.DocumentStatistic;
import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

import java.util.Map;

/**
 * Created by sanjeevghimire on 12/15/15.
 */
@Data
public class DocumentStatsResponse extends OnTargetResponse{

    Map<String, DocumentStatistic> countByDocumentTemplateAndStatus;

}
