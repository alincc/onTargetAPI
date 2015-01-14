package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 1/10/15.
 */
public class TimeSaved implements Serializable{

    public TimeSaved() {
    }


    Double timeSavedValue;

    public Double getTimeSavedValue() {
        return timeSavedValue;
    }

    public void setTimeSavedValue(Double timeSavedValue) {
        this.timeSavedValue = timeSavedValue;
    }
}
