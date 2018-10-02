package WeatherModels;

/**
 * Last updated 9/24/18
 *
 * The MinutelyWeather class takes a JSON object from the DarkSkyAPI, and
 * provides methods to return various information about the minute by minute
 * weather.
 *
 * There are additional methods that still need to be added to this class.
 *
 * @authors John Isaac Wilkinson
 */
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class MinutelyWeather {

    //The JSON object with weather data. (Not sure what needs to be static here).
    protected JSONObject _jsonObj;

    //Constructor asks for a JSON object to get the weather data from.
    public MinutelyWeather(JSONObject _jsonObj) {
        this._jsonObj = _jsonObj;
    }


    public String getSummary() throws JSONException {
        return _jsonObj.getJSONObject("minutely").getString("summary");
    }
}
