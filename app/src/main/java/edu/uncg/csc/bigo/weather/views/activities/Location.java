package com.example.bigo.weatherapp.views.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bigo.weatherapp.models.api.LocationAPI;
import com.example.bigo.weatherapp.models.api.WeatherAPI;
import com.example.bigo.weatherapp.models.api.weather.DarkSkyAPI;
import com.example.bigo.weatherapp.models.api.location.GeocodioAPI;
import com.example.bigo.weatherapp.models.metrics.units.TemperatureUnit;
import com.example.bigo.weatherapp.models.util.LocationCoordinate;
import com.example.bigo.weatherapp.models.weather.WeatherData;
import com.example.bigo.weatherapp.R;


public class Location extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView TextViewZipFormat;
    private EditText location;
    private Button go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //Initialize the EditText box.
        location = (EditText) findViewById(R.id.location);
        //Initialize the button.
        go = (Button) findViewById(R.id.go);
        //Initialize the message TextView box.
        mTextMessage = (TextView) findViewById(R.id.message);
        //Initialize the formatting message TextView box.
        TextViewZipFormat = (TextView) findViewById(R.id.TextViewZipFormat);
        //Set the button to listen for clicks, and do something when it hears one.
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make sure the user inputs a properly formatted zip.
                if (location.getText().toString().length() < 5 || location.getText().toString().isEmpty()) {
                    TextViewZipFormat.setText("Enter a Properly Formatted Zip");
                    mTextMessage.setText(" ");
                    location.setText("");
                } else if (location.getText().toString().length() > 5) {
                    TextViewZipFormat.setText("Enter a Properly Formatted Zip");
                    mTextMessage.setText(" ");
                    location.setText("");
                }
                //If the zip is correctly formatted assign it to zipCode
                else if (location.getText().toString().length() == 5) {
                    int zipCode = Integer.valueOf(location.getText().toString());
                    TextViewZipFormat.setText("");
                }
            }
        });
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
                int zipCode = Integer.valueOf(location.getText().toString());
                LocationCoordinate location = geocodio.zipCodeToCoordinate(zipCode);
                message.append(String.format(
                        "Coordinate of ZIP code %d: %f, %f",
                        zipCode, location.getLatitude(), location.getLongitude()
                ));

                // Get the current weather data for the ZIP code.
                WeatherData testCurrent = darkSky.getCurrentWeather(location);
                message.append("\n\nCurrently:\n" + testCurrent);
                message.append("\nTemperature in C: " + testCurrent.getTemperature().convertTo(TemperatureUnit.CELSIUS));

                // Get the minutely weather data for the ZIP code.
                // This one is very bare minimum.
                //WeatherData testMinutely = darkSky.getMinutelyWeather(location);
                //message.append("\n\nMinutely:\n" + testMinutely);

                // Get the hourly weather data for the ZIP code.
                WeatherData testHourly = darkSky.getHourlyWeather(location);
                message.append("\n\nHourly:\n" + testHourly);

                // Get the daily weather data for the ZIP code.
                WeatherData testDaily = darkSky.getDailyWeather(location);
                message.append("\n\nDaily:\n" + testDaily);

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
