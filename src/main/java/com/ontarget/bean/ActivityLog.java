package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/6/14.
 */
public class ActivityLog implements Serializable {
	private long id;
	private String text;
	private long category;
	private long tsInsert;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public long getTsInsert() {
		return tsInsert;
	}

	public void setTsInsert(long tsInsert) {
		this.tsInsert = tsInsert;
	}
}
