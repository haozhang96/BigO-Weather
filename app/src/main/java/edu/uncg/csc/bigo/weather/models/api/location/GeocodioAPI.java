package edu.uncg.csc.bigo.weather.models.api.location;
/**
 * This class defines the usage of the Geocodio location API.
 *
 * @updated 09/27/2018
 * @authors Harman Bains, Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.api.LocationAPI;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class GeocodioAPI extends LocationAPI {
    public GeocodioAPI(String _apiKey) {
        super(String.format("https://api.geocod.io/v1.3/geocode?q=%%d&api_key=%s", _apiKey));
    }


    /**
     * The getCurentCoordinate method is currently unsupported, but may be used in the future to
     * return the current coordinate being used by the Geocodio API.
     * @throws UnsupportedOperationException
     */
    public LocationCoordinate getCurrentCoordinate() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This method is currently unsupported.");
    }


    /**
     * The getNameOfLocation method takes a zipcode as a parameter and returns the City, State, and
     * zipcode of the location provided.
     *
     * @param _zipCode The zipcode passed in by the user.
     * @return formattedLocation The formatted address of the location referenced by the zipcode passed.
     * @throws IOException An exception indicating a problem with the connection to the API endpoint.
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *      response as a JSONObject.
     */
    public String getNameOfLocation(int _zipCode) throws IOException, JSONException {
        JSONObject locationJSON = this.getResponse(_zipCode)
                .getJSONArray("results")
                .getJSONObject(0);

        String formattedLocation = locationJSON.getString("formatted_address");
        return formattedLocation;
    }


    /**
     * The zipCodeToCoordinate method takes a zipcode as a parameter, and returns a LocationCoordinate
     * containing the longitude and latitude of the zipcode provided.
     *
     * @param _zipCode A ZIP code to get the coordinate of.
     * @return
     * @throws IOException An exception indicating a problem with the connection to the API endpoint.
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *      response as a JSONObject.
     */
    public LocationCoordinate zipCodeToCoordinate(int _zipCode) throws IOException, JSONException {
        JSONObject locationJSON = this.getResponse(_zipCode)
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("location");

        double latitude = locationJSON.getDouble("lat"),
                longitude = locationJSON.getDouble("lng");
        return new LocationCoordinate(latitude, longitude);
    }
}