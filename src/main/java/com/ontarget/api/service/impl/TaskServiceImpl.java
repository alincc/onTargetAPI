package com.ontarget.api.service.impl;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private Logger logger = Logger.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean addTaskService(Task task) throws Exception {
        logger.info("Adding task: "+ task);
        int taskId = taskDAO.addTask(task);

        if(taskId == 0){
            throw new Exception("Add task failed.");
        }
        return true;
    }

    @Override
    public List<Task> getTask(int projectId) throws Exception{
        return taskDAO.getTask(projectId);
    }


}
