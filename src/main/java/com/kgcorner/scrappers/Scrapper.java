package com.kgcorner.scrappers;

import com.kgcorner.models.RawResponse;
import com.kgcorner.utility.PgnParser;

/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public interface Scrapper {
    RawResponse fetchGames(String playerName) ;
}