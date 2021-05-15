package com.kgcorner;


import com.google.gson.Gson;
import com.kgcorner.models.Game;
import com.kgcorner.models.chesscom.ChessComGame;
import com.kgcorner.models.chesscom.ChessComProfileRawResponse;
import com.kgcorner.models.RawResponse;
import com.kgcorner.models.chesscom.ChessComRawResponse;
import com.kgcorner.scrappers.ChessCom;
import com.kgcorner.scrappers.Lichess;
import com.kgcorner.utility.PgnParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.SystemDefaultHttpClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description : Main class to launch the program
 * Author: kumar
 * Created on : 14/05/21
 */

public class Chess {

    public static void main(String[] args) throws IOException {
        if(args.length != 3) {
            System.out.println("Usage: ");
            System.out.println("java -jar <source : lichess/chess.com> <username> <outputDirectory>");
            System.exit(-1);
        }
        String source = args[0];
        String playerName = args[1];
        String outputDir = args[2];
        RawResponse rawResponse = null;
        if(source.toLowerCase().equals("chess.com")) {
            rawResponse = new ChessCom().fetchGames(playerName);
        } else {
            if (source.toLowerCase().equals("lichess")) {
                rawResponse = new Lichess().fetchGames(playerName);
            } else {
                System.out.println("Only lichess and chess.com is supported");
                System.exit(-1);
            }
        }
        if(rawResponse != null && !rawResponse.getGames().isEmpty()) {
            writeAllGames(rawResponse, outputDir);
        }
    }
    private static String chessComProfileUrl= "https://api.chess.com/pub/player/%s/games/archives";
    private static void keepIt(String[] args)  throws IOException {
        String outputDir = null;
        String playerName = args[0];
        chessComProfileUrl = String.format(chessComProfileUrl, playerName);
        if(args.length > 1) {
            outputDir = args [1];
        }
        HttpClient httpClient = new SystemDefaultHttpClient();
        HttpUriRequest request = new HttpGet(chessComProfileUrl);
        HttpResponse response = httpClient.execute(request);
        RawResponse allGamesResponse = new ChessComRawResponse();
        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            ChessComProfileRawResponse profileRawResponse =
                new Gson().fromJson(new InputStreamReader(entity.getContent()), ChessComProfileRawResponse.class);

            for(String archive : profileRawResponse.getArchives()) {
                RawResponse rawResponse = getAllGames(archive);
                allGamesResponse.getGames().addAll(rawResponse.getGames());
            }
        }
        if(outputDir == null) {
            outputDir = "/work/chess/chess.com-games/";
        }

    }

    private static void writeAllGames(RawResponse allGamesResponse, String outputDir) {
        for(Game game : allGamesResponse.getGames()) {
            PgnParser parser = new PgnParser(game.getPgn());
            String fileNameFormat = "%s_%s_%s_%s.pgn";
            String time = parser.getUtcTime().replace(":","-");
            String date = parser.getUtcDate().replace(".","-");
            String fileName = outputDir + File.separator + String.format(fileNameFormat,
                time, date, parser.getWhite(), parser.getBlack());
            System.out.println("Writing : " + fileName);
            writeFile(game.getPgn(), fileName);
        }
    }

    private static int writeFile(String pgn, String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(pgn);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return 0;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    }

    private static RawResponse getAllGames(String url) throws IOException {
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


