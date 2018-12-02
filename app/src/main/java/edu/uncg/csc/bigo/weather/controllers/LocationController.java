package edu.uncg.csc.bigo.weather.controllers;

import edu.uncg.csc.bigo.weather.models.api.LocationAPI;
import edu.uncg.csc.bigo.weather.models.api.location.*;
import edu.uncg.csc.bigo.weather.models.util.Globals;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;

public class LocationController {
    private static GeocodioAPI api = new GeocodioAPI(Globals.APIKEY_GEOCODIO);

    public static LocationCoordinate getCurrentCoordinate() throws Exception {
        return LocationController.api.getCurrentCoordinate();
    }


    /**
     * This method defines a way of checking whether a ZIP code is valid based on the API sub-class'
     *     implementation.
     * @return A boolean indicating whether the given ZIP code is valid
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    public static boolean isZipCodeValid(int _zipCode) throws Exception {
        return LocationController.api.isZipCodeValid(_zipCode);
    }


    /**
     * This method defines a way of converting a ZIP code to a coordinate based on the API
     *     sub-class' implementation.
     * @param _zipCode A ZIP code to get the coordinate of
     * @return A LocationCoordinate object holding the latitude and longitude of the given ZIP code
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    public static LocationCoordinate zipCodeToCoordinate(int _zipCode) throws Exception {
        return LocationController.api.zipCodeToCoordinate(_zipCode);
    }
}
