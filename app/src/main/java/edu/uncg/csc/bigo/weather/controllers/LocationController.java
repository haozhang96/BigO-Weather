package edu.uncg.csc.bigo.weather.controllers;


import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.util.caching.TimeExpirableCache;


public final class LocationController {
    private static final TimeExpirableCache<Integer, LocationCoordinate>
            locationCoordinateCache = new TimeExpirableCache();
}
