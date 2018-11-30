package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a JSON-based weather-related REST API.
 * It is only to be used by API classes extending it.
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


    /**
     * This method defines a way of getting the current weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the current weather for
     * @return A WeatherData instance containing the data for the current weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation
     */
    public abstract WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way of getting the daily weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the daily weather for
     * @return A WeatherData instance containing the data for the daily weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation
     */
    public abstract WeatherData getDailyWeather(LocationCoordinate _location) throws Exception;

    //NEEDS COMMENTS
    public abstract WeatherData getDailyWeatherForecast(LocationCoordinate _location, int _offset) throws Exception;


    /**
     * This method defines a way of getting the hourly weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the hourly weather for
     * @return A WeatherData instance containing the data for the hourly weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation
     */
    public abstract WeatherData getHourlyWeather(LocationCoordinate _location) throws Exception;

    public abstract WeatherData getHourlyWeatherForecast(LocationCoordinate _location, int _offset) throws Exception;
}

