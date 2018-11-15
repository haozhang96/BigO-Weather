package edu.uncg.csc.bigo.weather.models.weather;

/**
 * This class creates an object that holds the zipcode and LocationCoordinates in one object. Used
 * in the DataStore class to implement the sortFile method.
 *
 * @author Harman Bains
 * @updated 11/14/2018
 */

import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;

public class WeatherObject {

    String zipCode;
    LocationCoordinate coordinates;

    public WeatherObject (String _zipCode, LocationCoordinate _coordinates){
        this.zipCode = _zipCode;
        this.coordinates = _coordinates;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocationCoordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LocationCoordinate coordinates) {
        this.coordinates = coordinates;
    }
}
