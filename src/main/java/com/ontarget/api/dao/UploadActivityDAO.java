package com.ontarget.api.dao;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ActivityInfo;
import com.ontarget.entities.TaskPriority;
import com.ontarget.request.bean.ActivityTaskRecord;

public interface UploadActivityDAO {

	public boolean createActivity(List<ActivityInfo> activityInfoList, List<ActivityTaskRecord> invalidActivityRecords, String filename,
			int userId, int projectId) throws Exception;

	public Map<String, TaskPriority> getTaskPriorityMap();

}
