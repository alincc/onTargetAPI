package com.ontarget.dto;

import java.util.List;

/**
 * Created by sumit on 1/20/15.
 */
public class ListResponse<T> extends OnTargetResponse {
    List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
