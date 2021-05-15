package com.kgcorner.models.lichess;


/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kgcorner.models.Game;
import com.kgcorner.models.Player;
import com.kgcorner.models.chesscom.ChessComPlayer;

@Generated("jsonschema2pojo")
public class LiChessGame implements Game {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rated")
    @Expose
    private Boolean rated;
    @SerializedName("variant")
    @Expose
    private String variant;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("perf")
    @Expose
    private String perf;
    @SerializedName("createdAt")
    @Expose
    private Long createdAt;
    @SerializedName("lastMoveAt")
    @Expose
    private Long lastMoveAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("players")
    @Expose
    private Players players;
    @SerializedName("winner")
    @Expose
    private String winner;
    @SerializedName("moves")
    @Expose
    private String moves;
    @SerializedName("pgn")
    @Expose
    private String pgn;
    @SerializedName("clock")
    @Expose
    private LiChessClock clock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRated() {
        return rated;
    }

    public void setRated(Boolean rated) {
        this.rated = rated;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPerf() {
        return perf;
    }

    public void setPerf(String perf) {
        this.perf = perf;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastMoveAt() {
        return lastMoveAt;
    }

    public void setLastMoveAt(Long lastMoveAt) {
        this.lastMoveAt = lastMoveAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getPgn() {
        return pgn;
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }

    public LiChessClock getClock() {
        return clock;
    }

    public void setClock(LiChessClock clock) {
        this.clock = clock;
    }

    /*** Games Methods ***/
    public String getUrl() {
        return "https://lichess.org/"+id;
    }

    public String getTimeControl() {
        return getClock().getInitial()+"";
    }

    public Long getEndTime() {
        return getLastMoveAt();
    }

    public String getFen() {
        return null;
    }

    public String getTimeClass() {
        return getSpeed();
    }

    public String getRules() {
        return getVariant();
    }

    public Player getWhite() {
        return getPlayers().getWhite();
    }

    public Player getBlack() {
        return getPlayers().getBlack();
    }
}

@Generated("jsonschema2pojo")
class Players {

    @SerializedName("white")
    @Expose
    private LiChessPlayer white;
    @SerializedName("black")
    @Expose
    private LiChessPlayer black;

    public LiChessPlayer getWhite() {
        return white;
    }

    public void setWhite(LiChessPlayer white) {
        this.white = white;
    }

    public LiChessPlayer getBlack() {
        return black;
    }

    public void setBlack(LiChessPlayer black) {
        this.black = black;
    }

}