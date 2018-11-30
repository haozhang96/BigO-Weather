package edu.uncg.csc.bigo.weather.views.activities;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;
import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;
import edu.uncg.csc.bigo.weather.models.weather.Icons;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyWeather extends Fragment {

    private TextView dailyMessage;
    private ImageView monday;
    private ImageView tuesday;
    private ImageView wednesday;
    private ImageView thursday;
    private ImageView friday;
    private ImageView saturday;
    private ImageView sunday;
    private String[][] dailyWeatherForecastController;


    public DailyWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_daily_weather, container, false);

        //Initialize the message TextView box
        dailyMessage = (TextView) v.findViewById(R.id.dailyMessage);

        //
        monday = (ImageView) v.findViewById(R.id.monday);

        //
        tuesday = (ImageView) v.findViewById(R.id.tuesday);

        //
        wednesday = (ImageView) v.findViewById(R.id.wednesday);

        //
        thursday = (ImageView) v.findViewById(R.id.thursday);

        //
        friday = (ImageView) v.findViewById(R.id.friday);

        //
        saturday = (ImageView) v.findViewById(R.id.saturday);

        //
        sunday = (ImageView) v.findViewById(R.id.sunday);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        new Test().execute();
    }

    /**
     * This is where we will test things
     */
    public class Test extends AsyncTask<Void, Void, String> {


        protected String doInBackground(Void... nothing) {
            try {

                // Store a message buffer to append strings to.
                StringBuffer message = new StringBuffer();

                //Get the zipcode entered by the user.
                int zipCode = 27407;

                //Testing the WeatherController methods
                message.append("Daily: \n");
                dailyWeatherForecastController = WeatherController.getWeatherDailyForecast(zipCode);
                message.append(dailyWeatherForecastController[0][Globals.CITY_STATE_ZIP] + "\n");
                for (int i = 0; i < 7; i++) {
                    message.append(dailyWeatherForecastController[i][Globals.TIME] + "\n");
                    message.append(dailyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    message.append("High: " + dailyWeatherForecastController[i][Globals.TEMP_HIGH]);
                    message.append(", Low: " + dailyWeatherForecastController[i][Globals.TEMP_LOW] + "\n\n");
                    message.append("Icon: " + dailyWeatherForecastController[i][Globals.ICON] + "\n\n");
                }
                message.append("\n");

                return message.toString();
            } catch (Exception exception) {
                return exception.toString();
            }

        }

        protected void onPostExecute(String result) {

            ImageView[] days = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};

            for (int i = 0; i < 7; i++) {
                switch (dailyWeatherForecastController[i][Globals.ICON]) {
                    case "clear-day":
                        Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(clear_day.getIconResId());
                        break;

                    case "clear-night":
                        Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(clear_night.getIconResId());
                        break;

                    case "cloudy":
                        Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(cloudy.getIconResId());
                        break;

                    case "fog":
                        Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(fog.getIconResId());
                        break;

                    case "partly-cloudy-day":
                        Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(partly_cloudy_day.getIconResId());
                        break;

                    case "partly-cloudy-night":
                        Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(partly_cloudy_night.getIconResId());
                        break;

                    case "rain":
                        Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(rain.getIconResId());
                        break;

                    case "sleet":
                        Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(sleet.getIconResId());
                        break;

                    case "snow":
                        Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(snow.getIconResId());
                        break;

                    case "wind":
                        Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                        days[i].setImageResource(wind.getIconResId());
                        break;
                }
            }
            dailyMessage.setText(result);
        }
    }
}


