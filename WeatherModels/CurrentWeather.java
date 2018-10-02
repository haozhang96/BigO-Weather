package WeatherModels;

/**
 * Last updated 9/24/18
 *
 * The CurrentWeather class takes a JSON object from the DarkSkyAPI, and
 * provides methods to return various information about the current weather.
 *
 * @authors John Isaac Wilkinson, Harman Bains
 */
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
/**
 * This class provides methods that will return the current weather information
 * by making calls to the DarkSkyAPI. Last edited September the 20th, 2018.
 *
 * @author John Isaac Wilkinson
 */
public class CurrentWeather {

    //The DarkSkyAPI JSONObject holding the weather info. (Still trying to decide what needs to be static)
    protected JSONObject _jsonObj;


    public CurrentWeather(JSONObject _jsonObj) {
        this._jsonObj = _jsonObj;
    }

    /*
    The following methods return various information about the weather from
    the JSON created with the weather information from the DarkSkyAPI.
     */
    public double getApparentTemperature() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("apparentTemperature");
    }


    public double getCloudCover() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("cloudCover");
    }


    public double getDewPoint() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("dewPoint");
    }


    public double getHumidity() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("humidity");
    }


    public double getNearestStormDistance() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("nearestStormDistance");
    }


    public double getOzone() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("ozone");
    }


    public double getPrecipIntensity() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("precipIntensity");
    }


    public double getPrecipProbability() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("precipProbability");
    }


    public double getPressure() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("pressure");
    }


    public String getSummary() throws JSONException {
        return _jsonObj.getJSONObject("currently").getString("summary");
    }


    public double getTemperature() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("temperature");
    }

    /*
    The getTime() method takes the 10 digit time code from the DarkSky JSON
    and uses the Date, TimeZone, and SimpleDateFormat classes to conver it to a readable format
    which it then returns as a String.
    */
    public String getTime() throws JSONException {
        double timeCode = _jsonObj.getJSONObject("currently").getDouble("time");
        long longTimeCode;
        longTimeCode = (new Double(timeCode).longValue());
        Date timeDate = new Date(longTimeCode*1000L);
        SimpleDateFormat mySDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        mySDF.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String stringTime = mySDF.format(timeDate);
        return stringTime;
    }


    public double getUVIndex() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("uvIndex");
    }


    public double getVisibility() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("visibility");
    }


    public double getWindGust() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("windGust");
    }


    public double getWindSpeed() throws JSONException {
        return _jsonObj.getJSONObject("currently").getDouble("windSpeed");
    }

}
