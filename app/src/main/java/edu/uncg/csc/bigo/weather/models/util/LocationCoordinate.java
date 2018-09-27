package edu.uncg.csc.bigo.weather.models.util;
/**
 * This class defines an immutable object holding the latitude and longitude of a location.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


public class LocationCoordinate {
    private final double latitude;
    private final double longitude;

    /**
     * This constructs a LocationCoordinate instance holding the latitude and longitude of a
     *     location.
     * @param _latitude The latitude of the location
     * @param _longitude The longitude of the location
     */
    public LocationCoordinate(double _latitude, double _longitude) {
        this.latitude = _latitude;
        this.longitude = _longitude;
    }


    /**
     * This method returns the latitude of the coordinate.
     * @return The latitude of the coordinate
     */
    public double getLatitude() {
        return this.latitude;
    }


    /**
     * This method returns the longitude of the coordinate.
     * @return The longitude of the coordinate
     */
    public double getLongitude() {
        return this.longitude;
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string
     */
    @Override
    public String toString() {
        return String.format("LocationCoordinate[%f, %f]", this.latitude, this.longitude);
    }
}