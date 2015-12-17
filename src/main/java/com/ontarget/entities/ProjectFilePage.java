package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
@Entity
@Table(name = "project_file_page")
@Data
public class ProjectFilePage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_file_page_id", nullable = false)
    private Integer projectFilePageId;

    @Basic(optional = false)
    @Column(name = "image_path", nullable = false, length = 255)
    private String imagePath;

    @Basic(optional = false)
    @Column(name = "image_name", nullable = false, length = 255)
    private String imageName;

    @Basic(optional = false)
    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Basic(optional = false)
    @Column(name = "image_type", nullable = false, length = 80)
    private String imageType;

    @Basic(optional = false)
    @Column(name = "zoom_level", nullable = false)
    private Integer zoomLevel;

    @Basic(optional = false)
    @Column(name = "image_size", nullable = false)
    private Double imageSize;

    @Basic(optional = false)
    @Column(name = "image_height", nullable = false)
    private Double imageHeight;

    @Basic(optional = false)
    @Column(name = "image_width", nullable = false)
    private Double imageWidth;

    @JoinColumn(name = "project_file_id", referencedColumnName = "project_file_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectFile projectFile;

}
