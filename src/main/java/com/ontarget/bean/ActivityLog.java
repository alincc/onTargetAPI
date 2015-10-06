package com.ontarget.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by sumit on 12/6/14.
 */
@Data
public class ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private long activityLogId;
	private String text;
	private long tsInsert;
	private String userImage;
	private String activityType;
	private String action;
}
