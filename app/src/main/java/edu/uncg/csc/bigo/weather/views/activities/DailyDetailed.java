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


public class DailyDetailed extends AppCompatActivity {


    private Button detailedOne;
    private Button detailedTwo;
    private Button detailedThree;
    private Button detailedFour;
    private Button detailedFive;
    private Button detailedSix;
    private Button detailedSeven;

    private TextView details;

    private String[][] detailedWeatherForecastController;

    private Button[] buttons = {detailedOne, detailedTwo, detailedThree, detailedFour,
            detailedFive, detailedSix, detailedSeven};


    private Integer[] buttonID = {R.id.detailedOne, R.id.detailedTwo, R.id.detailedThree,
            R.id.detailedFour, R.id.detailedFive, R.id.detailedSix, R.id.detailedSeven};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_detailed);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 7; i++) {
            buttons[i] = findViewById(buttonID[i]);
        }

        details = findViewById(R.id.textView);

        new DetailedDataRetrieval().execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    protected class DetailedDataRetrieval extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            SharedPreferences global = getSharedPreferences("GLOBAL", MODE_PRIVATE);


            try {
                detailedWeatherForecastController = WeatherController.getWeatherDailyForecast(global.getInt("ZIP", 27403));
            } catch (Exception e) {
                e.printStackTrace();
            }

            SharedPreferences sp = getSharedPreferences("please", MODE_PRIVATE);
            StringBuffer test = new StringBuffer();
            if (Objects.equals(sp.getString("GO", "null"), "0")) {
                test.append("Precipitation: " + detailedWeatherForecastController[0][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[0][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[0][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[0][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[0][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[0][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "1")) {
                test.append("Precipitation: " + detailedWeatherForecastController[1][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[1][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[1][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[1][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[1][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[1][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "2")) {
                test.append("Precipitation: " + detailedWeatherForecastController[2][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[2][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[2][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[2][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[2][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[2][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "3")) {
                test.append("Precipitation: " + detailedWeatherForecastController[3][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[3][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[3][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[3][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[3][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[3][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "4")) {
                test.append("Precipitation: " + detailedWeatherForecastController[4][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[4][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[4][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[4][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[4][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[4][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "5")) {
                test.append("Precipitation: " + detailedWeatherForecastController[5][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[5][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[5][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[5][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[5][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[5][Globals.OZONE] + "\n");
            } else if (Objects.equals(sp.getString("GO", "null"), "6")) {
                test.append("Precipitation: " + detailedWeatherForecastController[6][Globals.PRECIP_PROBABILITY] + "\n");
                test.append("Wind Speed: " + detailedWeatherForecastController[6][Globals.WIND_SPEED] + "\n");
                test.append("Wind Gust: " + detailedWeatherForecastController[6][Globals.WIND_GUST] + "\n");
                test.append("Humidity: " + detailedWeatherForecastController[6][Globals.HUMIDITY] + "\n");
                test.append("Moon Phase: " + detailedWeatherForecastController[6][Globals.MOON_PHASE] + "\n");
                test.append("Ozone: " + detailedWeatherForecastController[6][Globals.OZONE] + "\n");
            }

            return test.toString();
        }

        protected void onPostExecute(String results) {
            details.setText(results);
        }
    }
}

