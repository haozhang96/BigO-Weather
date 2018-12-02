package edu.uncg.csc.bigo.weather.models.api.location;
/**
 * This interface describes a location-related API.
 *
 * @updated 2018/11/01
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;


public interface LocationAPI {
    /**
     * This method defines a way of getting the current location's coordinate based on the API
     *     sub-class' implementation.
     * @return A LocationCoordinate object holding the latitude and longitude of the current
     *     location
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    LocationCoordinate getCurrentCoordinate() throws Exception;


    /**
     * This method defines a way of checking whether a ZIP code is valid based on the API sub-class'
     *     implementation.
     * @return A boolean indicating whether the given ZIP code is valid
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    boolean isZipCodeValid(int _zipCode) throws Exception;

    /**
     * This method defines a way of converting a ZIP code to a coordinate based on the API
     *     sub-class' implementation.
     * @param _zipCode A ZIP code to get the coordinate of
     * @return A LocationCoordinate object holding the latitude and longitude of the given ZIP code
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    LocationCoordinate zipCodeToCoordinate(int _zipCode) throws Exception;
}