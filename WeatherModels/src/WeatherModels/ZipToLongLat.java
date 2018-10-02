package WeatherModels;

/**
 * Last updated 9/24/18 The ZipToLongLat class takes a zipcode from the user,
 * and converts it to a longitude and latitude using the Geocodio API.
 *
 * Currently ZipToLongLat only prints the longitude and latitude. In the future
 * it will return the values so that it may be used by the APIsetup class. Also
 * we will need to shorten the method as it is about 30 lines long.
 *
 * @authors Harman Bains
 */
import java.io.*;
import java.net.*;
import org.json.JSONObject;
import java.util.Scanner;

public class ZipToLongLat {

    /*
    The API that converts zip code to coordinates is Geocodio.
    https://www.geocod.io

    This method takes a zip code and returns the latitude and longitiude of the zip.
    The Dark Sky API uses longitude and latitude to determine weather.
     */
    public static void getZipCode() throws Exception {

        /*
        Scanner to read and store the zip code from user.
         */
        Scanner readZip = new Scanner(System.in);
        System.out.println("Enter a ZIP Code.");
        int zipInteger = readZip.nextInt();
        readZip.close();

        /*
        The url uses zipInteger which is the zip code from the user to determine coordinates.
         */
        String url = "https://api.geocod.io/v1.3/geocode?q=" + zipInteger + "&api_key=f0905446086d00db93d937b64d0e999b3b45d5d";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        //Create and parse the input stream.
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String (commented this out to make the formatting look nicer for the code review).
        //System.out.println(response.toString());

        //Read JSON response and print.
        JSONObject myResponseZip = new JSONObject(response.toString());

        /*
        Check to make the Geocodio API can make a response.
         */
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        System.out.println("");
        /*
        Print the longitude and latitude for the location. Need to check if there
        is a simpler way to implement this.
         */
        System.out.println("Latitude: " + myResponseZip.getJSONArray("results").getJSONObject(0).getJSONObject("location").getDouble("lat"));
        System.out.println("Longitude: " + myResponseZip.getJSONArray("results").getJSONObject(0).getJSONObject("location").getDouble("lng"));

    }

}
