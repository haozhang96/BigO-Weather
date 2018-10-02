package WeatherModels;

/**
 * Last updated 9/24/18
 *
 * The HourlyWeather class takes a JSON object from the DarkSkyAPI, and provides
 * methods to return various information about the hour by hour weather.
 *
 * There are additional methods that need to be added to this class.
 *
 * @authors John Isaac Wilkinson
 */
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class HourlyWeather {

    //The JSON object with weather data. (Not sure what needs to be static here).
    protected JSONObject _jsonObj;

    //The constructor asks for a JSON to read the weather data from.
    public HourlyWeather(JSONObject _jsonObj) {
        this._jsonObj = _jsonObj;
    }


    public double getPrecipIntensity() throws JSONException {
        return _jsonObj.getJSONObject("hourly").getDouble("precipIntensity");
    }


    public double getPrecipProbability() throws JSONException {
        return _jsonObj.getJSONObject("hourly").getDouble("precipProbability");
    }


    //The following methods return some of the weather data from the JSON.
    public String getSummary() throws JSONException {
        return _jsonObj.getJSONObject("hourly").getString("summary");
    }


    public double getTime() throws JSONException {
        return _jsonObj.getJSONObject("hourly").getDouble("time");
    }

}
