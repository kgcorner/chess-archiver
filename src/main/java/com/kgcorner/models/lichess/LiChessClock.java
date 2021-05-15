package com.kgcorner.models.lichess;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

@Generated("jsonschema2pojo")
public class LiChessClock {
    @SerializedName("initial")
    @Expose
    private Integer initial;
    @SerializedName("increment")
    @Expose
    private Integer increment;
    @SerializedName("totalTime")
    @Expose
    private Integer totalTime;

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }
}