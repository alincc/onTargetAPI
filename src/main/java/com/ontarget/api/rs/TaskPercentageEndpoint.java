package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskPercentageRequest;

/**
 * Created by Owner on 11/25/14.
 */
public interface TaskPercentageEndpoint {

    public OnTargetResponse addTaskPercentageComplete(TaskPercentageRequest request);

    public OnTargetResponse updateTaskPercentageComplete(TaskPercentageRequest request);


}
