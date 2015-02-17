package com.ontarget.api.service.impl;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.service.TaskPercentageService;
import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskPercentage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/25/14.
 */
@Service
public class TaskPercentageServiceImpl implements TaskPercentageService {

    private Logger logger = Logger.getLogger(TaskPercentageServiceImpl.class);

    @Autowired
    private TaskPercentageDAO taskPercentageDAO;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean addTaskPercentage(List<TaskPercentage> taskPercentageList) throws Exception {
        logger.debug("adding task percentage info : "+ taskPercentageList);

        if(taskPercentageList!=null && taskPercentageList.size() > 0){
            for(TaskPercentage taskPercentage : taskPercentageList){

                //figure if the task for the start date of the month already exists. if exists expire and add a new one.
                TaskPercentage tpFromDatabase = taskPercentageDAO.getExistingTaskPercentageForTheMonth(taskPercentage.getTask().getProjectTaskId());
                if(tpFromDatabase.getId() > 0){
                    boolean expired = taskPercentageDAO.expireTaskPercentage(tpFromDatabase.getId());
                    if(!expired){
                        throw new Exception("Error while expiring task percentage.");
                    }
                }

                int id = taskPercentageDAO.addTaskPercentageComplete(taskPercentage);
                if(id <= 0){
                    throw new Exception("Task Percentage could not be added: "+ taskPercentage);
                }
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean updateTaskPercentage(List<TaskPercentage> taskPercentageList) throws Exception {
        logger.debug("updating task percentage info : "+ taskPercentageList);

        if(taskPercentageList!=null && taskPercentageList.size() > 0){
            for(TaskPercentage taskPercentage : taskPercentageList){
                boolean updated= taskPercentageDAO.updateTaskPercentageComplete(taskPercentage);
                if(!updated){
                    throw new Exception("Task Percentage could not be updated: "+ taskPercentage);
                }
            }
        }
        return true;
    }


    @Override
    public List<TaskPercentage> getTaskPercentageByTask(int taskId) throws Exception{
        logger.debug("Getting list of percentage complete for task: "+ taskId);
        return taskPercentageDAO.getTaskPercentageByTask(taskId);
    }


    @Override
    public Map<TaskDTO,List<TaskPercentage>> getTaskPercentageByProject(int projectId) throws Exception{
        logger.debug("Getting list of percentage complete for project: "+ projectId);
        return taskPercentageDAO.getTaskPercentageCompletes(projectId);
    }

}
