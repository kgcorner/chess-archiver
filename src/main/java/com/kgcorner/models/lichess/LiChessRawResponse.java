package com.kgcorner.models.lichess;


import com.kgcorner.models.Game;
import com.kgcorner.models.RawResponse;
import com.kgcorner.models.chesscom.ChessComGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public class LiChessRawResponse implements RawResponse {
    private List<LiChessGame> games = new ArrayList<LiChessGame>();
    public List<Game> getGames() {
        List<Game> gameList = new ArrayList<Game>();
        for(Game game : games) {
            gameList.add(game);
        }
        return gameList;
    }

    public void setGames(List<Game> games) {
        for(Game g : games) {
            this.games.add((LiChessGame) g);
        }
    }
}