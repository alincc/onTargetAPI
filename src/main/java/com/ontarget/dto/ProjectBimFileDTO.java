package com.ontarget.dto;

import com.ontarget.bean.Contact;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Data
public class ProjectBimFileDTO implements Serializable{

    private int projectBimFileId;
    private long poid;
    private Date createdDate;
    private Contact createdByContact;
    private String bimThumbnailPath;
    private String bimProjectIFCFilePath;
    private String bimProjectJSONFilePath;

}
