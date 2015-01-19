package com.ontarget.dto;

import com.ontarget.bean.Document;

import java.util.List;


public class GetDocumentsResponse extends OnTargetResponse {
    private static final long serialVersionUID = 1L;

    private List<Document> submittals;
    private List<Document> approvals;
    private int totalSubmits, totalApprovals;

    public GetDocumentsResponse() {
        super();
    }

    public GetDocumentsResponse(String returnVal, String returnMessage) {
        super(returnVal, returnMessage);
    }

    public List<Document> getSubmittals() {
        return submittals;
    }

    public void setSubmittals(List<Document> submittals) {
        this.submittals = submittals;
        this.totalSubmits = submittals == null ? 0 : submittals.size();
    }

    public List<Document> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<Document> approvals) {
        this.approvals = approvals;
        this.totalApprovals = approvals == null ? 0 : approvals.size();
    }

    public int getTotalSubmits() {
        return totalSubmits;
    }

    public void setTotalSubmits(int totalSubmits) {
        this.totalSubmits = totalSubmits;
    }

    public int getTotalApprovals() {
        return totalApprovals;
    }

    public void setTotalApprovals(int totalApprovals) {
        this.totalApprovals = totalApprovals;
    }
}
