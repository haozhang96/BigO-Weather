package edu.uncg.csc.bigo.weather.controllers;


import edu.uncg.csc.bigo.weather.models.api.LocationAPI;
import edu.uncg.csc.bigo.weather.models.util.DynamicPackageLoader;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.util.caching.TimedCache;


public final class LocationController {
    private static final TimedCache<Integer, LocationCoordinate>
            locationCoordinateCache = new TimedCache();
}
