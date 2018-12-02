package edu.uncg.csc.bigo.weather.controllers;
/**
 * This class handles the API fallback mechanism and caching of weather data.
 *
 * @updated 2018/11/01
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.api.fallback.WeatherAPIFallbackHandler;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
//import edu.uncg.csc.bigo.weather.models.util.caching.TimeExpirableCache;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;

import android.util.Log;
import java.io.IOException;


public final class WeatherController {
    private static WeatherAPIFallbackHandler api = null;
    static {
        try {
            WeatherController.api = new WeatherAPIFallbackHandler();
        } catch (Exception e) {
            Log.d("Hao", e.getMessage());
        }
    }
    //private static final TimeExpirableCache<LocationCoordinate, WeatherData>
    //        weatherDataCache = new TimeExpirableCache();


    public static WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception {
        return WeatherController.api.getCurrentWeather(_location);
    }


    public static WeatherData getDailyWeather(LocationCoordinate _location) throws Exception {
        return WeatherController.api.getDailyWeather(_location);
    }


    public static WeatherData getHourlyWeather(LocationCoordinate _location) throws Exception {
        return WeatherController.api.getHourlyWeather(_location);
    }


    public static WeatherData getMinutelyWeather(LocationCoordinate _location) throws Exception {
        return WeatherController.api.getMinutelyWeather(_location);
    }


    private static WeatherAPIFallbackHandler getAPIHandler()
            throws ClassNotFoundException, IOException
    {
        if (WeatherController.api == null) {
            WeatherController.api = new WeatherAPIFallbackHandler();
        }
        return WeatherController.api;
    }
}