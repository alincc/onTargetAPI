package com.ontarget.dto;

import java.util.List;

public class FieldWorkerResponse extends OnTargetResponse {

	private static final long serialVersionUID = 1L;
	private List<FieldWorkerInfo> fieldWorkers;

	public List<FieldWorkerInfo> getFieldWorkers() {
		return fieldWorkers;
	}

	public void setFieldWorkers(List<FieldWorkerInfo> fieldWorkers) {
		this.fieldWorkers = fieldWorkers;
	}

}
