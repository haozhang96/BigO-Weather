package WeatherModels;

/**
 * Last updated 10/2/18
 *
 * The TestController class is entirely for the developers. It creates objects
 * for the classes in the WeatherModels package and tests their various methods.
 *
 * @authors John Isaac Wilkinson, Steven Tran
 */
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class TestController {

    public static void main(String[] args) throws IOException, MalformedURLException, JSONException, Exception {
        //Prompts the user for a zip and prints the longitude and latitude as well as the response code.
        //ZipToLongLat.getZipCode();
        //Creates a test APIsetup object with the location for Greensboro.
        APIsetup testAPI = new APIsetup(36.0725, -79.815428);
        //Gets the JSON from the APIsetup object we just created.
        JSONObject testJSON = testAPI.getWeatherJSON();


        System.out.println("\nDaily:");
        DailyWeather testDaily = new DailyWeather(testJSON);
        System.out.println("getSummary: " + testDaily.getSummary());
        System.out.println("getApparentTemperatureHigh: " + testDaily.getApparentTemperatureHigh());
        System.out.println("getApparentTemperatureLow: " + testDaily.getApparentTemperatureLow());
        System.out.println("getMoonPhase: " + testDaily.getMoonPhase());
        System.out.println("getPrecipIntensity: " + testDaily.getPrecipIntensity());
        System.out.println("getPrecipProbability: " + testDaily.getPrecipProbability());
        System.out.println("getPrecipType: " + testDaily.getPrecipType());
        System.out.println("getDewPoint: " + testDaily.getDewPoint());
        System.out.println("getHumidity: " + testDaily.getHumidity());
        System.out.println("getPressure: " + testDaily.getPressure());
        System.out.println("getWindSpeed: " + testDaily.getWindSpeed());
        System.out.println("getUVIndex: " + testDaily.getUVIndex());
       
    }
}
