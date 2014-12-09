package com.ontarget.api.dao;

/**
 * Created by sumit on 12/9/14.
 */
public interface ProjectTaskFileDAO {
    boolean saveTaskFile(String taskId, String fileName, long owner) throws Exception;
}
