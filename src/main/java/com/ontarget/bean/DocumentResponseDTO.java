package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
public class DocumentResponseDTO implements Serializable{

    private long documentResponseId;
    private String response;
    private String status;
    private UserDTO responsedBy;
    private Date responsedDate;
    private UserDTO modifiedBy;
    private Date modifiedDate;
}
