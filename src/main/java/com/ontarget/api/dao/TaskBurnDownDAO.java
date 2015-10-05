package com.ontarget.api.dao;

import java.math.BigInteger;

public interface TaskBurnDownDAO {

	BigInteger getCompleteTaskOfActivity(Integer activityId, String toDate) throws Exception;

	BigInteger getIncompleteTaskOfActivity(Integer activityId,String toDate) throws Exception;

}
