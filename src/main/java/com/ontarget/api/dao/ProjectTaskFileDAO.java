package com.ontarget.api.dao;

import com.ontarget.bean.FileAttachment;

import java.util.List;

/**
 * Created by sumit on 12/9/14.
 */
public interface ProjectTaskFileDAO {
    long saveTaskFile(int taskId, String fileName, int owner, String location) throws Exception;

    public List<FileAttachment> getTaskAttachments(int taskId) throws Exception;
}
