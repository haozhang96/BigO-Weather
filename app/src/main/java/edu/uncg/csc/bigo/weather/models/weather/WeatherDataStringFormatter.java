package edu.uncg.csc.bigo.weather.models.weather;
/**
 * The WeatherDataStringFormatter class takes the weather data from DarkSkyAPI and GeocodioAPI and places
 * the individual pieces of Current, Hourly, Daily, and Minutely weather data into String arrays. The WeatherController
 * class can take these String arrays and give them to view files to display weather data to the user.
 *
 * @updated 11/14/2018
 * @author John Isaac Wilkinson
 */

import org.json.JSONException;

import java.io.IOException;

import javax.microedition.khronos.opengles.GL;

import edu.uncg.csc.bigo.weather.models.api.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.api.location.GeocodioAPI;
import edu.uncg.csc.bigo.weather.models.api.weather.DarkSkyAPI;
import edu.uncg.csc.bigo.weather.models.util.Globals;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.views.activities.MainActivity;

public class WeatherDataStringFormatter {
    /**
     * The formatCurrentWeather method creates the necessary objects to gather the current weather data
     * for the zipcode provided, and places the individual pieces of data into a String array to be
     * passed around by the Weather Controller. The indexes are organized as follows:
     *
     * 0 - The city, state, and zipcode
     * 1 - The precipitation intensity
     * 2 - The precipitation probability
     * 3 - The summary of the current weather
     * 4 - The time
     * 5 - The percentage of cloud coverage
     * 6 - The dew point
     * 7 - The humidity
     * 8 - The latitude and longitude
     * 9 - The moon phase
     * 10 - The ozone
     * 11 - The pressure
     * 12 - empty
     * 13 - empty
     * 14 - The UV index
     * 15 - The the distance of visibility
     * 16 - The speed of the wind gust
     * 17 - The speed of the wind
     * 18 - The apparent temperature
     * 19 - icon
     *
     * @param _zip The Zipcode of the location to check the weather of.
     * @return currentStringArray The array of Strings containing the current weather information.
     * @throws Exception
     */
    static public String[] formatCurrentWeather(int _zip) throws Exception {
        String[] currentStringArray = new String[25];
        WeatherAPI darkSkyCurrent = new DarkSkyAPI(Globals.APIKEY_DARKSKY);
        GeocodioAPI geoCurrent = new GeocodioAPI(Globals.APIKEY_GEOCODIO);
        LocationCoordinate location = geoCurrent.zipCodeToCoordinate(_zip);
        WeatherData weatherCurrent = darkSkyCurrent.getCurrentWeather(location);

        currentStringArray[Globals.CITY_STATE_ZIP] = geoCurrent.getNameOfLocation(_zip);
        currentStringArray[Globals.PRECIP_INTENSITY] = weatherCurrent.getPrecipitationIntensity().toString();
        currentStringArray[Globals.PRECIP_PROBABILITY] = weatherCurrent.getPrecipitationProbability().toString();
        currentStringArray[Globals.SUMMARY] = weatherCurrent.getSummary();
        currentStringArray[Globals.TIME] = weatherCurrent.getTime().toString();
        currentStringArray[Globals.MOON_PHASE] = weatherCurrent.getMoonPhase().toString();
        currentStringArray[Globals.OZONE] = weatherCurrent.getOzone().toString();
        currentStringArray[Globals.CLOUD_COVER] = weatherCurrent.getCloudCover().toString();
        currentStringArray[Globals.DEW_POINT] = weatherCurrent.getDewPoint().toString();
        currentStringArray[Globals.PRESSURE] = weatherCurrent.getPressure().toString();
        currentStringArray[Globals.HUMIDITY] = weatherCurrent.getHumidity().toString();
        currentStringArray[Globals.LAT_LONG] = weatherCurrent.getLocation().toString();
        currentStringArray[Globals.APPARENT_TEMPERATURE] = weatherCurrent.getApparentTemperature().toString();
        currentStringArray[Globals.TEMPERATURE] = weatherCurrent.getTemperature().toString();
        currentStringArray[Globals.NEAREST_STORM] = weatherCurrent.getNearestStormDistance().toString();
        currentStringArray[Globals.UV_INDEX] = weatherCurrent.getUVIndex().toString();
        currentStringArray[Globals.VISIBILITY] = weatherCurrent.getVisibility().toString();
        currentStringArray[Globals.WIND_GUST] = weatherCurrent.getWindGust().toString();
        currentStringArray[Globals.WIND_SPEED] = weatherCurrent.getWindSpeed().toString();
        currentStringArray[Globals.ICON] = weatherCurrent.getIcon();

        return currentStringArray;
    }


