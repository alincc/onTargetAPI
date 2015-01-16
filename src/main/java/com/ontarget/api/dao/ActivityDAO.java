package com.ontarget.api.dao;

import com.ontarget.bean.ActivityLog;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityDAO {

    public List<ActivityLog> getActivityLog(long recentId) throws Exception;

}
