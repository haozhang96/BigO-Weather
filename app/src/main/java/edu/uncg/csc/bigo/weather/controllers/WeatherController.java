package edu.uncg.csc.bigo.weather.controllers;
/**
 * This class handles the API fallback mechanism and caching of weather data.
 *
 * @updated 2018/10/30
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.api.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.util.DynamicPackageLoader;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.util.caching.TimedCache;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;


public final class WeatherController {
    private static final TimedCache<LocationCoordinate, WeatherData>
            weatherDataCache = new TimedCache();


    private static Class[] apis;
    static {
        try {
            WeatherController.apis = DynamicPackageLoader.loadPackageAs("mypackage", WeatherAPI.class);
        } catch (Exception e) {
            WeatherController.apis = null;
        }
    }


    private static final WeatherAPI getApi() {
        try {
            Class[] apis = DynamicPackageLoader.loadPackageAs("mypackage", WeatherAPI.class);

            for (Object api : apis) {
                return (WeatherAPI) api;
            }
        } catch (Exception e) {

        } finally {
            return null;
        }
    }
}