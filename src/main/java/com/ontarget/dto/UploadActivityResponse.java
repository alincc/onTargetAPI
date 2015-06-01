package com.ontarget.dto;

import java.util.List;

import com.ontarget.request.bean.ActivityTaskRecord;

public class UploadActivityResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ActivityTaskRecord> invalidActivityRecords;

	public UploadActivityResponse() {
		super();
	}

	public UploadActivityResponse(String returnVal, String returnMessage) {
		super(returnVal, returnMessage);
	}

	public List<ActivityTaskRecord> getInvalidActivityRecords() {
		return invalidActivityRecords;
	}

	public void setInvalidActivityRecords(List<ActivityTaskRecord> invalidActivityRecords) {
		this.invalidActivityRecords = invalidActivityRecords;
	}

}
