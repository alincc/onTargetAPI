package com.ontarget.dto;

import com.ontarget.bean.DocumentDTO;

import java.util.List;


public class GetDocumentsResponse extends OnTargetResponse {
    private static final long serialVersionUID = 1L;

    private List<DocumentDTO> submittals;
    private List<DocumentDTO> approvals;
    private int totalSubmits, totalApprovals;

    public GetDocumentsResponse() {
        super();
    }

    public GetDocumentsResponse(String returnVal, String returnMessage) {
        super(returnVal, returnMessage);
    }

    public List<DocumentDTO> getSubmittals() {
        return submittals;
    }

    public void setSubmittals(List<DocumentDTO> submittals) {
        this.submittals = submittals;
        this.totalSubmits = submittals == null ? 0 : submittals.size();
    }

    public List<DocumentDTO> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<DocumentDTO> approvals) {
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
