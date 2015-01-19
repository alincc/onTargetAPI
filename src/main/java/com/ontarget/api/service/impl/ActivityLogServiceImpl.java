package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.bean.ActivityLog;
import com.ontarget.bean.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
@Service
public class ActivityLogServiceImpl implements com.ontarget.api.service.ActivityLogService {

    @Autowired
    private ActivityDAO activityDAO;

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public List<ActivityLog> getActivityLog(long recentId) throws Exception {
        List<ActivityLog> activityLog = activityDAO.getActivityLog(recentId);
        for (ActivityLog log : activityLog) {
            int userId = log.getUserId();
            Contact contact = contactDAO.getContact(userId);
            if (contact != null)
                log.setText(log.getText() + " by " + contact.getFirstName() + " " + contact.getLastName());
        }

        return activityLog;
    }
}
