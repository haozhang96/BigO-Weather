package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a JSON-based location-related REST API.
 * It is only to be used by API classes extending it.
 *
 * @updated 09/25/2018
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;

public abstract class LocationAPI extends JSONAPI {
    protected LocationAPI(String _endpoint) {
        super(_endpoint);
    }

    /**
     * This method defines a way of getting the current location's coordinate based on the API
     *     sub-class' implementation.
     * @return A LocationCoordinate object holding the latitude and longitude of the current
     *     location.
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation.
     */
    public abstract LocationCoordinate getCurrentCoordinate() throws Exception;


    /**
     * This method defines a way of converting a ZIP code to a coordinate based on the API
     *     sub-class' implementation.
     * @param _zipCode A ZIP code to get the coordinate of.
     * @return A LocationCoordinate object holding the latitude and longitude of the given ZIP code.
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation.
     */
    public abstract LocationCoordinate zipCodeToCoordinate(int _zipCode) throws Exception;
}