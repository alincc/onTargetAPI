package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sanjeevghimire on 12/15/15.
 */
@Data
public class DocumentStatistic implements Serializable{

    private Long approvedCount = 0L;
    private Long submittedCount = 0L;
    private Long rejectedCount = 0L;
}