    /**
     * The formatHourlyWeatherForecast method creates the necessary objects to gather the hourly weather data
     * for the zipcode provided, and places the individual pieces of data into a 2D String array to be
     * passed around by the Weather Controller. The first index determines which hour you want out of the
     * next 24 hours, and the second indexes are organized as follows:
     *
     * 0 - The city, state, and zipcode
     * 1 - The precipitation intensity
     * 2 - The precipitation probability
     * 3 - The summary of the current weather
     * 4 - The time
     * 5 - The percentage of cloud coverage
     * 6 - The dew point
     * 7 - The humidity
     * 8 - The latitude and longitude
     * 9 - The moon phase
     * 10 - The ozone
     * 11 - The pressure
     * 12 - empty
     * 13 - empty
     * 14 - The UV index
     * 15 - The the distance of visibility
     * 16 - The speed of the wind gust
     * 17 - The speed of the wind
     * 18 - The apparent temperature
     * 19 - The temperature
     *
     * @param _zip The Zipcode of the location to check the weather of.
     * @return currentStringArray The 2D array of Strings containing the hourly weather information
     * for the next 24 hours.
     * @throws Exception
     */
    static public String[][] formatHourlyWeatherForecast(int _zip) throws Exception {
        String[][] hourlyStringArray = new String[24][25];
        WeatherAPI darkSkyHourly = new DarkSkyAPI(Globals.APIKEY_DARKSKY);
        GeocodioAPI geoHourly = new GeocodioAPI(Globals.APIKEY_GEOCODIO);
        LocationCoordinate location = geoHourly.zipCodeToCoordinate(_zip);

        for(int i = 0; i<24;i++) {
            WeatherData weatherHourly = darkSkyHourly.getHourlyWeatherForecast(location, i);


            hourlyStringArray[i][Globals.CITY_STATE_ZIP] = geoHourly.getNameOfLocation(_zip);
            hourlyStringArray[i][Globals.PRECIP_INTENSITY] = weatherHourly.getPrecipitationIntensity().toString();
            hourlyStringArray[i][Globals.APPARENT_TEMPERATURE] = weatherHourly.getApparentTemperature().toString();
            hourlyStringArray[i][Globals.DEW_POINT] = weatherHourly.getDewPoint().toString();
            hourlyStringArray[i][Globals.HUMIDITY] = weatherHourly.getHumidity().toString();
            hourlyStringArray[i][Globals.LAT_LONG] = weatherHourly.getLocation().toString();
            hourlyStringArray[i][Globals.OZONE] = weatherHourly.getOzone().toString();
            hourlyStringArray[i][Globals.PRECIP_PROBABILITY] = weatherHourly.getPrecipitationProbability().toString();
            hourlyStringArray[i][Globals.PRESSURE] = weatherHourly.getPressure().toString();
            hourlyStringArray[i][Globals.SUMMARY] = weatherHourly.getSummary();
            hourlyStringArray[i][Globals.TEMPERATURE] = weatherHourly.getTemperature().toString();
            hourlyStringArray[i][Globals.TIME] = weatherHourly.getTime().toString();
            hourlyStringArray[i][Globals.UV_INDEX] = weatherHourly.getUVIndex().toString();
            hourlyStringArray[i][Globals.VISIBILITY] = weatherHourly.getVisibility().toString();
            hourlyStringArray[i][Globals.WIND_GUST] = weatherHourly.getWindGust().toString();
            hourlyStringArray[i][Globals.WIND_SPEED] = weatherHourly.getWindSpeed().toString();
            hourlyStringArray[i][Globals.ICON] = weatherHourly.getIcon();
        }
        return hourlyStringArray;
    }


