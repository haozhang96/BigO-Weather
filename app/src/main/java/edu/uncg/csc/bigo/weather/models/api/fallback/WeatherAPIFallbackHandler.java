package edu.uncg.csc.bigo.weather.models.api.fallback;


import android.util.Log;

import edu.uncg.csc.bigo.weather.models.api.weather.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;

import java.io.IOException;


public final class WeatherAPIFallbackHandler extends APIFallbackHandler implements WeatherAPI {
    public WeatherAPIFallbackHandler() throws ClassNotFoundException, IOException {
        super(WeatherAPI.class, "edu.uncg.csc.bigo.weather.models.api.weather");
    }


    public WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception {
        Log.d("Hao", "In APIFallbackHandler.apiCallInstanceMethod");
        return (WeatherData) this.apiCallInstanceMethod(
                "getCurrentWeather",
                new Class[] { LocationCoordinate.class },
                new Object[] { _location }
        ).getResponse();
    }


    public WeatherData getDailyWeather(LocationCoordinate _location) throws Exception {
        return (WeatherData) this.apiCallInstanceMethod(
                "getDailyWeather",
                new Class[] { LocationCoordinate.class },
                new Object[] { _location }
        ).getResponse();
    }


    public WeatherData getHourlyWeather(LocationCoordinate _location) throws Exception {
        return (WeatherData) this.apiCallInstanceMethod(
                "getHourlyWeather",
                new Class[] { LocationCoordinate.class },
                new Object[] { _location }
        ).getResponse();
    }


    public WeatherData getMinutelyWeather(LocationCoordinate _location) throws Exception {
        return (WeatherData) this.apiCallInstanceMethod(
                "getMinutelyWeather",
                new Class[] { LocationCoordinate.class },
                new Object[] { _location }
        ).getResponse();
    }
}