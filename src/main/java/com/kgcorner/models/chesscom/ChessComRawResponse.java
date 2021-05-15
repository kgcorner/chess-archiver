package com.kgcorner.models.chesscom;


import com.kgcorner.Chess;
import com.kgcorner.models.Game;
import com.kgcorner.models.RawResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public class ChessComRawResponse implements RawResponse {
    private List<ChessComGame> games = new ArrayList();

    public List<Game> getGames() {
        List<Game> gameList = new ArrayList<Game>();
        for(Game game : games) {
            gameList.add(game);
        }
        return gameList;
    }

    public void setGames(List<Game> games) {
        for(Game g : games) {
            this.games.add((ChessComGame) g);
        }
    }
}