    /**
     * The formatDailyWeatherForecast method creates the necessary objects to gather the daily weather forecast
     * data for the zipcode provided, and places the individual pieces of data into a 2D multidimensional String
     * array to be passed around by the Weather Controller. The indexes are organized as follows:
     * The first index determines the offset of the day. (i.e. 0th index is today, 1st index is tomorrow, ect)
     * The second index determines the actual piece of weather data as follows:
     *
     * 0 - The city, state, and zipcode
     * 1 - The precipitation intensity
     * 2 - The precipitation probability
     * 3 - The summary of the current weather
     * 4 - The time
     * 5 - The percentage of cloud coverage
     * 6 - The dew point
     * 7 - The humidity
     * 8 - The latitude and longitude
     * 9 - The moon phase
     * 10 - The ozone
     * 11 - The pressure
     * 12 - The daily high temperature
     * 13 - The daily low temperature
     * 14 - The UV index
     * 15 - The the distance of visibility
     * 16 - The speed of the wind gust
     * 17 - The speed of the wind
     * 18 - The apparent temperature
     * 19 - The icon
     *
     * @param _zip the zipcode of the location to check the weather of.
     * @return dailyForecastStringArray the 2D array containing the daily weather data for the next 7 days
     * @throws Exception
     */
    static public String[][] formatDailyWeatherForecast(int _zip) throws Exception {
        String[][] dailyForecastStringArray = new String[7][25];
        WeatherAPI  darkSkyDailyForecast = new DarkSkyAPI(Globals.APIKEY_DARKSKY);
        GeocodioAPI geoDaily = new GeocodioAPI(Globals.APIKEY_GEOCODIO);
        LocationCoordinate location = geoDaily.zipCodeToCoordinate(_zip);

        for(int i = 0; i<7; i++) {
            WeatherData weatherDailyForecast0 = ((DarkSkyAPI) darkSkyDailyForecast).getDailyWeatherForecast(location, i);

            dailyForecastStringArray[i][Globals.CITY_STATE_ZIP] = geoDaily.getNameOfLocation(_zip);
            dailyForecastStringArray[i][Globals.PRECIP_INTENSITY] = weatherDailyForecast0.getPrecipitationIntensity().toString();
            dailyForecastStringArray[i][Globals.PRECIP_PROBABILITY] = weatherDailyForecast0.getPrecipitationProbability().toString();
            dailyForecastStringArray[i][Globals.SUMMARY] = weatherDailyForecast0.getSummary();
            dailyForecastStringArray[i][Globals.TIME] = weatherDailyForecast0.getTime().toString();
            dailyForecastStringArray[i][Globals.CLOUD_COVER] = weatherDailyForecast0.getCloudCover().toString();
            dailyForecastStringArray[i][Globals.DEW_POINT] = weatherDailyForecast0.getDewPoint().toString();
            dailyForecastStringArray[i][Globals.HUMIDITY] = weatherDailyForecast0.getHumidity().toString();
            dailyForecastStringArray[i][Globals.LAT_LONG] = weatherDailyForecast0.getLocation().toString();
            dailyForecastStringArray[i][Globals.MOON_PHASE] = weatherDailyForecast0.getMoonPhase().toString();
            dailyForecastStringArray[i][Globals.OZONE] = weatherDailyForecast0.getOzone().toString();
            dailyForecastStringArray[i][Globals.PRESSURE] = weatherDailyForecast0.getPressure().toString();
            dailyForecastStringArray[i][Globals.TEMP_HIGH] = weatherDailyForecast0.getTemperatureHigh().toString();
            dailyForecastStringArray[i][Globals.TEMP_LOW] = weatherDailyForecast0.getTemperatureLow().toString();
            dailyForecastStringArray[i][Globals.UV_INDEX] = weatherDailyForecast0.getUVIndex().toString();
            dailyForecastStringArray[i][Globals.VISIBILITY] = weatherDailyForecast0.getVisibility().toString();
            dailyForecastStringArray[i][Globals.WIND_GUST] = weatherDailyForecast0.getWindGust().toString();
            dailyForecastStringArray[i][Globals.WIND_SPEED] = weatherDailyForecast0.getWindSpeed().toString();
            dailyForecastStringArray[i][Globals.ICON] = weatherDailyForecast0.getIcon().toString();
        }

        return dailyForecastStringArray;
    }
}
