package com.kgcorner.models.chesscom;


/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 14/05/21
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kgcorner.models.Game;
import com.kgcorner.models.Player;

@Generated("jsonschema2pojo")
public class ChessComGame implements Game {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pgn")
    @Expose
    private String pgn;
    @SerializedName("time_control")
    @Expose
    private String timeControl;
    @SerializedName("end_time")
    @Expose
    private Long endTime;
    @SerializedName("rated")
    @Expose
    private Boolean rated;
    @SerializedName("fen")
    @Expose
    private String fen;
    @SerializedName("time_class")
    @Expose
    private String timeClass;
    @SerializedName("rules")
    @Expose
    private String rules;
    @SerializedName("white")
    @Expose
    private ChessComPlayer white;
    @SerializedName("black")
    @Expose
    private ChessComPlayer black;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPgn() {
        return pgn;
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }

    public String getTimeControl() {
        return timeControl;
    }

    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Boolean getRated() {
        return rated;
    }

    public void setRated(Boolean rated) {
        this.rated = rated;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Player getWhite() {
        return white;
    }

    public void setWhite(ChessComPlayer white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(ChessComPlayer black) {
        this.black = black;
    }

}