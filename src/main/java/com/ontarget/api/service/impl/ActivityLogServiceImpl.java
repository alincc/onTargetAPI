package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.bean.ActivityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
@Service
public class ActivityLogServiceImpl implements com.ontarget.api.service.ActivityLogService {

    @Autowired
    private ActivityDAO activityDAO;

    @Override
    public List<ActivityLog> getActivityLog(long recentId) throws Exception {
        return activityDAO.getActivityLog(recentId);
    }
}
