package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 1/17/15.
 */
public class NoAccidentReport implements Serializable {

    private Double noAccidentDays;

    public Double getNoAccidentDays() {
        return noAccidentDays;
    }

    public void setNoAccidentDays(Double noAccidentDays) {
        this.noAccidentDays = noAccidentDays;
    }
}
