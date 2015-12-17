package com.ontarget.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
@Data
public class ProjectFilePageDTO {
    private String imagePath;
    private String imageName;
    private Date createdDate;
    private String imageType;
    private Integer zoomLevel;
    private Double imageSize;
    private Double imageHeight;
    private Double imageWidth;
    private Integer projectFilePageId;
}
