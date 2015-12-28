package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Data
@Entity
@Table(name = "user_device")
public class UserDevice implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_device_id", nullable = false)
    private Integer userDeviceId;

    @Basic(optional = false)
    @Column(name = "device_uuid", length = 255)
    private String deviceUUID;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Basic(optional = false)
    @Column(name = "device_type", length = 45)
    private String deviceType;

    @Basic(optional = false)
    @Column(name = "platform", length = 45)
    private String platform;

    @Basic(optional = false)
    @Column(name = "platform_version", length = 45)
    private String platform_version;

    @Basic(optional = false)
    @Column(name = "endpoint_arn", length = 255)
    private String endpointArn;

    @Basic(optional = false)
    @Column(name = "status", length = 255)
    private String status;

}
