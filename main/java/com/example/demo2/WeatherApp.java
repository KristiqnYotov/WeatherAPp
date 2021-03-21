package com.example.demo2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.ipinfo.api.IPInfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherApp {

    public static Map<String, Object> jsontoMap(String str) {
        Map<String, Object> map = new Gson().fromJson
                (
                        str, new TypeToken<HashMap<String, Object>>() {
                        }.getType()
                );
        return map;
    }

    public void run(int timeDelayer) throws IOException
    {
        int delay = timeDelayer;
        IPInfo ipInfo = IPInfo.builder().setToken("834c968c0897e9").setCountryFile(new File("path/to/file.json")).build();
        URL ipUrl = new URL("http://checkip.amazonaws.com/");
        BufferedReader br = new BufferedReader(new InputStreamReader(ipUrl.openStream()));
        String ip = br.readLine();
        CoordinatesFinder coordinatesFinder = new CoordinatesFinder();

        try {
            IPResponse response = ipInfo.lookupIP(ip);
            System.out.println(response.getCountryCode());
            System.out.println(response.getCity());
            String APIKey = "43d4cd5abaeb7fe2072ead75b542cba0";
            String URLString = "http://api.openweathermap.org/data/2.5/weather?lat=" + coordinatesFinder.findlat(response.getCity()) +
                      "&lon=" + coordinatesFinder.findlon(response.getCity()) + "&appid=" + APIKey + "&units=metric";

            try {
                StringBuilder result = new StringBuilder();
                URL url = new URL(URLString);
                URLConnection conn = url.openConnection();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line = rd.readLine()) != null)
                {
                    result.append(line);
                }
                rd.close();
                Map<String, Object> respMap = jsontoMap(result.toString());
                Map<String, Object> mainMap = jsontoMap(respMap.get("main").toString());
                System.out.println(mainMap.get("temp"));


                // Tweets:

                PostSender postSender = new PostSender();
                postSender.Post(response.getCity(), mainMap.get("temp").toString(), delay);


            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (RateLimitedException ex) {

        }
    }

}
