package com.kgcorner.models.lichess;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kgcorner.models.Player;

import javax.annotation.Generated;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

@Generated("jsonschema2pojo")
public class LiChessPlayer implements Player {

    @SerializedName("user")
    @Expose
    private LiChessUser user;

    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("ratingDiff")
    @Expose
    private Integer ratingDiff;

    public LiChessUser getUser() {
        return user;
    }

    public void setUser(LiChessUser user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatingDiff() {
        return ratingDiff;
    }

    public void setRatingDiff(Integer ratingDiff) {
        this.ratingDiff = ratingDiff;
    }

    public String getResult() {
        return null;
    }

    public String getId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getName();
    }
}

