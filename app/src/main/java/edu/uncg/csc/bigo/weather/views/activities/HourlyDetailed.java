package edu.uncg.csc.bigo.weather.views.activities;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;

/**
 * This class shows the detailed version of Hourly Weather. It shows precipitation, wind speed, wind
 * gust, humidity, and ozone.
 *
 *
 * @Updated: 12/3/2018
 * @Author: Steven Tran
 */
public class HourlyDetailed extends AppCompatActivity {

    //The buttons that represent the hours.
    private Button hourDetailOne;
    private Button hourDetailTwo;
    private Button hourDetailThree;
    private Button hourDetailFour;
    private Button hourDetailFive;
    private Button hourDetailSix;
    private Button hourDetailSeven;
    private Button hourDetailEight;
    private Button hourDetailNine;
    private Button hourDetailTen;
    private Button hourDetailEleven;
    private Button hourDetailTwelve;

    //The text box that represents the Hourly detailed data.
    private TextView details;

    //The controller for detailed weather forecast.
    private String[][] detailedWeatherForecastController;

    //The array of the buttons for looping.
    private Button[] buttons = {hourDetailOne, hourDetailTwo, hourDetailThree, hourDetailFour,
            hourDetailFive, hourDetailSix, hourDetailSeven, hourDetailEight, hourDetailNine,
            hourDetailTen, hourDetailEleven, hourDetailTwelve};


    //The array of the integers for button ID.
    private Integer[] buttonID = {R.id.hourDetailOne, R.id.hourDetailTwo, R.id.detailedThree,
            R.id.hourDetailFour, R.id.hourDetailFive, R.id.hourDetailSix, R.id.hourDetailSeven,
            R.id.hourDetailEight, R.id.hourDetailNine, R.id.hourDetailTen, R.id.hourDetailEleven,
            R.id.hourDetailTwelve};

    /**
     * This method is create when this activity starts up to initialize the variables and execute
     * the AsyncTask.
     *
     * @param _savedInstanceState
     */
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        //Sets the hourly detailed view.
        setContentView(R.layout.activity_hourly_detailed);

        //This creates the back buttons.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize the button ID.
        for (int i = 0; i < 7; i++) {
            buttons[i] = findViewById(buttonID[i]);
        }

        //Initialize the textbox.
        details = findViewById(R.id.hourlyDetails);

        //Executing the data retrieval for hourly detailed weather.
        new DetailedDataRetrieval().execute();
    }

    /**
     * This method is responsible for allowing the back button to go back.
     *
     * @param _item
     * @return super.onOptionsItemSelected(_item)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem _item) {
        int id = _item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(_item);
    }

    /**
     * This class retrieves the data through the controller to append the messages into the textview.
     *
     * @Updated: 12/3/2018
     * @Author Steven Tran
     */
    protected class DetailedDataRetrieval extends AsyncTask<Void, Void, String> {

        /**
         * This background method is used to initialize the controller and append the data to the StringBuffer.
         *
         * @param _voids
         * @return (String) StringBuffer in order to display it in the textview.
         */
        @Override
        protected String doInBackground(Void... _voids) {

            //Shared preference for hourly detail.
            SharedPreferences global = getSharedPreferences("GLOBAL", MODE_PRIVATE);


            try {
                //Initialize the controller to get the weather hourly forecast.
                detailedWeatherForecastController = WeatherController.getWeatherHourlyForecast(global.getInt("ZIP", 27403));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Shared preference for matching the buttons to the right data.
            SharedPreferences sp = getSharedPreferences("HOURLY", MODE_PRIVATE);

            //StringBuffer to append the data for display.
            StringBuffer StringBuffer = new StringBuffer();
            if (Objects.equals(sp.getString("HourlyDetails", "null"), "0")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[0][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[0][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[0][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[0][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[0][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "1")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[1][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[1][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[1][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[1][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[1][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "2")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[2][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[2][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[2][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[2][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[2][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "3")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[3][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[3][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[3][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[3][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[3][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "4")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[4][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[4][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[4][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[4][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[4][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "5")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[5][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[5][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[5][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[5][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[5][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "6")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "7")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "8")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");

            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "9")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");

            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "10")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("HourlyDetails", "null"), "11")) {
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");
            }

            return StringBuffer.toString();
        }

        /**
         * The final method that gets called to display the String into the textview.
         *
         * @param _results
         */
        protected void onPostExecute(String _results) {
            details.setText(_results);
        }
    }
}
