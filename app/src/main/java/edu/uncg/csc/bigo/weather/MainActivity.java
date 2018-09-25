package edu.uncg.csc.bigo.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


import edu.uncg.csc.bigo.weather.models.api.LocationAPI;
import edu.uncg.csc.bigo.weather.models.api.WeatherAPI;
import edu.uncg.csc.bigo.weather.models.api.weather.DarkSkyAPI;
import edu.uncg.csc.bigo.weather.models.api.location.GeocodioAPI;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Testing code
        new Test().execute();
    }


    /**
     * This is where we will test things
     */
    private class Test extends AsyncTask<Void, Void, String> {
        private static final String APIKEY_GEOCODIO = "f0905446086d00db93d937b64d0e999b3b45d5d";
        private static final String APIKEY_DARKSKY = "1fffd54fe65a40d92a13eb5d7e3e1fee";


        protected String doInBackground(Void... nothing) {
            try  {
                // Store a message buffer to append strings to.
                StringBuffer message = new StringBuffer();

                // Initialize the APIs.
                WeatherAPI darkSky = new DarkSkyAPI(Test.APIKEY_DARKSKY);
                LocationAPI geocodio = new GeocodioAPI(Test.APIKEY_GEOCODIO);

                // Get the location of the ZIP code.
                int zipCode = 27409;
                LocationCoordinate location = geocodio.zipCodeToCoordinate(zipCode);
                message.append(String.format(
                        "Coordinate of ZIP code %d: %f, %f",
                        zipCode, location.getLatitude(), location.getLongitude()
                ));

                // Get the current weather data for the ZIP code.
                WeatherData testCurrent = darkSky.getCurrentWeather(location);
                message.append(String.format("\n\nWeather at ZIP code %d:\n\nCurrently:\ngetSummary: %s", zipCode, testCurrent.getSummary()));
                message.append("\ngetApparentTemperature: " + testCurrent.getApparentTemperature());
                message.append("\ngetCloudCover: " + testCurrent.getCloudCover());
                message.append("\ngetDewPoint: " + testCurrent.getDewPoint());
                message.append("\ngetHumidity: " + testCurrent.getHumidity());
                message.append("\ngetNearestStormDistance: " + testCurrent.getNearestStormDistance());
                message.append("\ngetOzone: " + testCurrent.getOzone());
                message.append("\ngetPrecipitationIntensity: " + testCurrent.getPrecipitationIntensity());
                message.append("\ngetPrecipitationProbability: " + testCurrent.getPrecipitationProbability());
                message.append("\ngetPressure: " + testCurrent.getPressure());
                message.append("\ngetTemperature: " + testCurrent.getTemperature());
                message.append("\ngetTime: " + testCurrent.getTime());
                message.append("\ngetUVIndex: " + testCurrent.getUVIndex());
                message.append("\ngetVisibility: " + testCurrent.getVisibility());
                message.append("\ngetWindGust: " + testCurrent.getWindGust());
                message.append("\ngetWindSpeed: " + testCurrent.getWindSpeed());

                // Get the minutely weather data for the ZIP code.
                // This one is very bare minimum.
                WeatherData testMinutely = darkSky.getMinutelyWeather(location);
                message.append("\n\nMinutely:\ngetTime: " + testMinutely.getTime());

                // Get the hourly weather data for the ZIP code.
                WeatherData testHourly = darkSky.getHourlyWeather(location);
                message.append("\n\nHourly:\ngetSummary: " + testHourly.getSummary());
                message.append("\ngetTime: " + testHourly.getTime());

                // Get the daily weather data for the ZIP code.
                WeatherData testDaily = darkSky.getDailyWeather(location);
                message.append("\n\nDaily:\ngetSummary: " + testDaily.getSummary());
                message.append("\ngetTime: " + testDaily.getTime());

                // Return the built message
                return message.toString();
            } catch (Exception exception) {
                return exception.toString();
            }
        }


        protected void onPostExecute(String result) {
            mTextMessage.setText(result);
        }
    }
}