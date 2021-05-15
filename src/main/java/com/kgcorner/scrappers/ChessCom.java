package com.kgcorner.scrappers;


import com.google.gson.Gson;
import com.kgcorner.models.chesscom.ChessComProfileRawResponse;
import com.kgcorner.models.RawResponse;
import com.kgcorner.models.chesscom.ChessComRawResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.SystemDefaultHttpClient;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description : Scrapper for chess.com
 * Author: kumar
 * Created on : 15/05/21
 */

public class ChessCom implements Scrapper {
    private static String chessComProfileUrl= "https://api.chess.com/pub/player/%s/games/archives";
    public RawResponse fetchGames(String playerName) {
        ChessComRawResponse allGamesResponse = new ChessComRawResponse();
        try {
            chessComProfileUrl = String.format(chessComProfileUrl, playerName);
            HttpClient httpClient = new SystemDefaultHttpClient();
            HttpUriRequest request = new HttpGet(chessComProfileUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                ChessComProfileRawResponse profileRawResponse =
                    new Gson().fromJson(new InputStreamReader(entity.getContent()), ChessComProfileRawResponse.class);

                for (String archive : profileRawResponse.getArchives()) {
                    RawResponse rawResponse = getAllGames(archive);
                    allGamesResponse.setGames(rawResponse.getGames());
                }
            }
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
        return allGamesResponse;
    }

    private RawResponse getAllGames(String url) throws IOException {
        HttpClient httpClient = new SystemDefaultHttpClient();
        HttpUriRequest request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            return new Gson().fromJson(new InputStreamReader(entity.getContent()), ChessComRawResponse.class);
        }
        throw new RuntimeException("Call to " + url + " failed with "
            + response.getStatusLine().getStatusCode() +" status code");
    }
}