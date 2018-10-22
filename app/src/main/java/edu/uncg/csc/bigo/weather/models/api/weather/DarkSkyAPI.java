package com.example.bigo.weatherapp.models.api.weather;
/**
 * This class defines the Dark Sky weather API.
 *
 * @updated 2018/09/27
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */

import com.example.bigo.weatherapp.models.api.WeatherAPI;
import com.example.bigo.weatherapp.models.metrics.*;
import com.example.bigo.weatherapp.models.metrics.units.*;
import com.example.bigo.weatherapp.models.util.LocationCoordinate;
import com.example.bigo.weatherapp.models.weather.WeatherData;
import com.example.bigo.weatherapp.models.weather.WeatherDataBuilder;
import java.io.IOException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;


public final class DarkSkyAPI extends WeatherAPI {
    /**
     * This constructs an instance of DarkSkyAPI with a given API key.
     *
     * @param _apiKey The API key to the Dark Sky API service
     */
    public DarkSkyAPI(String _apiKey) {
        super(String.format("https://api.darksky.net/forecast/%s/%%f,%%f", _apiKey));
    }


    /**
     * This method returns the current weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the current weather for
     * @return A WeatherData instance containing the data for the current weather conditions
     * @throws IOException   An exception indicating a problem with the connection to the API endpoint
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *                       response as a JSONObject
     */
    @Override
    public WeatherData getCurrentWeather(LocationCoordinate _location)
            throws IOException, JSONException {
        // Get the current weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("currently");

        // Extract the weather data using the helper method.
        return this.extractWeatherData(apiResponse, _location);
    }


    /**
     * This method returns the daily weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the daily weather for
     * @return A WeatherData instance containing the data for the daily weather conditions
     * @throws IOException   An exception indicating a problem with the connection to the API endpoint
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *                       response as a JSONObject
     */
    @Override
    public WeatherData getDailyWeather(LocationCoordinate _location)
            throws IOException, JSONException {
        // Get the daily weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("daily").getJSONArray("data").getJSONObject(0);

        // Extract the weather data using the helper method.
        return this.extractWeatherData(apiResponse, _location);
    }


    /**
     * This method returns the hourly weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the hourly weather for
     * @return A WeatherData instance containing the data for the hourly weather conditions
     * @throws IOException   An exception indicating a problem with the connection to the API endpoint
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *                       response as a JSONObject
     */
    @Override
    public WeatherData getHourlyWeather(LocationCoordinate _location)
            throws IOException, JSONException {
        // Get the hourly weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("hourly").getJSONArray("data").getJSONObject(0);

        // Extract the weather data using the helper method.
        return this.extractWeatherData(apiResponse, _location);
    }


    /**
     * This method returns the minutely weather conditions for a given coordinate.
     *
     * @param _location A LocationCoordinate of the location to get the minutely weather for
     * @return A WeatherData instance containing the data for the minutely weather conditions
     * @throws IOException   An exception indicating a problem with the connection to the API endpoint
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *                       response as a JSONObject
     */
    @Override
    public WeatherData getMinutelyWeather(LocationCoordinate _location)
            throws IOException, JSONException {
        // Get the minutely weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("minutely").getJSONArray("data").getJSONObject(0);

        // Extract the weather data using the helper method.
        return this.extractWeatherData(apiResponse, _location);
    }


    /**
     * This helper method extracts the weather data from a data point JSON object.
     * See https://darksky.net/dev/docs#data-point.
     *
     * @param _dataPoint A data point JSON object in the format specified by Dark Sky's API
     * @param _location
     * @return
     */
    private WeatherData extractWeatherData(JSONObject _dataPoint, LocationCoordinate _location) {
        // Use the WeatherDataBuilder class to build a WeatherData object.
        return new WeatherDataBuilder()
                .setApparentTemperature(new Temperature(
                        _dataPoint.optDouble("apparentTemperature"),
                        TemperatureUnit.FAHRENHEIT
                ))
                .setCloudCover(new Amount(
                        _dataPoint.optDouble("cloudCover"),
                        AmountUnit.RATIO
                ))
                .setDewPoint(new Temperature(
                        _dataPoint.optDouble("dewPoint"),
                        TemperatureUnit.FAHRENHEIT
                ))
                .setHumidity(new Amount(
                        _dataPoint.optDouble("humidity"),
                        AmountUnit.RATIO
                ))
                .setLocation(_location)
                .setMoonPhase(new Amount(
                        _dataPoint.optDouble("moonPhase"),
                        AmountUnit.RATIO
                ))
                .setNearestStormDistance(new Distance(
                        _dataPoint.optDouble("nearestStormDistance"),
                        DistanceUnit.MILE
                ))
                .setOzone(new ColumnarDensity(
                        _dataPoint.optDouble("ozone"),
                        ColumnarDensityUnit.DOBSON_UNIT
                ))
                .setPrecipitationIntensity(new Speed(
                        _dataPoint.optDouble("precipIntensity"),
                        SpeedUnit.MILE_PER_HOUR
                ))
                .setPrecipitationProbability(new Amount(
                        _dataPoint.optDouble("precipProbability"),
                        AmountUnit.RATIO
                ))
                .setPressure(new Pressure(
                        _dataPoint.optDouble("pressure"),
                        PressureUnit.HECTOPASCAL
                ))
                .setSummary(_dataPoint.optString("summary"))
                .setTemperature(new Temperature(
                        _dataPoint.optDouble("temperature"),
                        TemperatureUnit.FAHRENHEIT
                ))
                .setTime(new Date(_dataPoint.optLong("time") * 1000))
                .setUVIndex(_dataPoint.optInt("uvIndex"))
                .setVisibility(new Distance(
                        _dataPoint.optDouble("visibility"),
                        DistanceUnit.MILE
                ))
                .setWindGust(new Speed(
                        _dataPoint.optDouble("windGust"),
                        SpeedUnit.MILE_PER_HOUR
                ))
                .setWindSpeed(new Speed(
                        _dataPoint.optDouble("windSpeed"),
                        SpeedUnit.MILE_PER_HOUR
                ))
                .build();
    }
}
