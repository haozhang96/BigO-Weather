package com.example.bigo.weatherapp.models.api;

/**
 * This abstract class describes a JSON-based REST API.
 * It is only to be used by API classes extending it.
 *
 * @updated 2018/09/25
 * @authors John Isaac Wilkinson, Harman Bains, Hao Zhang
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.MissingFormatArgumentException;
import org.json.JSONException;
import org.json.JSONObject;


public abstract class JSONAPI extends RESTAPI {
    /**
     * This constructs a JSONAPI instance with the endpoint URL string of a JSON-based REST API.
     * @param _endpoint A JSON-based REST API endpoint URL string
     */
    protected JSONAPI(String _endpoint) {
        super(_endpoint);
    }


    /**
     * This method defines a way of invoking the pre-set API endpoint URL and receiving a response.
     * @param _endpointFormatters Formatters to format the API endpoint URL on invocation
     * @return A JSONObject that was returned from the API endpoint
     * @throws MissingFormatArgumentException An exception indicating that an insufficient number of
     *     formatters had been passed to format the API endpoint URL before invocation
     * @throws IOException An exception indicating a problem with the connection to the API endpoint
     * @throws JSONException An exception indicating a problem with parsing the API endpoint's
     *     response as a JSONObject
     */
    @Override
    protected JSONObject getResponse(Object ..._endpointFormatters)
            throws MissingFormatArgumentException, IOException, JSONException
    {
        // Create a URL object from the endpoint URL string formatted using the specified
        // formatters.
        URL url = new URL(String.format(this.endpoint, _endpointFormatters));

        // Open a HttpURLConnection using the formatted endpoint URL.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get the full response body from the API endpoint as a buffer.
        StringBuffer responseBuffer = new StringBuffer();
        BufferedReader inputReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        String inputLine;
        while ((inputLine = inputReader.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        inputReader.close();

        // Convert the response buffer into a JSONObject.
        JSONObject responseJSON = new JSONObject(responseBuffer.toString());
        return responseJSON;
    }
}