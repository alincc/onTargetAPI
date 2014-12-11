package com.ontarget.api.dao.impl;

import com.ontarget.bean.ProjectTaskFile;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

}
