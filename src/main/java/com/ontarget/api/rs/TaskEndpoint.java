package com.ontarget.api.rs;

import com.ontarget.bean.Task;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

    public OnTargetResponse addTask(Task task);
}
