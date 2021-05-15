package com.kgcorner.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kgcorner.models.chesscom.ChessComPlayer;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public interface Game {
    String getUrl();

    String getPgn();

    String getTimeControl();

    Long getEndTime();

    Boolean getRated();

    String getFen();

    String getTimeClass();

    String getRules();

    Player getWhite();

    Player getBlack();
}