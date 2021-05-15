package com.kgcorner.models;

import com.kgcorner.models.chesscom.ChessComGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 14/05/21
 */

public interface RawResponse {
    List<Game> getGames();
}