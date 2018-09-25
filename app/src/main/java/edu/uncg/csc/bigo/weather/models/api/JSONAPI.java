package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a JSON REST API.
 * It is only to be used by final API classes extending it.
 *
 * @updated 2018/09/25
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.MissingFormatArgumentException;
import org.json.JSONException;
import org.json.JSONObject;


public abstract class JSONAPI extends RESTAPI {
    protected JSONAPI(String _endpoint) {
        super(_endpoint);
    }

    @Override
    protected JSONObject getResponse(Object ..._endpointFormatters)
            throws MissingFormatArgumentException, IOException, JSONException
    {
        // Create a URL object from the endpoint URL string formatted using any specified formatters
        URL url = new URL(String.format(this.endpoint, _endpointFormatters));

        // Open a HttpURLConnection using the endpoint URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get the response string from the API
        String responseString = connection.getResponseMessage();

        // Convert the response string into a JSONObject
        JSONObject responseJSON = new JSONObject(responseString);
        return responseJSON;
    }
}