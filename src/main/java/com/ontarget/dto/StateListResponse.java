package com.ontarget.dto;

import java.util.Set;

/**
 * Created by Yam on 10-12-2014.
 */
public class StateListResponse extends OnTargetResponse {
    private Set<Long> stateId;

    public Set<Long> getStateId() {
        return stateId;
    }

    public void setStateId(Set<Long> stateId) {
        this.stateId = stateId;
    }
}
