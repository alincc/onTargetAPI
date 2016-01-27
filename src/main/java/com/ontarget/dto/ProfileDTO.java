package com.ontarget.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by TRON on 1/27/2016.
 */

@Data
public class ProfileDTO implements Serializable {

    private String profileCode;

    private String profileName;

}
