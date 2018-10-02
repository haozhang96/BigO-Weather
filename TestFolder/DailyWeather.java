package WeatherModels;

/**
 * Last updated 9/26/18
 *
 * The Daily class takes a JSON object from the DarkSkyAPI, and provides methods
 * to return various information about the 7 day weather.
 *
 * There are additional methods that need to be added to this class.
 *
 * @authors Steven Tran
 */
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyWeather {

    //The JSON object with weather data. (Not sure what needs to be static here).
    protected JSONObject _jsonObj;

    //The constructor asks for a JSON to read the weather data from.
    public DailyWeather(JSONObject _jsonObj) {
        this._jsonObj = _jsonObj;
    }

    public double getApparentTemperatureHigh() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("apparentTemperatureHigh");
    }

    public double getApparentTemperatureLow() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("apparentTemperatureLow");
    }

    public double getTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("time");
    }

    public String getSummary() throws JSONException {
        return _jsonObj.getJSONObject("daily").getString("summary");
    }

    public double getSunriseTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("sunriseTime");
    }

    public double getSunsetTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("sunsetTime");
    }

    public double getMoonPhase() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("moonPhase");
    }

    public double getPrecipIntensity() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("precipIntensity");
    }

    public double getPrecipIntensityMax() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("precipIntensityMax");
    }

    public double getPrecipIntensityMaxTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("precipIntensityMaxTime");
    }

    public double getPrecipProbability() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("precipProbability");
    }

    public String getPrecipType() throws JSONException {
        return _jsonObj.getJSONObject("daily").getString("precipType");
    }

    public double getTemperatureHigh() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("temperatureHigh");
    }

    public double getTemperatureLow() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("temperatureLow");
    }

    public double getDewPoint() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("dewPoint");
    }

    public double getHumidity() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("humidity");
    }

    public double getPressure() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("pressure");
    }

    public double getWindSpeed() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("windSpeed");
    }

    public double getUVIndex() throws JSONException {
        return _jsonObj.getJSONObject("daily").getDouble("uvIndex");
    }

    public int getVisibility() throws JSONException {
        return _jsonObj.getJSONObject("daily").getInt("visibility");
    }

}
