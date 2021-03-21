package com.example.demo2;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import java.util.Timer;
import java.util.TimerTask;

public class PostSender {
    private String consumerKey="DtMRN539BSciWm467UVtM6oQ2";
    private String consumerSecret="aexfHgjdEhDOdcc4j1UohiNz08EBVfD68woe5InEpMkKokVM1C";
    private String accessTokenString="1371480930225905665-hc4SQQa4TOMj5SNUMmciO677XaK2G0";
    private String accessTokenSecret="qnixLeZcg1ANCGSqSMeGslUF9SB8YOdYOMxkgNSKmFrze";


    public void Post(String location, String degrees, int delayNumber)
    {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Twitter twitter = new TwitterFactory().getInstance();
                twitter.setOAuthConsumer(consumerKey, consumerSecret);
                AccessToken accessToken = new AccessToken(accessTokenString, accessTokenSecret);
                twitter.setOAuthAccessToken(accessToken);
                System.out.println(accessToken);
               try {
                    twitter.updateStatus("Krisko is at " + location + " and it is " + degrees +" outside");
                } catch (TwitterException e) {
                    e.printStackTrace();
                }

            }
        },  0, 1000 * 60 * delayNumber);
    }
}

