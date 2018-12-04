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
 * This class shows the detailed version of Daily Weather. It shows precipitation, wind speed, wind
 * gust, humidity, moon phase, and ozone.
 *
 * @Updated: 12/3/2018
 * @Author Steven Tran
 */
public class DailyDetailed extends AppCompatActivity {


    //The buttons for each of the days to show detailed data.
    private Button detailedOne;
    private Button detailedTwo;
    private Button detailedThree;
    private Button detailedFour;
    private Button detailedFive;
    private Button detailedSix;
    private Button detailedSeven;

    //The textview for the details.
    private TextView details;

    //The detailed weather controller.
    private String[][] detailedWeatherForecastController;

    //An array of buttons for looping purposes.
    private Button[] buttons = {detailedOne, detailedTwo, detailedThree, detailedFour,
            detailedFive, detailedSix, detailedSeven};

    //An array of integers that contain the button's ID.
    private Integer[] buttonID = {R.id.detailedOne, R.id.detailedTwo, R.id.detailedThree,
            R.id.detailedFour, R.id.detailedFive, R.id.detailedSix, R.id.detailedSeven};

    /**
     * This method is create when this activity starts up to initialize the variables and execute
     * the AsyncTask.
     *
     * @param _savedInstanceState
     */
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        //Sets view to Daily Detailed.
        setContentView(R.layout.activity_daily_detailed);

        //Creates the back button.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize the buttons.
        for (int i = 0; i < 7; i++) {
            buttons[i] = findViewById(buttonID[i]);
        }

        //Initialize the textview.
        details = findViewById(R.id.dailyDetails);

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

            //Shared preference for daily detail.
            SharedPreferences global = getSharedPreferences("GLOBAL", MODE_PRIVATE);


            try {
                //Initializing the controller to get the Daily weather forecast.
                detailedWeatherForecastController = WeatherController.getWeatherDailyForecast(global.getInt("ZIP", 27403));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //The shared preference to get the data from DailyWeather's shared preference.
            SharedPreferences sp = getSharedPreferences("DAILY", MODE_PRIVATE);

            //StringBuffer to append messages if it matches the SharedPreference key.
            StringBuffer StringBuffer = new StringBuffer();
            if (Objects.equals(sp.getString("DailyDetails", "null"), "0")) {
                StringBuffer.append(detailedWeatherForecastController[0][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[0][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[0][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[0][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[0][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[0][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[0][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "1")) {
                StringBuffer.append(detailedWeatherForecastController[1][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[1][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[1][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[1][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[1][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[1][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[1][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "2")) {
                StringBuffer.append(detailedWeatherForecastController[2][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[2][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[2][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[2][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[2][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[2][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[2][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "3")) {
                StringBuffer.append(detailedWeatherForecastController[3][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[3][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[3][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[3][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[3][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[3][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[3][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "4")) {
                StringBuffer.append(detailedWeatherForecastController[4][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[4][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[4][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[4][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[4][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[4][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[4][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "5")) {
                StringBuffer.append(detailedWeatherForecastController[5][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[5][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[5][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[5][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[5][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[5][Globals.MOON_PHASE] + "\n");
                StringBuffer.append("Ozone: " + detailedWeatherForecastController[5][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("DailyDetails", "null"), "6")) {
                StringBuffer.append(detailedWeatherForecastController[6][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                StringBuffer.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                StringBuffer.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                StringBuffer.append("Moon Phase: " + detailedWeatherForecastController[6][Globals.MOON_PHASE] + "\n");
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

