package com.example.bigo.weatherapp;

import java.util.Date;

/**
 *
 * @author Steven Tran
 */
public class IconManager {

    private static String id;
    private static String icon;

    public static String setWeatherIcon(long _sunrise, long _sunset) {

        long currentTime = new Date().getTime();
        if (currentTime >= _sunrise && currentTime < _sunset) {
            icon = "day";
        } else {
            icon = "night";
        }
        
        switch (id) {
            case "Raining":
                icon = "rainIcon";
                break;
            case "Snowing":
                icon = "snowIcon";
                break;
            case "Drizzling":
                icon = "drizzlingIcon";
                break;
            case "Foggy":
                icon = "fogIcon";
                break;
            case "Thunderstorm":
                icon = "thunderIcon;";
                break;
            case "Sunny":
                icon = "sunIcon";
                break;
        }

        return icon;
    }
}
