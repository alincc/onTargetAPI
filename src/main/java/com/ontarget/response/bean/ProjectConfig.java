package com.ontarget.response.bean;

import java.io.Serializable;

public class ProjectConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private String configKey;
	private String configValue;

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

}
