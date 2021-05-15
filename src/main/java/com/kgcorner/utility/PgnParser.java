package com.kgcorner.utility;


/**
 * Description : <Write class Description>
 * Author: kumar
 * Created on : 15/05/21
 */

public class PgnParser {
    private String event;
    private String site;
    private String date;
    private String round;
    private String white;
    private String black;
    private String result;
    private String currentPosition;
    private String timeZone;
    private String eco;
    private String ecoUrl;
    private String utcDate;
    private String utcTime;
    private String whiteElo;
    private String blackElo;
    private String timeControl;
    private String termination;
    private String startTime;
    private String endTime;
    private String endDate;
    private String link;
    private String moves;

    public PgnParser(String rawPgn) {
        String[] data = rawPgn.split("\n");
        for (String d : data) {
            if(d.startsWith("[Event ")) {
                event = fetchData(d, "Event");
                continue;
            }
            if(d.startsWith("[Site ")) {
                site = fetchData(d, "Site");
                continue;
            }
            if(d.startsWith("[Date ")) {
                date = fetchData(d, "Date");
                continue;
            }
            if(d.startsWith("[Round ")) {
                round = fetchData(d, "Round");
                continue;
            }
            if(d.startsWith("[White ")) {
                white = fetchData(d, "White");
                continue;
            }
            if(d.startsWith("[Black ")) {
                black = fetchData(d, "Black");
                continue;
            }
            if(d.startsWith("[Result ")) {
                result = fetchData(d, "Result");
                continue;
            }
            if(d.startsWith("[CurrentPosition ")) {
                currentPosition = fetchData(d, "CurrentPosition");
                continue;
            }
            if(d.startsWith("[Timezone ")) {
                timeZone = fetchData(d, "Timezone");
                continue;
            }
            if(d.startsWith("[ECO ")) {
                eco = fetchData(d, "ECO");
                continue;
            }
            if(d.startsWith("[ECOUrl ")) {
                ecoUrl = fetchData(d, "ECOUrl");
                continue;
            }
            if(d.startsWith("[UTCDate ")) {
                utcDate = fetchData(d, "UTCDate");
                continue;
            }
            if(d.startsWith("[UTCTime ")) {
                utcTime = fetchData(d, "UTCTime");
                continue;
            }
            if(d.startsWith("[WhiteElo ")) {
                whiteElo = fetchData(d, "WhiteElo");
                continue;
            }
            if(d.startsWith("[BlackElo ")) {
                blackElo = fetchData(d, "BlackElo");
                continue;
            }
            if(d.startsWith("[TimeControl ")) {
                timeControl = fetchData(d, "TimeControl");
                continue;
            }
            if(d.startsWith("[Termination ")) {
                termination = fetchData(d, "Termination");
                continue;
            }
            if(d.startsWith("[StartTime ")) {
                startTime = fetchData(d, "StartTime");
                continue;
            }
            if(d.startsWith("[EndDate ")) {
                endDate = fetchData(d, "EndDate");
                continue;
            }
            if(d.startsWith("[EndTime ")) {
                endTime = fetchData(d, "EndTime");
                continue;
            }
            if(d.startsWith("[Link ")) {
                link = fetchData(d, "Link");
                continue;
            }
            this.moves = d;
        }
    }

    private String fetchData(String d, String dataName) {
        d = d.replace("["+dataName+" \"", "");
        return d.replace("\"]", "");

    }

    public String getEvent() {
        return event;
    }

    public String getSite() {
        return site;
    }

    public String getRound() {
        return round;
    }

    public String getWhite() {
        return white;
    }

    public String getBlack() {
        return black;
    }

    public String getResult() {
        return result;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getEco() {
        return eco;
    }

    public String getEcoUrl() {
        return ecoUrl;
    }

    public String getDate() {
        return date;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getMoves() {
        return moves;
    }

    public String getWhiteElo() {
        return whiteElo;
    }

    public String getBlackElo() {
        return blackElo;
    }

    public String getTimeControl() {
        return timeControl;
    }

    public String getTermination() {
        return termination;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLink() {
        return link;
    }
}