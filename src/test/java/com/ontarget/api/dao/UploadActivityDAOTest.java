package com.ontarget.api.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.ActivityInfo;
import com.ontarget.bean.ActivityTaskInfo;
import com.ontarget.request.bean.ActivityTaskRecord;

public class UploadActivityDAOTest extends BaseTest {
	@Autowired
	@Qualifier("uploadActivityJpaDAOImpl")
	private UploadActivityDAO uploadActivityDAO;

	@Test
	public void createActivity() {
		String filename = "OnFile.xlsx";
		int projectId = 1;
		int userId = 1;
		List<ActivityTaskRecord> activityTaskRecords = new ArrayList<ActivityTaskRecord>();
		for (int i = 1; i <= 3; i++) {
			ActivityTaskRecord activityTaskRecord = new ActivityTaskRecord();
			activityTaskRecord.setIndex(String.valueOf(i));
			int index = i;
			if (i < 3) {
				// index = 1;
			}
			activityTaskRecord.setActivityCode("ACT-00" + index);
			activityTaskRecord.setActivityName("activity" + index);
			activityTaskRecord.setActivityStartDate("17/04/2015");
			activityTaskRecord.setActivityEndDate("17/06/2015");

			activityTaskRecord.setTaskCode("TASK-00" + i);
			activityTaskRecord.setTaskName("task" + i);
			activityTaskRecord.setTaskStartDate("17/04/2015");
			activityTaskRecord.setTaskEndDate("17/06/2015");
			activityTaskRecord.setActualCost("500");
			activityTaskRecord.setEstimatedCost("200");
			activityTaskRecord.setPercentageComplete("20");
			activityTaskRecord.setPriority("HIGH");
			activityTaskRecords.add(activityTaskRecord);
		}

		List<ActivityInfo> activityInfoList = new ArrayList<>();
		ActivityInfo activityInfo = new ActivityInfo();
		activityInfo.setActivityCode("ACT-001");
		activityInfo.setActivityCode("ACT-001");
		activityInfo.setActivityName("activity1");
		activityInfo.setStartDate("17/04/2015");
		activityInfo.setEndDate("17/06/2015");

		ActivityTaskInfo activityTaskInfo = new ActivityTaskInfo();
		activityTaskInfo.setTaskCode("TASK-001");
		activityTaskInfo.setTaskName("task1");
		activityTaskInfo.setStartDate("17/04/2015");
		activityTaskInfo.setEndDate("17/06/2015");
		activityTaskInfo.setActualCost("500");
		activityTaskInfo.setEstimatedCost("200");
		activityTaskInfo.setPercentageComplete("20");
		activityTaskInfo.setPriority(1);
		activityTaskInfo.setIndex("1");

		List<ActivityTaskInfo> taskList = new ArrayList<>();
		taskList.add(activityTaskInfo);
		activityInfo.setTaskList(taskList);

		try {
			boolean uploaded = uploadActivityDAO.createActivity(activityInfoList, activityTaskRecords, filename, userId,
					projectId);
			Assert.assertTrue(uploaded);
		} catch (Exception e) {
			logger.error("Error while uploading activity", e);
			fail();
		}
	}

}
