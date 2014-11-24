package com.ontarget.api.dao;

import com.ontarget.bean.TaskEstimatedCost;

/**
 * Created by Owner on 11/17/14.
 */
public interface TaskEstimatedCostDAO {


    public int addPlannedAcutalCost(TaskEstimatedCost cost) throws Exception;

    public boolean updatePlannedActualCost(TaskEstimatedCost cost) throws Exception;
}
