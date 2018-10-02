package WeatherModels;
/**
 * Last updated 9/24/18
 *
 * The APIsetup class takes a longitude and latitude, and makes a call to the
 * DarkSkyAPI to retrieve and return a JSON file containing weather information.
 * The API has 4 major categories: Currently, Minutely, Hourly, and Daily
 *
 * @authors John Isaac Wilkinson, Harman Bains
 */

import java.io.*;
import java.net.*;
import org.json.JSONException;
import org.json.JSONObject;

public class APIsetup {

    protected double _longitude;
    protected double _latitude;

    public APIsetup(double _longitude, double _latitude) {
        this._longitude = _longitude;
        this._latitude = _latitude;
    }

    public JSONObject getWeatherJSON() throws MalformedURLException, IOException, JSONException {
        /*
        This is the String holding the first part of the URL. It is missing
        the longitude and latitude because they will be concatinated at the end
        by urlStringBuilder in the next 3 lines.
        */
        StringBuilder urlStringBuilder = new StringBuilder("https://api.darksky.net/forecast/1fffd54fe65a40d92a13eb5d7e3e1fee/");
        urlStringBuilder.append(_longitude);
        urlStringBuilder.append(',');
        urlStringBuilder.append(_latitude);
        //StringBuilder to String.
        String URL = urlStringBuilder.toString();
        //Creating a URL object with the full URL String and a HttpURLConection object.
        URL urlObj = new URL(URL);
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
        //Parse the input stream.
        BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //Create the JSON object from the input sream and return it
        JSONObject weatherJSON = new JSONObject(response.toString());
        return weatherJSON;
    }
}
