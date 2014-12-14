package com.ontarget.dto;

import java.util.Set;

/**
 * Created by Yam on 13-12-2014.
 */
public class UserDisciplineResponse extends OnTargetResponse{
    private Set<Long> discipline;

    public Set<Long> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Set<Long> discipline) {
        this.discipline = discipline;
    }
}
