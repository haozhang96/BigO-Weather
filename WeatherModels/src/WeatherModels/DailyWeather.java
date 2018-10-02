package WeatherModels;

/**
 * Last updated 10/2/18
 *
 * The Daily class takes a JSON object from the DarkSkyAPI, and provides methods
 * to return various information about the weather on a daily basis.
 *
 * There are additional methods that need to be added to this class.
 *
 * @authors Steven Tran, Harmain Bains
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
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("apparentTemperatureHigh");
    }

    public double getApparentTemperatureLow() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("apparentTemperatureLow");
    }

    public double getTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("time");
    }

    public String getSummary() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getString("summary");
    }

    public double getSunriseTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("sunriseTime");
    }

    public double getSunsetTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("sunsetTime");
    }

    public double getMoonPhase() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("moonPhase");
    }

    public double getPrecipIntensity() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("precipIntensity");
    }

    public double getPrecipIntensityMax() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("precipIntensityMax");
    }

    public double getPrecipIntensityMaxTime() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("precipIntensityMaxTime");
    }

    public double getPrecipProbability() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("precipProbability");
    }

    public String getPrecipType() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getString("precipType");
    }

    public double getTemperatureHigh() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("temperatureHigh");
    }

    public double getTemperatureLow() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("temperatureLow");
    }

    public double getDewPoint() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("dewPoint");
    }

    public double getHumidity() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("humidity");
    }

    public double getPressure() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("pressure");
    }

    public double getWindSpeed() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("windSpeed");
    }

    public double getUVIndex() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("uvIndex");
    }

    public int getVisibility() throws JSONException {
        return _jsonObj.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getInt("visibility");
    }

}
