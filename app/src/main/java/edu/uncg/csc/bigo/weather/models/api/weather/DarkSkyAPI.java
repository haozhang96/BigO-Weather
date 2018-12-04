package edu.uncg.csc.bigo.weather.models.api.weather;
/**
 * This class Defines the usage of the DarkSky Weather API, and contains the methods to return weather
 * data from a JSON object.
 *
 * @updated 11/14/2018
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.api.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.metrics.*;
import edu.uncg.csc.bigo.weather.models.metrics.units.*;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;
import edu.uncg.csc.bigo.weather.models.weather.WeatherDataBuilder;
import java.io.IOException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DarkSkyAPI extends WeatherAPI {
    /**
     * This constructs an instance of DarkSkyAPI with a given API key.
     * @param _apiKey The API key to the Dark Sky API service.
     */
    public DarkSkyAPI(String _apiKey) {
        super(String.format("https://api.darksky.net/forecast/%s/%%f,%%f", _apiKey));
    }


    /**
     * This method returns the current weather conditions for a given coordinate.
     * @param _location A LocationCoordinate of the location to get the current weather for.
     * @return A WeatherData instance containing the data for the current weather conditions.
     * @throws IOException An exception indicating a problem with the connection to the API endpoint.
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *      response as a JSONObject.
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
     * This methods returns the daily weather conditions for a given coordinate.
     * @param _location
     * @return A WeatherData instance cantaining the data for the daily weather forecast.
     * @throws IOException An exception indicating a problem with the connection to the API endpoint.
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *            response as a JSONObject.
     */
    public WeatherData[] getDailyWeatherForecast(LocationCoordinate _location)
            throws IOException, JSONException {

        // Get the hourly weather data from the API at the given location.
        JSONArray apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("daily").getJSONArray("data");

        WeatherData[] dataPoints = new WeatherData[apiResponse.length()];
        for (int index = 0; index < apiResponse.length(); index++) {
            dataPoints[index] = this.extractWeatherData(apiResponse.getJSONObject(index), _location);
        }
        // Extract the weather data using the helper method.
        return dataPoints;
    }


    /**
     * This method returns the hourly weather conditions for a given coordinate, and uses
     * an offset to determine which hour you would like the data for.
     * @param _location A LocationCoordinate of the location to get the hourly weather for.
     * @return A WeatherData instance containing the data for the hourly weather conditions.
     * @throws IOException An exception indicating a problem with the connection to the API endpoint.
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *      response as a JSONObject.
     */
    @Override
    public WeatherData[] getHourlyWeatherForecast(LocationCoordinate _location)
            throws IOException, JSONException {
        // Get the hourly weather data from the API at the given location.
        JSONArray apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("hourly").getJSONArray("data");

        WeatherData[] dataPoints = new WeatherData[apiResponse.length()];
        for (int index = 0; index < apiResponse.length(); index++) {
            dataPoints[index] = this.extractWeatherData(apiResponse.getJSONObject(index), _location);
        }
        // Extract the weather data using the helper method.
        return dataPoints;
    }


    /**
     * This helper method extracts the weather data from a data point JSON object.
     * See https://darksky.net/dev/docs#data-point.
     * @param _dataPoint A data point JSON object in the format specified by Dark Sky's API.
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
                .setTemperatureHigh(new Temperature(
                        _dataPoint.optDouble("temperatureHigh"),
                        TemperatureUnit.FAHRENHEIT
                ))
                .setTemperatureLow(new Temperature(
                        _dataPoint.optDouble("temperatureLow"),
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
                .setIcon(_dataPoint.optString("icon"))
                .build();
    }
}