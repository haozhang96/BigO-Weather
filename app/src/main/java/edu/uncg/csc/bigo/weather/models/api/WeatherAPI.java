package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a JSON-based weather REST API.
 * It is only to be used by final API classes extending it.
 *
 * @updated 2018/09/25
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;


public abstract class WeatherAPI extends JSONAPI {
    protected WeatherAPI(String _endpoint) {
        super(_endpoint);
    }

    public abstract WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception;
    public abstract WeatherData getMinutelyWeather(LocationCoordinate _location) throws Exception;
    public abstract WeatherData getHourlyWeather(LocationCoordinate _location) throws Exception;
    public abstract WeatherData getDailyWeather(LocationCoordinate _location) throws Exception;
}