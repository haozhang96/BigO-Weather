package edu.uncg.csc.bigo.weather.views.activities;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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

        for (int i = 0; i < 7; i++) {
            buttons[i] = findViewById(buttonID[i]);
        }

        details = findViewById(R.id.textView);

        new DetailedDataRetrieval().execute();

    }


    protected class DetailedDataRetrieval extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            SharedPreferences sp = getSharedPreferences("GLOBAL", MODE_PRIVATE);


            try {
                detailedWeatherForecastController = WeatherController.getWeatherDailyForecast(sp.getInt("ZIP", 27403));
            } catch (Exception e) {
                e.printStackTrace();
            }

            StringBuffer test = new StringBuffer();
            test.append(detailedWeatherForecastController[0][5]);

            return test.toString();
        }

        protected void onPostExecute(String results) {
            details.setText(results);
        }
    }
}
