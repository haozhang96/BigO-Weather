package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a JSON-based weather-related REST API.
 * It is only to be used by API classes extending it.
 *
 * @updated 09/25/2018
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
     * @param _location A LocationCoordinate of the location to get the current weather for.
     * @return A WeatherData instance containing the data for the current weather conditions.
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation.
     */
    public abstract WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way got getting the daily weather forecast conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the daily weather for.
     * @return
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation.
     */
    public abstract WeatherData[] getDailyWeatherForecast(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way of getting the hourly weather forecast conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the hourly weather for.
     * @return A WeatherData instance containing the data for the hourly weather conditions.
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *                   based on its implementation.
     */
    public abstract WeatherData[] getHourlyWeatherForecast(LocationCoordinate _location) throws Exception;
}