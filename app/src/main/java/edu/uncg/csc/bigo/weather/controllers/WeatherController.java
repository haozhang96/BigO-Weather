package edu.uncg.csc.bigo.weather.controllers;

import edu.uncg.csc.bigo.weather.models.weather.WeatherDataStringFormatter;

/**
 * The WeatherController class acts as the controller between the weather models and the view files.
 * It contains methods which will return a String array of the type of weather data you choose, one can
 * choose Current, Daily, Hourly, or Minutely weather.
 *
 * updated 11/14/2018
 * @author John Isaac Wilkinson
 */
public final class WeatherController {

    /**
     * The getWeatherCurrent method returns a String array of the Current weather data, the format of the
     * String array is described in the WeatherDataStringFormatter class.
     * @param _zip The zipcode integer.
     * @return test The String array containing the current weather data.
     * @throws Exception
     */
    public static String[] getWeatherCurrent(int _zip) throws Exception {
        String[] test = WeatherDataStringFormatter.formatCurrentWeather(_zip);
        return test;

}   /**
     * The getWeatherDaily method returns a String array of the Daily weather data, the format of the
     * String array is described in the WeatherDataStringFormatter class.
     * @param _zip The zipcode integer.
     * @return test The String array containing the daily weather data.
     * @throws Exception
     */
/*    public static String[] getWeatherDaily(int _zip) throws Exception {
        String[] test = WeatherDataStringFormatter.formatDailyWeather(_zip);
        return test;
    }*/

    /**
     * The getWeatherHourlyForecast method returns a 2D string array of the Hourly weather data, the format
     * of the String array is described in the WeatherDataStringFormatter class.
     * @param _zip
     * @return test The 2D String array containing the next 24 hours of weather data.
     * @throws Exception
     */
    public static String[][] getWeatherHourlyForecast(int _zip) throws Exception {
        String[][] test = WeatherDataStringFormatter.formatHourlyWeatherForecast(_zip);
        return test;
    }


    /**
     * The getWeatherDailyForecast method returns a 2D multidimensional array, the format of the
     * 2D String array is described in the WeatherDataStringFormatter class.
     * @param _zip the zipcode integer.
     * @return test the 2D String array containing the daily forecast weather data.
     * @throws Exception
     */
    public static String[][] getWeatherDailyForecast(int _zip) throws Exception{
        String[][] test = WeatherDataStringFormatter.formatDailyWeatherForecast(_zip);
        return test;
    }

}