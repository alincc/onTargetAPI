package com.ontarget.api.dao.impl;

import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.ProjectTaskFile;
import com.ontarget.bean.TaskComment;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sumit on 12/9/14.
 */
@Repository
public class ProjectTaskFileDAOImpl implements com.ontarget.api.dao.ProjectTaskFileDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public long saveTaskFile(long taskId, String fileName, long owner, String location) throws Exception {
        return jdbcTemplate.update(OnTargetQuery.INSERT_TASK_FILE, new Object[]{taskId, fileName, owner, location});
    }

    @Override
    public List<FileAttachment> getTaskAttachments(long taskId) throws Exception {
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_FILE, new Object[]{taskId});
        List<FileAttachment> attachments = new ArrayList<>();
        if (taskList != null && taskList.size() > 0) {
            for (Map<String, Object> commentMap : taskList) {
                FileAttachment attachment = new FileAttachment();
                attachment.setFileName((String) commentMap.get("file_name"));
                attachment.setLocation((String) commentMap.get("location"));
                attachment.setTaskId((int) commentMap.get("project_task_id"));
                attachment.setUserId((long) commentMap.get("created_by"));
                attachments.add(attachment);
            }
        }

        return attachments;
    }
}
