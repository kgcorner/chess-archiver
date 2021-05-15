package com.kgcorner.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public interface Player {

    Integer getRating();

    String getResult();

    String getId();

    String getUsername();
}