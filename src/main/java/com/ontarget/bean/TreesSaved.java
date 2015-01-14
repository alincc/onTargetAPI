package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 1/10/15.
 */
public class TreesSaved implements Serializable{

    public TreesSaved() {
    }


    private Double treesSaved;

    public Double getTreesSaved() {
        return treesSaved;
    }

    public void setTreesSaved(Double treesSaved) {
        this.treesSaved = treesSaved;
    }
}
