package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Context;
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

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentWeather extends Fragment {


    private TextView temperature;
    private TextView currentMessage;
    private ImageView image;
    public int zipCode;

    private static String[] currentWeatherController;

    public CurrentWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_current_weather, container, false);

        //Initialize the image box
        image = v.findViewById(R.id.imageView);

        //Initialize the message TextView box
        currentMessage = v.findViewById(R.id.currentMessage);

        temperature = v.findViewById(R.id.temperature);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new Test().execute();
    }

    public class Test extends AsyncTask<Void, Void, Wrapper> {

        protected Wrapper doInBackground(Void... nothing) {

            Wrapper w = new Wrapper();

            try {

                SharedPreferences sp = getActivity().getSharedPreferences("GLOBAL", MODE_PRIVATE);

                sp.getInt("ZIP", 10001);

                currentWeatherController = WeatherController.getWeatherCurrent(sp.getInt("ZIP", 10001));
                // Store a message buffer to append strings to.
                StringBuffer StringBuffer = new StringBuffer();

                String temp = currentWeatherController[Globals.APPARENT_TEMPERATURE];

                StringBuffer.append(currentWeatherController[Globals.CITY_STATE_ZIP] + "\n");
                StringBuffer.append("Summary: " + currentWeatherController[Globals.SUMMARY] + "\n");
                StringBuffer.append("Precipitation: " + currentWeatherController[Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Humidity: " + currentWeatherController[Globals.HUMIDITY] + "\n");
                StringBuffer.append("Wind Speed: " + currentWeatherController[Globals.WIND_SPEED] + "\n");
                StringBuffer.append("Icon: " + currentWeatherController[Globals.ICON] + "\n");

                w.currentMessage = StringBuffer.toString();
                w.temperature = temp;
            } catch (Exception exception) {
                w.currentMessage = "ERROR";
            }
            return w;
        }

        protected void onPostExecute(Wrapper w) {
            switch (currentWeatherController[Globals.ICON]) {
                case "clear-day":
                    Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(clear_day.getIconResId());
                    break;

                case "clear-night":
                    Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(clear_night.getIconResId());
                    break;

                case "cloudy":
                    Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(cloudy.getIconResId());
                    break;

                case "fog":
                    Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(fog.getIconResId());
                    break;

                case "partly-cloudy-day":
                    Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(partly_cloudy_day.getIconResId());
                    break;

                case "partly-cloudy-night":
                    Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(partly_cloudy_night.getIconResId());
                    break;

                case "rain":
                    Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(rain.getIconResId());
                    break;

                case "sleet":
                    Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(sleet.getIconResId());
                    break;

                case "snow":
                    Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(snow.getIconResId());
                    break;

                case "wind":
                    Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                    image.setImageResource(wind.getIconResId());
                    break;
            }
            currentMessage.setText(w.currentMessage);
            temperature.setText(w.temperature);
        }
    }
}
