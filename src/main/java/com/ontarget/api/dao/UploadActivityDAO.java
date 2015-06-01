package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.ActivityInfo;
import com.ontarget.request.bean.ActivityTaskRecord;

public interface UploadActivityDAO {

	public boolean createActivity(List<ActivityInfo> activityInfoList,List<ActivityTaskRecord> invalidActivityRecords,String filename, int userId, int projectId) throws Exception;

}
