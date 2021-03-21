package com.example.demo2;

public class CoordinatesFinder {

    public double findlat(String city)
    {
        double lat =0;
        switch (city){
            case "Pernik":
                lat = 42.6;
            case "Sofia" :
                lat = 42.6975;
        }
        return lat;
    }

    public double findlon(String city)
    {
        double lon =0;
        switch (city){
            case "Pernik":
                lon = 23.0333;
            case "Sofia" :
                lon = 23.3242;
        }
        return lon;
    }
}


