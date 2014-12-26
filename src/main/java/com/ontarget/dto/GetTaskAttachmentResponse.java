package com.ontarget.dto;

import com.ontarget.bean.FileAttachment;

import java.util.List;

/**
 * Created by sumit on 12/22/14.
 */
public class GetTaskAttachmentResponse extends OnTargetResponse {
    private long taskId;
    private List<FileAttachment> taskAttachments;

    public List<FileAttachment> getTaskAttachments() {
        return taskAttachments;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public void setTaskAttachments(List<FileAttachment> taskAttachments) {
        this.taskAttachments = taskAttachments;
    }
}
