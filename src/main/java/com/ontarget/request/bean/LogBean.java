package com.ontarget.request.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LogBean {
	@NotNull
	@Min(5)
	private Long recentId;

	public LogBean() {
		super();
	}

	public Long getRecentId() {
		return recentId;
	}

	public void setRecentId(Long recentId) {
		this.recentId = recentId;
	}

}
