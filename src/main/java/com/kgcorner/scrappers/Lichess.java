package com.kgcorner.scrappers;


import com.google.gson.Gson;
import com.kgcorner.models.RawResponse;
import com.kgcorner.models.lichess.LiChessRawResponse;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.SystemDefaultHttpClient;
import org.apache.http.message.BasicHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public class Lichess implements Scrapper {
    private static String url = "https://lichess.org/api/games/user/%s?pgnInJson=true";

    public RawResponse fetchGames(String playerName) {
        try {
            url = String.format(url, playerName);
            LiChessRawResponse liChessRawResponse = null;
            HttpClient httpClient = new SystemDefaultHttpClient();
            HttpUriRequest request = new HttpGet(url);
            Header token = new BasicHeader("Authorization", "Bearer " + getAuthToken());
            Header acceptHeader = new BasicHeader("Accept", "application/x-ndjson");
            request.setHeader(token);
            request.addHeader(acceptHeader);
            HttpResponse response = httpClient.execute(request);
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String responseText = convertStreamToString(entity.getContent());
                responseText = responseText.replace("}\n{","}\n,{");
                responseText = "{games:["+ responseText+"]}";
                liChessRawResponse = new Gson().fromJson(responseText, LiChessRawResponse.class);
            }
            return liChessRawResponse;
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    private String getAuthToken() {
        Properties properties = new Properties();

        try {
            properties.load(Lichess.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty("lichess.api");
    }

    private static String convertStreamToString(InputStream is) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw e;
            }
        }

        return sb.toString();
    }
}