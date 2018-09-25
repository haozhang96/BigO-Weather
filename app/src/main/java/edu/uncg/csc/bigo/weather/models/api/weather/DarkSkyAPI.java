package edu.uncg.csc.bigo.weather.models.api.weather;

/**
 * ?
 *
 * @updated 2018/09/25
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.api.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;
import edu.uncg.csc.bigo.weather.models.weather.WeatherDataBuilder;
import java.io.IOException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;


public final class DarkSkyAPI extends WeatherAPI {
    /**
     * This constructs an instance of DarkSkyAPI with a given API key.
     * @param _apiKey The API key to the Dark Sky API service
     */
    public DarkSkyAPI(String _apiKey) {
        super(String.format("https://api.darksky.net/forecast/%s/%%f,%%f", _apiKey));
    }


    public WeatherData getCurrentWeather(LocationCoordinate _location)
            throws IOException, JSONException
    {
        // Get the current weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("currently");

        // Use the WeatherDataBuilder class to build a WeatherData object.
        return new WeatherDataBuilder()
                .setApparentTemperature(apiResponse.getDouble("apparentTemperature"))
                .setCloudCover(apiResponse.getDouble("cloudCover"))
                .setDewPoint(apiResponse.getDouble("dewPoint"))
                .setHumidity(apiResponse.getDouble("humidity"))
                .setLocation(_location)
                .setNearestStormDistance(apiResponse.getDouble("nearestStormDistance"))
                .setOzone(apiResponse.getDouble("ozone"))
                .setPrecipitationIntensity(apiResponse.getDouble("precipIntensity"))
                .setPrecipitationProbability(apiResponse.getDouble("precipProbability"))
                .setPressure(apiResponse.getDouble("pressure"))
                .setSummary(apiResponse.getString("summary"))
                .setTemperature(apiResponse.getDouble("temperature"))
                .setTime(new Date(apiResponse.getLong("time") * 1000))
                .setUVIndex(apiResponse.getDouble("uvIndex"))
                .setVisibility(apiResponse.getDouble("visibility"))
                .setWindGust(apiResponse.getDouble("windGust"))
                .setWindSpeed(apiResponse.getDouble("windSpeed"))
                .build();
    }


    public WeatherData getMinutelyWeather(LocationCoordinate _location)
            throws IOException, JSONException
    {
        // Get the minutely weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("minutely").getJSONArray("data").getJSONObject(0);

        // Use the WeatherDataBuilder class to build a WeatherData object.
        return new WeatherDataBuilder()
                .setLocation(_location)
                // .setSummary(apiResponse.getString("summary"))
                // .setTemperature(apiResponse.getDouble("temperature"))
                .setTime(new Date(apiResponse.getLong("time") * 1000))
                .build();
    }


    public WeatherData getHourlyWeather(LocationCoordinate _location)
            throws IOException, JSONException
    {
        // Get the hourly weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("hourly").getJSONArray("data").getJSONObject(0);

        // Use the WeatherDataBuilder class to build a WeatherData object.
        return new WeatherDataBuilder()
                .setLocation(_location)
                .setSummary(apiResponse.getString("summary"))
                // .setTemperature(apiResponse.getDouble("temperature"))
                .setTime(new Date(apiResponse.getLong("time") * 1000))
                .build();
    }


    public WeatherData getDailyWeather(LocationCoordinate _location)
            throws IOException, JSONException
    {
        // Get the daily weather data from the API at the given location.
        JSONObject apiResponse = this.getResponse(
                _location.getLatitude(), _location.getLongitude()
        ).getJSONObject("daily").getJSONArray("data").getJSONObject(0);

        // Use the WeatherDataBuilder class to build a WeatherData object.
        return new WeatherDataBuilder()
                .setLocation(_location)
                .setSummary(apiResponse.getString("summary"))
                // .setTemperature(apiResponse.getDouble("temperature"))
                .setTime(new Date(apiResponse.getLong("time") * 1000))
                .build();
    }
}
