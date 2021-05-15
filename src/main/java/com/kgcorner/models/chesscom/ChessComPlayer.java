package com.kgcorner.models.chesscom;


/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 14/05/21
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kgcorner.models.Player;

@Generated("jsonschema2pojo")
public class ChessComPlayer implements Player {

    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("@id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}