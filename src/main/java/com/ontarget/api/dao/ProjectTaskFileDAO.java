package com.ontarget.api.dao;

/**
 * Created by sumit on 12/9/14.
 */
public interface ProjectTaskFileDAO {
    long saveTaskFile(long taskId, String fileName, long owner, String location) throws Exception;
}
