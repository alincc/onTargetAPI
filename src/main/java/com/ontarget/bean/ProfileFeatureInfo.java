package com.ontarget.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProfileFeatureInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String featureName;
	private String featureKey;
}
