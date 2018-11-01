package edu.uncg.csc.bigo.weather.models.api.weather;
/**
 * This interface describes a weather-related API.
 *
 * @updated 2018/11/01
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;


public interface WeatherAPI {
    /**
     * This method defines a way of getting the current weather conditions for a given coordinate.
     * @param _location A LocationCoordinate of the location to get the current weather for
     * @return A WeatherData instance containing the data for the current weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *      based on its implementation
     */
    WeatherData getCurrentWeather(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way of getting the daily weather conditions for a given coordinate.
     * @param _location A LocationCoordinate of the location to get the daily weather for
     * @return A WeatherData instance containing the data for the daily weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *      based on its implementation
     */
    WeatherData getDailyWeather(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way of getting the hourly weather conditions for a given coordinate.
     * @param _location A LocationCoordinate of the location to get the hourly weather for
     * @return A WeatherData instance containing the data for the hourly weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *      based on its implementation
     */
    WeatherData getHourlyWeather(LocationCoordinate _location) throws Exception;


    /**
     * This method defines a way of getting the minutely weather conditions for a given coordinate.
     * @param _location A LocationCoordinate of the location to get the minutely weather for
     * @return A WeatherData instance containing the data for the minutely weather conditions
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *      based on its implementation
     */
    WeatherData getMinutelyWeather(LocationCoordinate _location) throws Exception;
}